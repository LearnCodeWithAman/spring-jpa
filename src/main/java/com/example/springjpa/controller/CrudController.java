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

    public void run(){

        findAllUsers();

        //inserting an element
        /*System.out.println("Inserting a user *********");
        User user1 = new User();
        user1.setName("Mathur");
        user1.setCity("Gurgaon");
        user1.setStatus("Manager");
        user1.setSalary(170000);
        //user.setId(5);
        User user = insertUser(user1);*/

        //finding by name
		/*System.out.println("Finding by Name");
		List<User> users = findByName("Gerard");
		users.forEach(System.out::println);*/

        //finding by status
		/*System.out.println("Finding by Status");
		List<User> users = findByStatus("Software Engineer");
		users.forEach(System.out::println);*/

        //finding by city and status
		System.out.println("Finding by City and Status");
		List<User> users = findByCityAndStatus("Gurgaon","Software Engineer");
		users.forEach(System.out::println);
    }

    public User insertUser(User user1) {

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
