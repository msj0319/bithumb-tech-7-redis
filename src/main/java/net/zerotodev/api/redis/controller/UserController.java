package net.zerotodev.api.redis.controller;

import lombok.RequiredArgsConstructor;
import net.zerotodev.api.redis.domain.User;
import net.zerotodev.api.redis.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        return userService.findById(id);
    }
    @PostMapping
    public ResponseEntity<User> createPerson(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity(CREATED);
    }


}