/**
 * 
 */
package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.domain.*;

/**
 * @author stefano
 *
 */

@Repository
public interface ShopsRepository extends CrudRepository<Shop,Long>  {

	Shop findByName (String name);
		
}
