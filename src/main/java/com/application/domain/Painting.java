/**
 * 
 */
package com.application.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;

import java.time.LocalDate;
import java.sql.Timestamp;

/**
 * @author stefano
 *
 */

@Entity
@Table(name = "paintingsShop")
public class Painting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPainting", updatable = false)
	private long id;
  
	@Column(name = "NamePainting", nullable = false)
	private String paintingName;

	@Column(name = "AuthorPainting")
	private String authorName;

	@Column(name = "PricePainting", nullable = false)
	private double price;

	@Column(name = "registDatePainting", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar registDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IdShop", nullable = false)
	private Shop shop;

	public Painting() {

	}

	public Painting(String paintingName,String authorName , double price, Calendar registDate) {

		this.paintingName=paintingName;
		this.authorName = authorName;
		this.price = price;
		this.registDate = registDate;

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

	/**
	 * @return the registDate
	 */
	public Calendar getRegistDate() {
		return registDate;
	}

	/**
	 * @param registDate the registDate to set
	 */
	public void setRegistDate(Calendar registDate) {
		this.registDate = registDate;
	}

	/**
	 * @return the shop
	 */
	public Shop getShop() {
		return shop;
	}

	/**
	 * @param shop the shop to set
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	
	
	
}
