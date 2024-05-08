package me.calcifer.redistest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    @Qualifier("jdkRedisTemplate")
//    private RedisTemplate jdkRedisTemplate;

    @Autowired
//    @Qualifier("jsonRedisTemplate")
    private RedisTemplate redisTemplate;

//    @Autowired
//    @Qualifier("byteRedisTemplate")
//    private RedisTemplate byteRedisTemplate;

//    public Object get(String key, int valueType) {
//        Object result;
//
//        switch (valueType) {
//            case 0 -> result = getStringValue(key);
//            case 1 -> result = getObjectValue(key);
//            case 2 -> result = getJsonValue(key);
//            case 3 -> result = getByteValue(key);
//            default -> throw new IllegalStateException("Unexpected value: " + valueType);
//        }
//        return result;
//    }
//
//    public Boolean cache (String key, Object value ,int valueType) {
//        Boolean result;
//
//        switch (valueType) {
//            case 0 -> result = cache2String(key, (String) value);
//            case 1 -> result = cache2Object(key, value);
//            case 2 -> result = cache2Json(key, value);
//            case 3 -> result = cache2Byte(key, value);
//            default -> throw new IllegalStateException("Unexpected value: " + valueType);
//        }
//        return result;
//    }
//
//    public Boolean remove(String key, int valueType) {
//        Boolean result;
//        switch (valueType) {
//            case 0 -> result = deleteStringValue(key);
//            case 1 -> result = deleteObjectValue(key);
//            case 2 -> result = deleteJsonValue(key);
//            case 3 -> result = deleteByteValue(key);
//            default -> throw new IllegalStateException("Unexpected value: " + valueType);
//        }
//        return result;
//    }

    public String getStringValue(String key) {
        return (String) stringRedisTemplate.opsForValue().get(key);
    }

//    public Object getObjectValue(String key) {
//        return jdkRedisTemplate.opsForValue().get(key);
//    }

    public Object getJsonValue(String key) {
        return redisTemplate.opsForValue().get(key);

    }

//    public Object getByteValue(String key) {
//        return byteRedisTemplate.opsForValue().get(key);
//    }

    public Boolean cache2String(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return true;
    }

//    public Boolean cache2Object(String key, Object value) {
//        jdkRedisTemplate.opsForValue().set(key, value);
//        return true;
//    }

    public Boolean cache2Json(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

//    public Boolean cache2Byte(String key, Object value) {
//        byteRedisTemplate.opsForValue().set(key, value);
//        return true;
//    }

    public Boolean deleteStringValue(String key) {
        return stringRedisTemplate.delete(key);
    }

//    public Boolean deleteObjectValue(String key) {
//        return jdkRedisTemplate.delete(key);
//    }

    public Boolean deleteJsonValue(String key) {
        return redisTemplate.delete(key);

    }

//    public Boolean deleteByteValue(String key) {
//        return byteRedisTemplate.delete(key);
//    }
}
