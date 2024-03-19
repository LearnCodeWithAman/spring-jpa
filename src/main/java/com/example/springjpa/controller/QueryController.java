package com.example.springjpa.controller;

import com.example.springjpa.entity.User;
import com.example.springjpa.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryController {

    @Autowired
    UserQueryRepository userQueryRepo;

    public void run() {

        //select all
        System.out.println("Selecting all users");
        List<User> userList = getAllUsers();
        userList.forEach(System.out::println);

        //select all by city
        System.out.println("Selecting all user by city");
        List<User> list1 = getAllUsersByCity("Khalilabad");
        list1.forEach(System.out::println);

        //selecting all by city and status
        System.out.println("Selecting all users by city and status");
        List<User> list2 = getAllUsersByCityAndStatus("Gurgaon", "Software Engineer");
        list2.forEach(System.out::println);

        //selecting all through Native Query
        /*System.out.println("Selecting all users by Native Query");
        List<User> list3 = getUsers();
        list3.forEach(System.out::println);*/

        //selecting all by salary through Native Query
        /*System.out.println("Selecting all users by Salary");
        List<User> list4 = getUsersBySalary(100000);
        list4.forEach(System.out::println);*/
    }

    public List<User> getAllUsers(){

        return userQueryRepo.getAllUsers();
    }

    public List<User> getAllUsersByCity(String city){
        return userQueryRepo.getAllUsersByCity(city);
    }

    public List<User> getAllUsersByCityAndStatus(String city, String status) {
        return userQueryRepo.getAllUsersByCityAndStatus(city, status);
    }

    public  List<User> getUsers() {
        return userQueryRepo.getUsers();
    }

    public  List<User> getUsersBySalary(long salary) {
        return userQueryRepo.getUsersBySalary(salary);
    }

}
