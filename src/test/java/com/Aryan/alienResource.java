package com.Aryan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// rest full api
@RestController
public class alienResource {
        @RequestMapping("aliens")
	public List<alien> getalien(){
		List<alien>  aliens = new ArrayList<>();
		alien a = new alien();
		a.setMobile(21);
		a.setName("Aryan");
		
		alien a2 = new alien();
		a2.setMobile(1);
		a2.setName("Aryan Kamboj");
		aliens.add(a);
		aliens.add(a2);
		return aliens;
	}
	
	
}
