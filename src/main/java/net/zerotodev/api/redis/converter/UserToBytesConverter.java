package net.zerotodev.api.redis.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.zerotodev.api.redis.domain.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class UserToBytesConverter implements Converter<User, byte[]>{
    private final Jackson2JsonRedisSerializer<User> serializer;

    public UserToBytesConverter() {
        this.serializer = new Jackson2JsonRedisSerializer<>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(User user) {
        return serializer.serialize(user);
    }
}
