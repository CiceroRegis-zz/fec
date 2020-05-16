package br.com.fec.model.enums;

public enum Level {

	BEGINNER("BB-8"),
	INTERMEDIATE("Chewbacca"),
	ADVANCED("Jedi");
	
	
private String description;
	
	Level(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
