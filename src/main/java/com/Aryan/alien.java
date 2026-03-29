package com.Aryan;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@EntityScan
public class alien {
  
  @Id    // this ID make the mobile number as the primary key
  int mobile; 
  String name;

  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public int getMobile() {
	return mobile;
  }
  public void setMobile(int mobile) {
	this.mobile = mobile;
  }
  
  @Override
  public String toString() {
    return "alien [name=" + name + ", mobile=" + mobile + "]";
  }
}
