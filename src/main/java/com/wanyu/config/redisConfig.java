package com.wanyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by samsung on 2018/1/14.
 */
@Configuration
public class redisConfig {
    @Bean
    public<T> RedisTemplate<String,T> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String,T> template=new RedisTemplate<String,T>();
        template.setConnectionFactory(connectionFactory);
       //错了！ template.setStringSerializer(new StringRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
