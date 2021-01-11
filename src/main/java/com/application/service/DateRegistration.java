/**
 * 
 */
package com.application.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

/**
 * @author stefano
 *
 */

@Service
public class DateRegistration {
	
	private long currentDate = System.currentTimeMillis();
	Date sqlDate = new Date(currentDate);
	
	public String getCurrentDate() {
		
		return sqlDate.toString();
		
	}

}
