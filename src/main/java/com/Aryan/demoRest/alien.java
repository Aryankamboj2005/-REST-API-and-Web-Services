package com.Aryan.demoRest;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class alien {
  String name;
  int mobile;
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
