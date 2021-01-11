/**
 * 
 */
package com.application.service;



import com.application.domain.*;

/**
 * @author stefano
 *
 */


public interface Map <T,S> {

public S mappingDTOToEntity (T t) ;
public T mappingEntityToDTO (S s) ;	
	



}
