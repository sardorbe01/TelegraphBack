package uz.es.telegraph.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.es.telegraph.dto.UserCreatedDto;
import uz.es.telegraph.entity.UserEntity;
import uz.es.telegraph.repository.UserRepository;
import uz.es.telegraph.service.UserService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/api/v1/sign-in")
    public UserEntity signIn(
            @RequestParam String phoneNumber,
            @RequestParam String password
    ) {
        return userService.signIn(phoneNumber, password);
    }

    @PostMapping("/api/v1/sign-up")
    public UserEntity SignUp(
            @RequestBody UserCreatedDto userCreatedDto
    ) {
        return userService.add(userCreatedDto);
    }

}
8