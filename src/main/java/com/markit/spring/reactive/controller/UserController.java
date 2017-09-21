package com.markit.spring.reactive.controller;

import com.markit.spring.reactive.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by aditya.gupta2 on 9/21/2017.
 */
@RestController
public class UserController {


    @Value("{$url}")
    private String url;


    @GetMapping("/users")
    public Mono<ServerResponse> getAllUsers() {
        return WebClient.create(url).get().uri("/api/user").accept(MediaType.APPLICATION_JSON).exchange()
                .flatMap(response -> ServerResponse.ok().body(response.bodyToFlux(User.class), User.class));

    }

    @GetMapping("/users/{id}")
    public Mono<ServerResponse> getUserById(@PathVariable String id) {
        return WebClient.create(url).get().uri("/api/user/" + id).accept(MediaType.APPLICATION_JSON).exchange().
                flatMap(response -> ServerResponse.ok().body(response.bodyToMono(User.class), User.class));
    }
}
