/**
 * 
 */
package com.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.domain.*;
import com.application.repository.*;

/**
 * @author stefano
 *
 */

@Service
public class FranchiseService {

	@Autowired
	private PaintingsRepository paintingsRepository;
	
	@Autowired
	private ShopsRepository shopsRepository;
	
	@Autowired
	private MapShop mapShop;
	
	@Autowired
	private MapPainting mapPainting;
	
	//Shops
	public String addShop(ShopDTO shopDTO) {
        
		Shop shop = mapShop.mappingDTOToEntity(shopDTO);
		
		shopsRepository.save(shop);
		
		return "Shop saved";

		
	}
	
	public ShopDTO getShopById(long idShop) {
		
		Shop shop = shopsRepository.findById(idShop);
		ShopDTO shopDTO = mapShop.mappingEntityToDTO(shop);
		
		return shopDTO;		
		
	}
	
	public String updateShop (long idShop, ShopDTO shopDTO) {
		
		Shop shopToUpdate = shopsRepository.findById(idShop);
		
        if (shopToUpdate==null) {
			
			return "The shop with id: " + idShop +  " doesn't exist";
		}
		
		else {
			
						
			Shop shopUpdated = mapShop.mappingDTOToEntity(shopDTO );
			
			shopToUpdate.setName(shopUpdated.getName());
			shopToUpdate.setCapacity(shopUpdated.getCapacity());
			
			return "Shop updated";
		}
		
		
		
	}
	

	public String deleteShop(long idShop) {
		
		Shop shop = shopsRepository.findById(idShop);
		
		if (shop==null) {
			
			return "The shop with id: " + idShop +  " doesn't exist";
		}
		
		else {
			
			deletePaintingsOfShop(idShop);
			shopsRepository.deleteById(idShop);
			
			return "Shop deleted";
		}
		
	}

	/**
	 * Metode que transforma una llista de Shops a una llista de ShopsDTO
	 * 
	 * @return
	 */
	public List<ShopDTO> getAllShops() {

		List<Shop> listShops = (List<Shop>) shopsRepository.findAll();
		List<ShopDTO> listShopsDTO = new ArrayList<ShopDTO>();

		if (!listShops.isEmpty()) {

			for (Shop shop : listShops) {

				listShopsDTO.add(mapShop.mappingEntityToDTO(shop));

			}

		}

		return listShopsDTO;
	}


	public String deleteAllShops() {
		shopsRepository.deleteAll();
		paintingsRepository.deleteAll();
		
		return "Shops and paintings deleted";

	}
	
	// Paintings
	public String addPainting(long idShop, PaintingDTO paintingDTO) {

		Shop shop = shopsRepository.findById(idShop);
		
		if (shop == null) {
			
			return "The shop with" + idShop + "doesn't exist and it wasn't possible to add the painting";
			
		}else {
			Painting painting = mapPainting.mappingDTOToEntity(paintingDTO);
			painting.setShop(shop);
			paintingsRepository.save(painting);
			
			return "Painting has been saved";
		}

	}
	
	public String updatePainting(long idShop, long idPainting, PaintingDTO paintingDTO) {

		Shop shop = shopsRepository.findById(idShop);

		if (shop == null) {

			return "The shop with" + idShop + "doesn't exist and it wasn't possible to update the painting";

		} else {

			Painting paintingToUpdate = paintingsRepository.findById(idPainting);

			if (paintingToUpdate == null) {
				return "The painting with" + idPainting + "doesn't exist and it wasn't possible to update it";

			} else {

				Painting paintingUpdated = mapPainting.mappingDTOToEntity(paintingDTO);

				paintingToUpdate.setAuthorName(paintingUpdated.getAuthorName());
				paintingToUpdate.setPaintingName(paintingUpdated.getPaintingName());
				paintingToUpdate.setPrice(paintingUpdated.getPrice());

				return "Painting has been updated";
			}
		}

	}
	
	

	public PaintingDTO getPaintingById(long idShop, long idPainting) {

		Shop shop = shopsRepository.findById(idShop);

		if (shop == null) {

			return null;

		} else {

			Painting painting = paintingsRepository.findById(idPainting);

			if (painting == null) {
				return null;
			} else {

				PaintingDTO paintingDTO = mapPainting.mappingEntityToDTO(painting);

				return paintingDTO;
			}

		}

	}
	
	public String deletePainting(long idShop, long idPainting) {

		Shop shop = shopsRepository.findById(idShop);

		if (shop == null) {

			return "The shop with" + idShop + "doesn't exist and it wasn't possible to delete the painting";

		} else {

			Painting painting = paintingsRepository.findById(idPainting);

			if (painting == null) {

				return "The painting with" + idPainting + "doesn't exist and it wasn't possible to delete it";

			} else {

				
				paintingsRepository.deleteById(idPainting);

				return "Painting deleted";

			}

		}

	}

	public List<PaintingDTO> getAllPaintings() {

		List<Painting> listPaintings = (List<Painting>) paintingsRepository.findAll();
		List<PaintingDTO> listPaintingsDTO = new ArrayList<PaintingDTO>();

		if (!listPaintings.isEmpty()) {

			for (Painting painting : listPaintings) {

				listPaintingsDTO.add(mapPainting.mappingEntityToDTO(painting));

			}

		}

		return listPaintingsDTO;

	}

    public String deletePaintingsOfShop(long idShop) {
		
    	Shop shop = shopsRepository.findById(idShop);

		if (shop == null) {

			return "The shop with" + idShop + "doesn't exist and it wasn't possible to delete all their paintings";

		} else {

			for (Painting painting: paintingsRepository.findAll()) {
				
				if (painting.getShop()== shop) {
					
					paintingsRepository.delete(painting);
					
				}
				
				
			}
			return "All paintings of the shop with" + idShop + "have been deleted";
			
		}
  

	}

	public void deleteAllPaintings() {
		
		paintingsRepository.deleteAll();

	}
	
	
	    
	
}
