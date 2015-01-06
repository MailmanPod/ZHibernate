package org.polux.domain;

public class Engine {

	private long id;
	private String name;
	private int power;
	private String isERS;
	
	public Engine() {
	}

	public Engine(String name, int power, String isERS) {
		this.name = name;
		this.power = power;
		this.isERS = isERS;
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getIsERS() {
		return isERS;
	}

	public void setIsERS(String isERS) {
		this.isERS = isERS;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Engine [id=").append(id).append(", name=").append(name)
				.append(", power=").append(power).append(", isERS=")
				.append(isERS).append("]");
		return builder.toString();
	}
	
}
