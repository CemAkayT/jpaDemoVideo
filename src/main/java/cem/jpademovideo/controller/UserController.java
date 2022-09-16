package cem.jpademovideo.controller;

import cem.jpademovideo.model.User;
import cem.jpademovideo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController // vi arbejder med Rest
public class UserController {

    private UserService userService; // vi skal instantiere et objekt her vi kan kalde

    public UserController(UserService userService) { // og lave en konstruktor til linje 9
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Set<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> users(@RequestBody User user) {
        String msg;
        if(userService.save(user)!= null){
            msg = "Oprettet bruger: " + user.getName();
        } else{
            msg = "Fejl i oprettelsen";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Set<User>> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete") // bruger den ikke
    public void deleteUser(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping("existsById/{id}")
    public boolean exists(@PathVariable("id") Long id) {
        return userService.existsById(id);
    }

   @PutMapping("/update")
    public ResponseEntity<Set<User>> update(Long id, @RequestBody User user) {
        userService.findById(id);
        userService.save(user);
       return new ResponseEntity<>(HttpStatus.OK);
   }

   /* @PutMapping("/update/{id}/{newName}/{newAge}")
    public ResponseEntity<Set<User>> update(@PathVariable("id") Long id, @PathVariable("newName") String newName, @PathVariable("newAge") int newAge, User user) {
        userService.findById(id);
        user.setName(newName);
        user.setAge(newAge);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
