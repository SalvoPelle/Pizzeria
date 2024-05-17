package models;

import java.util.List;

public class Ordine {
	
	private Integer id;
	
	private String isOpen = "y";
	
	private List<Pizza> ordineTavolo;
	
	public Ordine() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public List<Pizza> getOrdine() {
		return ordineTavolo;
	}

	public void setOrdineTavolo(List<Pizza> ordineTavolo) {
		this.ordineTavolo = ordineTavolo;
	}
	
}
