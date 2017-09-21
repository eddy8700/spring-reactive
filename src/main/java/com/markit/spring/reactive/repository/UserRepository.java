package com.markit.spring.reactive.repository;

import com.markit.spring.reactive.domain.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aditya.gupta2 on 9/21/2017.
 */

@Repository
public class UserRepository {

    private final List<User> users= Arrays.asList(new User(1L,"aditya"),new User(2L,"john"));


    public Mono<User> getUserById(String id){
         return Mono.justOrEmpty(users.stream().filter(user -> {
            return user.getId().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }


    public Flux<User> getAllUsers(){
        return Flux.fromIterable(users);
    }

}
