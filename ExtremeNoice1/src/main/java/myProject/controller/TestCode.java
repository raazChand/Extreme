package myProject.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCode {
	
	public static void main(String args[]) {
	BCryptPasswordEncoder password = new BCryptPasswordEncoder();
	String hashcode = password.encode("456");
	System.out.println(hashcode);
	}
}
