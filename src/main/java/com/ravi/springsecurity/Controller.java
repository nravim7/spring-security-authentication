package com.ravi.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String sayHello() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String sayHelloUser() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
