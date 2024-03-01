
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dog extends Animal {
	
	//Used in Question1Client
	/*
	@Column(name="barking_level")
	private Integer barkingLevel;
	public void setBarkingLevel(Integer barkingLevel) {
		this.barkingLevel = barkingLevel;
	}
	*/

	@Override
	public String makeNoise() {
		return "woof woof..";
	}

}










