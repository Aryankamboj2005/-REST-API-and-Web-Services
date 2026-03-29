package com.Aryan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAlien {
	@Autowired   // auto create the onject 
	AlienRepo repo;
 @GetMapping("aliens")
 public List<alien> getAliens(){
	 List<alien> aliens = (List<alien>) repo.findAll();
	 
	 return aliens;
  }
}
