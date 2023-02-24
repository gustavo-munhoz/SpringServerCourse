package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.rest.reviews.Review;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {this.service = service;}

    @GetMapping("{id}")
    public User searchUser(@PathVariable(value = "id") Long id) {
        return service.getUser(id);
    }

    @GetMapping("/all")
    public List<User> showAllUsers() { return service.getAllUsers();}

    @GetMapping("{id}/reviews")
    @RolesAllowed("USER")
    public List<Review> getAllReviews(@PathVariable("id") Long id) {
        return service.getReviewsByUser(id);
    }

    @PostMapping("/register")
    @PermitAll
    public User register(@Valid @RequestBody User user){
        return service.add(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }
}
