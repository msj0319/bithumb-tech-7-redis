package net.zerotodev.api.redis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return String.format("%s, %s, %s\n", id, name, email);
    }

}
