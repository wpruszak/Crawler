package com.wpruszak.crawler.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.CollectionFactory;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 24.03.17.
 */
@Configuration
@PropertySource("classpath:crawler.yml")
@EnableConfigurationProperties
public class CrawlerConfiguration {

    private static final String[] CONFIGURATION_FILES = {"crawler.yml", "secret.yml"};

    @Bean
    public Yaml yaml() {
        return new Yaml();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(Yaml yaml) throws IOException {

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer
            = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setProperties(CrawlerConfiguration.loadYamlConfiguration(yaml));

        return propertySourcesPlaceholderConfigurer;
    }

    private static Properties loadYamlConfiguration(Yaml yaml) throws IOException {

        Properties properties = CollectionFactory.createStringAdaptingProperties();
        for (String file : CrawlerConfiguration.CONFIGURATION_FILES) {
            Object parsedYaml = yaml.load(new ClassPathResource(file).getInputStream());
            properties.putAll(CrawlerConfiguration.fromParsedYaml(parsedYaml));
        }

        return properties;
    }

    @SuppressWarnings("unchecked")
    private static Properties fromParsedYaml(Object parsedYaml) {

        if (!(parsedYaml instanceof Map)) {
            return new Properties();
        }

        Map<Object, Object> yamlMap = (Map<Object, Object>) parsedYaml;

        return CrawlerConfiguration.mapToProperties(yamlMap);
    }

    private static Properties mapToProperties(Map<Object, Object> yamlMap) {

        List<String> list = new ArrayList<>();
        Map<String, Object> flattenedResult = new LinkedHashMap<>();
        flattenedResult = CrawlerConfiguration.recursiveFlatten(yamlMap, list, flattenedResult);
        Properties properties = CollectionFactory.createStringAdaptingProperties();
        properties.putAll(flattenedResult);

        return properties;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> recursiveFlatten(
        Map<Object, Object> toProcess,
        List<String> keyStack,
        Map<String, Object> result) {

        for (Map.Entry<Object, Object> entry : toProcess.entrySet()) {
            keyStack.add((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                CrawlerConfiguration.recursiveFlatten((Map<Object, Object>) entry.getValue(), keyStack, result);
            } else {
                result.put(keyStack.stream().collect(Collectors.joining(".")), entry.getValue());
                keyStack.remove(keyStack.size() - 1);
            }
        }

        return result;
    }
}
