package net.zerotodev.api.redis.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.zerotodev.api.redis.domain.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

//메모리에 저장된 값을 User로 변환하여 가져오는 코드
@Component @ReadingConverter
public class BytesToUserConverter implements Converter<byte[], User> {
    private final Jackson2JsonRedisSerializer<User> serializer;

    public BytesToUserConverter() {
        this.serializer = new Jackson2JsonRedisSerializer<>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }
    //역직렬화는 메모리값을 사람이 이해하는 형태로 변환하는 과정
    @Override
    public User convert(byte[] source) {
        return serializer.deserialize(source);
    }
}
