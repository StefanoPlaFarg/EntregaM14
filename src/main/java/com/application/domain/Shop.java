/**
 * 
 */
package com.application.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author stefano
 *
 */

@Entity
@Table (name="shopsFranchise")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column ( name = "IdShop", updatable = false)
	private Long id;
	
	@Column ( name = "NameShop", nullable = false)
	private String name;
	
	@Column (name = "CapacityShop", nullable = false)
	private int capacity;
	
	@OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    private List<Painting> paintingsList;
	
	public Shop() {
		
	}
	
	public Shop(String name, int capacity) {
		
		this.name=name;
		this.capacity=capacity;
		
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

	/**
	 * @return the paintingsList
	 */
	public List<Painting> getPaintingsList() {
		return paintingsList;
	}

	/**
	 * @param paintingsList the paintingsList to set
	 */
	public void setPaintingsList(List<Painting> paintingsList) {
		this.paintingsList = paintingsList;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	
	
}
