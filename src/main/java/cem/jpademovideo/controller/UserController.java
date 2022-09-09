package cem.jpademovideo.controller;

import cem.jpademovideo.model.User;
import cem.jpademovideo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController // vi arbejder med rest
public class UserController {

    private UserService userService; // vi skal instantiere et objekt her vi kan kalde

    public UserController(UserService userService) { // og lave en konstruktor til linje 9
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> users(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/getUsers")
    public ResponseEntity<Set<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

}
