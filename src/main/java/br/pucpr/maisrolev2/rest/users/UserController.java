package br.pucpr.maisrolev2.rest.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;
    public UserController(UserService service) {this.service = service;}

    @GetMapping
    public User searchUser(@RequestParam(value = "id") Long id) {
        return service.getUser(id);
    }
}
