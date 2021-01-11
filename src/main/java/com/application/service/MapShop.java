/**
 * 
 */
package com.application.service;

import org.springframework.stereotype.Service;

import com.application.domain.Shop;
import com.application.domain.ShopDTO;

/**
 * @author stefano
 *
 */
@Service
public class MapShop implements Map<ShopDTO, Shop> {

	@Override
	public Shop mappingDTOToEntity(ShopDTO shopDTO) {

		Shop shop = new Shop(shopDTO.getName(), shopDTO.getCapacity());
		return shop;
	}

	@Override
	public ShopDTO mappingEntityToDTO(Shop shop) {

		ShopDTO shopDTO = new ShopDTO(shop.getName(), shop.getCapacity());

		return shopDTO;

	}

}
