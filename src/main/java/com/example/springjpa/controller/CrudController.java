package com.example.springjpa.controller;

import com.example.springjpa.entity.User;
import com.example.springjpa.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CrudController {

    @Autowired
    UserCrudRepository userCrudRepo;

    public User insertUser(User user1) {
        user1.setName("Mohini Gupta");
		user1.setCity("Lalganj");
		user1.setStatus("Business Analyst");
		//user1.setId(5);
		User user  = userCrudRepo.save(user1);
		return user;
    }

    public User findUserById(int id) {
        Optional<User> optional = userCrudRepo.findById(id);
        User user = optional.get();
        System.out.println(user);
        return user;
    }

    public void findAllUsers() {
        Iterable<User> userList =  userCrudRepo.findAll();
        userList.forEach(System.out::println);
    }

    public void deleteUserById(int id) {
        userCrudRepo.deleteById(id);
        System.out.println("UserId "+ id +" - Deleted ");
    }

    public List<User> findByName(String name) {
        return userCrudRepo.findByName(name);
    }

    public List<User> findByStatus(String status) {
        return userCrudRepo.findByStatus(status);
    }

    public List<User> findByCityAndStatus(String city,String status) {
        return userCrudRepo.findByCityAndStatus(city,status);
    }
}
