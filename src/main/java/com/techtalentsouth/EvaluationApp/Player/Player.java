package com.techtalentsouth.EvaluationApp.Player;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String height;
	private int shooting;
	private int passing;
	private int dribbling;
	private int defense;
	private String intangibles;
	
	Player(String name, String height) {
		this.name = name;
		this.height = height;
		this.shooting = 0;
		this.passing = 0;
		this.dribbling = 0;
		this.defense = 0;
		this.intangibles = null;
	}
	
	Player() {
		//empty constructor for Post form. 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int shooting) {
		this.shooting = shooting;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public int getDribbling() {
		return dribbling;
	}

	public void setDribbling(int dribbling) {
		this.dribbling = dribbling;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getIntangibles() {
		return intangibles;
	}

	public void setIntangibles(String intangibles) {
		this.intangibles = intangibles;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Player [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (height != null ? "height=" + height + ", " : "") + "shooting=" + shooting + ", passing=" + passing
				+ ", dribbling=" + dribbling + ", defense=" + defense + ", "
				+ (intangibles != null ? "intangibles=" + intangibles : "") + "]";
	}

}
