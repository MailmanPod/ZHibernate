package org.polux.domain;

public class Teams {

	private long id;
	private String name;
	private int constructor_champions;
	private int last_season;
	
	public Teams() {
	}

	public Teams(String name, int constructor_champions,
			int last_season) {
		this.name = name;
		this.constructor_champions = constructor_champions;
		this.last_season = last_season;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getConstructor_champions() {
		return constructor_champions;
	}

	public void setConstructor_champions(int constructor_champions) {
		this.constructor_champions = constructor_champions;
	}

	public int getLast_season() {
		return last_season;
	}

	public void setLast_season(int last_season) {
		this.last_season = last_season;
	}
}
