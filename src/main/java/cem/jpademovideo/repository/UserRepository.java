package cem.jpademovideo.repository;


import cem.jpademovideo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> { // hvilken type skal vi gemme? User og Long som id

}
