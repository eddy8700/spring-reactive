package com.markit.spring.reactive.handler;

import com.markit.spring.reactive.domain.User;
import com.markit.spring.reactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by aditya.gupta2 on 9/21/2017.
 */
@Service
public class UserHandler {


    @Autowired
    private UserRepository userRepository;


    public Mono<ServerResponse> findAllUsers(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userRepository.getAllUsers(), User.class);
    }

    public Mono<ServerResponse> findUserById(ServerRequest request) {
        return userRepository.getUserById(request.pathVariable("id")).flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }


}
