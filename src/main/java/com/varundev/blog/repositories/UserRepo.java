package com.varundev.blog.repositories;
import org.springframework.data.jpa.repository.*;
import com.varundev.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
}
