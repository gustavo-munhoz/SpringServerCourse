package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.lib.exception.NotFoundException;
import br.pucpr.maisrolev2.rest.reviews.Review;
import br.pucpr.maisrolev2.rest.reviews.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    public UserService(UserRepository userRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }


    public User add(User user) {return userRepository.save(user);}

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) return user.get();
        else throw new NotFoundException(id);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException(id);
        userRepository.deleteById(id);
    }

    public void getReviewsByUser(Long id) {
        //TODO
    }

}
