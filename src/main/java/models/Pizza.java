package models;

public class Pizza {
	
	private Integer id;
	
	private String name;
	
	private String ingredient;
	
	private Double price;
	
	private Integer idOrdine;
	

	public Pizza() {
	}

	public Pizza(Integer id, String name, String ingredient, Double price) {
		this.id = id;
		this.name = name;
		this.ingredient = ingredient;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}
}
