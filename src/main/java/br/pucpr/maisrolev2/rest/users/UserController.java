package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.rest.reviews.Review;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {this.service = service;}

    @GetMapping("{id}")
    @Transactional
    public User searchUser(@PathVariable(value = "id") Long id) {
        return service.getUser(id);
    }

    @GetMapping("/all")
    @Transactional
    public List<User> showAllUsers() { return service.getAllUsers();}

    @GetMapping("{id}/reviews")
    @Transactional
    @RolesAllowed("USER")
    @SecurityRequirement(name = "AuthServer")
    public List<Review> getAllReviews(@PathVariable("id") Long id) {
        return service.getReviewsByUser(id);
    }

    @PostMapping("/register")
    @PermitAll
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        service.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Transactional
    @RolesAllowed("USER")
    @SecurityRequirement(name = "AuthServer")
    public void update(@Valid @RequestBody User user) {
        service.update(user.getId(), user);
    }

    @DeleteMapping("{id}")
    @Transactional
    @RolesAllowed("USER")
    @SecurityRequirement(name = "AuthServer")
    public void delete(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }
}
