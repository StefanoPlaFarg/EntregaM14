/**
 * 
 */
package com.application.domain;


/**
 * @author stefano
 *
 */
public class PaintingDTO {
	
  
	
	private String paintingName;
	
	private String authorName;
	
	private double price;

	
	public PaintingDTO() {

	}

	public PaintingDTO(String paintingName,String authorName, double price) {

		this.authorName = authorName;
		this.price = price;
		this.paintingName = paintingName;

	}

	/**
	 * @return the paintingName
	 */
	public String getPaintingName() {
		return paintingName;
	}

	/**
	 * @param paintingName the paintingName to set
	 */
	public void setPaintingName(String paintingName) {
		this.paintingName = paintingName;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
