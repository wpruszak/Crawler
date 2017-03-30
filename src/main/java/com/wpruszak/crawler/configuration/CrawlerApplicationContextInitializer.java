package com.wpruszak.crawler.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 24.03.17.
 */
public class CrawlerApplicationContextInitializer
    implements ApplicationContextInitializer<AnnotationConfigApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerApplicationContextInitializer.class);

    private static final String[] CONFIGURATION_FILES = {"crawler.yml", "secret.yml"};

    @Override
    public void initialize(final AnnotationConfigApplicationContext applicationContext) {

        try {
            MapPropertySource mapPropertySource =
                new MapPropertySource(this.getPropertySourceName(), this.loadYamlConfiguration(new Yaml()));
            applicationContext.getEnvironment().getPropertySources().addFirst(mapPropertySource);
        } catch (IOException exception) {
            CrawlerApplicationContextInitializer.logger.error(Arrays.toString(exception.getStackTrace()));
        }
    }

    private String getPropertySourceName() {

        StringBuilder sb = new StringBuilder();
        sb.append("crawler: [");
        for (int i = 0; i < CrawlerApplicationContextInitializer.CONFIGURATION_FILES.length; i++) {
            sb.append(String.format("classpath:/%s", CrawlerApplicationContextInitializer.CONFIGURATION_FILES[i]));
            if (i + 1 != CrawlerApplicationContextInitializer.CONFIGURATION_FILES.length) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }

    private Map<String, Object> loadYamlConfiguration(Yaml yaml) throws IOException {

        Map<String, Object> properties = new LinkedHashMap<>();

        for (String file : CrawlerApplicationContextInitializer.CONFIGURATION_FILES) {
            Object parsedYaml = yaml.load(new ClassPathResource(file).getInputStream());
            properties.putAll(this.fromParsedYaml(parsedYaml));
        }

        return properties;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> fromParsedYaml(Object parsedYaml) {

        if (!(parsedYaml instanceof Map)) {
            return new LinkedHashMap<>();
        }

        Map<Object, Object> yamlMap = (Map<Object, Object>) parsedYaml;
        List<String> list = new ArrayList<>();
        Map<String, Object> flattenedResult = new LinkedHashMap<>();

        return this.recursiveFlatten(yamlMap, list, flattenedResult);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> recursiveFlatten(
        Map<Object, Object> toProcess,
        List<String> keyStack,
        Map<String, Object> result) {

        for (Map.Entry<Object, Object> entry : toProcess.entrySet()) {
            keyStack.add((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                this.recursiveFlatten((Map<Object, Object>) entry.getValue(), keyStack, result);
            } else {
                result.put(keyStack.stream().collect(Collectors.joining(".")), entry.getValue());
                keyStack.remove(keyStack.size() - 1);
            }
        }

        return result;
    }
}
