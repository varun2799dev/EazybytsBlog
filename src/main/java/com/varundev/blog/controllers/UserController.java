package com.varundev.blog.controllers;
import org.springframework.web.bind.annotation.*;
import com.varundev.blog.services.*;
import com.varundev.blog.payloads.*;
import java.util.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
@RestController
@RequestMapping("/api/users")
public class UserController {
      @Autowired
      private UserService userService;
      
      //POST- create user
      @PostMapping("/")
      public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
    	  UserDto createUserDto = this.userService.createUser(userDto);
    	  return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
      }
      
      //PUT -updateUser
      @PutMapping("/{userId}")
      public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
    	 
    	  UserDto updatedUser = this.userService.updateUser(userDto, userId);
    	 return ResponseEntity.ok(updatedUser);
      }
      
      //Delete - delete user
      @DeleteMapping("/{userId}")
      public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
    	  this.userService.deleteUser(userId);
    	  return new ResponseEntity<>(Map.of("message","User Deleted Successfully."), HttpStatus.OK);
      }
      
      //GET- getUser
      @GetMapping("/")
      public ResponseEntity<List<UserDto>> getAllUsers(){
    	  return ResponseEntity.ok(this.userService.getAllUsers());
      }
      
      @GetMapping("/{userId}")
      public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId ){
    	  return ResponseEntity.ok(this.userService.getUserById(userId));
    	  
      }
      
      
      
} 
