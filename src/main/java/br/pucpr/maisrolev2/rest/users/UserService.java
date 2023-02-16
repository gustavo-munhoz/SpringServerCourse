package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.lib.exception.NotFoundException;
import br.pucpr.maisrolev2.rest.reviews.Review;
import br.pucpr.maisrolev2.rest.reviews.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    public UserService(UserRepository userRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) return user.get();
        else throw new NotFoundException(id);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) throw new NotFoundException("users");
        return users;
    }

    public List<Review> getReviewsByUser(Long id) {
        List<Review> reviews = reviewRepository.findAllByUserId(id);

        if (reviews.isEmpty()) throw new NotFoundException(id);
        return reviews;
    }

    @Transactional
    public User add(User user) {return userRepository.save(user);}

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException(id);
        userRepository.deleteById(id);
    }
}
