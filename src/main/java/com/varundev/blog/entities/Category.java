package com.varundev.blog.entities;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY )
	 private Integer categoryId;
     
	 private String categoryTitle;
     private String categoryDescription;
     
}
