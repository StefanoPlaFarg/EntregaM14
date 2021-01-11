/**
 * 
 */
package com.application.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.application.domain.Painting;
import com.application.domain.PaintingDTO;
import com.application.domain.Shop;
import com.application.domain.ShopDTO;

/**
 * @author stefano
 *
 */
@Service
public class MapPainting implements Map<PaintingDTO, Painting> {

	@Autowired
	DateRegistration dateRegistration;
	
	@Override
	public Painting mappingDTOToEntity(PaintingDTO paintingDTO) {

		Painting painting = new Painting(paintingDTO.getPaintingName(),paintingDTO.getAuthorName(),paintingDTO.getPrice(),dateRegistration.getCurrentDate() );
		return painting;
	}

	@Override
	public PaintingDTO mappingEntityToDTO(Painting painting) {

		PaintingDTO paintingDTO = new PaintingDTO(painting.getPaintingName(), painting.getAuthorName(),painting.getPrice());

		return paintingDTO;

	}
	
	
	
}
