package com.Aryan.demoRest;
import java.util.*;
import java.sql.*;

public class alienReporisatory {
    private static List<alien> Aliens = new ArrayList<>();

    static {
        alien a1 = new alien();
        a1.setMobile(90);
        a1.setName("Aryan");
        
        alien a2 = new alien();
        a2.setMobile(21);
        a2.setName("Kamboj");
        
        Aliens.add(a1);
        Aliens.add(a2);
    }
    
    public List<alien> getAliens() {
        return Aliens;
    }
    
    public alien getAlien(int mobile) {
    	for(alien a:Aliens) {
    		if(a.getMobile()==mobile) {
    			return a;
    		}
    	}
    	
    	return new alien();
    }

	public void create(alien a1) {
		Aliens.add(a1);
	}
}
