package com.varundev.blog.repositories;
import org.springframework.data.jpa.repository.*;
import com.varundev.blog.entities.*;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
       	

}
