package net.zerotodev.api.redis.service;

import lombok.RequiredArgsConstructor;
import net.zerotodev.api.redis.converter.BytesToUserConverter;
import net.zerotodev.api.redis.converter.UserToBytesConverter;
import net.zerotodev.api.redis.domain.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserService {
    private final BytesToUserConverter bytesToUserConverter;
    private final UserToBytesConverter userToBytesConverter;
    private final RedisTemplate redisTemplate;

    public void save(User user) {
        HashOperations operations = redisTemplate.opsForHash();
        operations.put("user",user.getId(), userToBytesConverter.convert(user));
    }
    public User findById(String id) {
        HashOperations operations = redisTemplate.opsForHash();
        return bytesToUserConverter.convert((byte[]) operations.get("user", id));
    }
}
