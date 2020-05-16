package br.com.fec.model.enums;

public enum Sexo {
	
	MAN("male"),
	WOMAN("female");
	
	private String description;
	
	Sexo(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	

}
