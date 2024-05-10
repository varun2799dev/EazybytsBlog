package com.varundev.blog.payloads;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    
	private int Id;
	private String name;
	private String email;
	private String password;
	private String about;
	
}
