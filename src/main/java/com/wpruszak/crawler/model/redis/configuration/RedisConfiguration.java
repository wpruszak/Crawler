package com.wpruszak.crawler.model.redis.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 26.03.17.
 */
@Configuration
@EnableRedisRepositories("com.wpruszak.crawler.model.redis")
@ConditionalOnProperty(name = "use.redis.session.store", havingValue = "false", matchIfMissing = true)
public class RedisConfiguration {

    private Environment environment;

    @Autowired
    public RedisConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "redisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(this.environment.getProperty("spring.redis.host"));
        jedisConnectionFactory.setPort(Integer.parseInt(this.environment.getProperty("spring.redis.port")));
        jedisConnectionFactory.setPassword(this.environment.getProperty("spring.redis.password"));
        return jedisConnectionFactory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setExposeConnection(true);
        return redisTemplate;
    }

    @Bean(name = "redisStringTemplate")
    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        return new StringRedisTemplate(jedisConnectionFactory);
    }

    @Bean(name = "redisCacheManager")
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setTransactionAware(true);
        redisCacheManager.setLoadRemoteCachesOnStartup(true);
        redisCacheManager.setUsePrefix(true);
        return redisCacheManager;
    }
}
