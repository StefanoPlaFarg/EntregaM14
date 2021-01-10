/**
 * 
 */
package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.domain.*;

/**
 * @author stefano
 *
 */
public interface ShopsRepository extends CrudRepository<Shop,Long>  {

	Shop findByName (String name);
	
}
