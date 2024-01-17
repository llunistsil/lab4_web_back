package ifmo.labs.lab4_web_back.controllers;

import ifmo.labs.lab4_web_back.repos.UserRepository;
import ifmo.labs.lab4_web_back.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(AuthService authService,UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/user/register")
    public void register(@RequestParam("login") String login, @RequestParam("password") String password) {
        authService.register(login, password);
    }
    @PostMapping("/user/login")
    public void login(@RequestHeader("Authorization") String authorization) {
        authService.check(authorization);
    }
    @Transactional
    @PostMapping("/user/delete")
    public void deleteUser(@RequestHeader("Authorization") String authorization) {
        String login = authService.check(authorization);
        userRepository.deleteByLogin(login);
    }
    @Transactional
    @DeleteMapping("/user/{login}")
    public void deleteIdUser(@PathVariable(name = "login") String login) {
        userRepository.deleteByLogin(login);
    }
}
