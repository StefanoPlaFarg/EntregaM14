/**
 * 
 */
package com.application.domain;



/**
 * @author stefano
 *
 */
public class ShopDTO {

	private String name;
	private int capacity;

	public ShopDTO() {

	}

	public ShopDTO(String name, int capacity) {

		this.name = name;
		this.capacity = capacity;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
