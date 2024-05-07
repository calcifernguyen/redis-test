package me.calcifer.redistest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
//    @Value("${spring.data.redis.host}")
//    private String redisHost;
//
//    @Value("${spring.data.redis.port}")
//    private int redisPort;
//
//    @Value("${spring.data.redis.password:#{null}}")
//    private String redisPassword;

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.create(connectionFactory);
    }

//    @Bean(name = "redisTemplateObject")
//    public RedisTemplate<String, Object> redisTemplateObject() {
//        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
//        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        return redisTemplate;
//    }
//
//    @Bean(name = "redisTemplateJson")
//    public RedisTemplate<String, Object> redisTemplateWithJsonSerializer() {
//        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        return redisTemplate;
//    }

//    @Bean
//    @Primary
//    public RedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost,
//                redisPort);
//        if (redisPassword != null) {
//            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
//        }
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }

//    @Bean
//    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        // Additional configuration...
//        return template;
//    }
}
