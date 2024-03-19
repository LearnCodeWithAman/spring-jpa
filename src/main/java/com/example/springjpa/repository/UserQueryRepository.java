package com.example.springjpa.repository;

import com.example.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQueryRepository extends CrudRepository<User,Integer> {

    @Query("select u FROM User u")
    public List<User> getAllUsers();

    @Query("select u FROM User u WHERE u.city= :ct")
    public List<User> getAllUsersByCity(@Param("ct") String city);

    @Query("select u FROM User u WHERE u.city= :ct AND u.status= :st")
    public List<User> getAllUsersByCityAndStatus(@Param("ct") String city, @Param("st") String status);

    @Query(value = "select * FROM User", nativeQuery = true)
    public List<User> getUsers();

    @Query(value = "select * FROM User WHERE salary> :sl", nativeQuery = true)
    public List<User> getUsersBySalary(@Param("sl") long salary);
}
