package com.example.springjpa;

import com.example.springjpa.controller.CrudController;
import com.example.springjpa.controller.QueryController;
import com.example.springjpa.entity.User;
import com.example.springjpa.repository.UserCrudRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(SpringJpaApplication.class, args);

		ConfigurableApplicationContext context =  SpringApplication.run(SpringJpaApplication.class, args);

		//CrudController controller = context.getBean(CrudController.class);
		QueryController controller = context.getBean(QueryController.class);

		controller.run();
	}

}
