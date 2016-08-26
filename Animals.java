package com.goingtothezoo;

public class Animals {

	private String animalID = null;
	private String species = null;
	private String typeOfCage = null;
	private String food = null;
	private String name = null;
	private float weight = 0.0f;

	public Animals() {
		super();
	}

	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getTypeOfCage() {
		return typeOfCage;
	}

	public void setTypeOfCage(String typesOfCage) {
		this.typeOfCage = typesOfCage;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Animals [animalID=" + animalID + ", species=" + species + ", typesOfCage=" + typeOfCage + ", food="
				+ food + ", name=" + name + ", weight=" + weight + "]";
	}

}
