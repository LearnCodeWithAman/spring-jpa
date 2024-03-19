package com.example.springjpa.repository;

import com.example.springjpa.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByStatus(String status);

    public List<User> findByCityAndStatus(String city, String status);
}
