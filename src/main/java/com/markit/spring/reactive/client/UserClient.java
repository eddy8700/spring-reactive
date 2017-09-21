package com.markit.spring.reactive.client;

import com.markit.spring.reactive.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/**
 * Created by aditya.gupta2 on 9/21/2017.
 */
public class UserClient {

    public static void main(String[] args) {
        ClientResponse clientResponse = WebClient.create("http://localhost:9000").get().uri("/api/user")
                .accept(MediaType.APPLICATION_JSON).exchange().block();

        assert clientResponse.statusCode().value() == 200;
        List<User> users = clientResponse.bodyToFlux(User.class).collectList().block();
        assert users.size() == 2;
        assert users.iterator().next().getUser().equals("aditya");
        User user = WebClient.create("http://localhost:9000").get().uri("/api/user/1")
                .accept(MediaType.APPLICATION_JSON).exchange().flatMap(resp -> resp.bodyToMono(User.class)).block();
        assert user.getId() == 1;
        assert user.getUser().equals("User1");

        clientResponse = WebClient.create("http://localhost:9000").get().uri("/api/user/10")
                .accept(MediaType.APPLICATION_JSON).exchange().block();
        assert clientResponse.statusCode().value() == 404;
    }
}
