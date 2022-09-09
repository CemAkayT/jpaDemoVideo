package cem.jpademovideo.service;

import cem.jpademovideo.model.User;
import cem.jpademovideo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service // skal dukke op i Spring miljøet så vi kan bruge den fra controlleren
public class UserService implements IUserService{

    //skal have et objekt fra UserReposityory interface
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) { // vi får et UserRepository objekt
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Set<User> findAll() {
        Set<User> userSet = new HashSet<>(); // opretter tomt set
        userRepository.findAll().forEach(userSet::add); // man skal give den en metode som parameter. For hver User der er i findAll, skal de puttes i userSet. Dobbel kolon betyder man giver metode med
        return userSet;
    }

    @Override
    public User save(User user) {
        userRepository.save(user); // kalder userrepo interface metoden
        return user;
    }


    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    // skal implementere metoder fra IUserService

}
