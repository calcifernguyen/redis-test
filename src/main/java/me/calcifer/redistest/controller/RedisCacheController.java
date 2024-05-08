package me.calcifer.redistest.controller;

import me.calcifer.redistest.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cache")
public class RedisCacheController {
    @Autowired
    RedisCacheService redisCacheService;

    @GetMapping("/get-value")
    public ResponseEntity<Object> getValue(@RequestParam String type, @RequestParam String key) {
        Object result;
        switch (type) {
            case "string" -> result = redisCacheService.getStringValue(key);
//            case "object" -> result = redisCacheService.getObjectValue(key);
            case "json" -> result = redisCacheService.getJsonValue(key);
//            case "byte" -> result = redisCacheService.getByteValue(key);
            default -> throw new IllegalStateException("Unexpected type: " + type);
        }
        return ResponseEntity.ok(result);
    }
}