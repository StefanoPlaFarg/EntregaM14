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
public interface PaintingsRepository extends CrudRepository<Painting,Long> {
	
	
}
