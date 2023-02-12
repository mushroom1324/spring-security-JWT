package com.example.jwt.controller;


import com.example.jwt.config.auth.PrincipalDetails;
import com.example.jwt.model.User;
import com.example.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestApiController {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("user")
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal : " + principal.getUser().getId());
        System.out.println("principal : " + principal.getUser().getUsername());
        System.out.println("principal : " + principal.getUser().getPassword());

        return "<h1>user</h1>";
    }

    @PostMapping("/token")
    public String token() {

        return "<h1>token</h1>";
    }

    @GetMapping("/home")
    public String home() {

        return "<h1>home</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        userRepository.save(user);
        return "registration complete.";
    }

    // user, manager, admin
    @GetMapping("/api/v1/user")
    public String user() {
        return "user";
    }

    // manager, admin
    @GetMapping("/api/v1/manager")
    public String manager() {
        return "manager";
    }

    // admin
    @GetMapping("/api/v1/admin")
    public String admin() {
        return "admin";
    }
}
