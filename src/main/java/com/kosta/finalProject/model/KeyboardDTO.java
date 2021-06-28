package com.kosta.finalProject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyboardDTO {
	private String type;
	private String[] buttons;
	
	public KeyboardDTO(String[] buttons) {
		this.type="buttons";
		this.buttons=buttons;
	}
	
}
