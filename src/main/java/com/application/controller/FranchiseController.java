/**
 * 
 */
package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.domain.*;
import com.application.service.*;

/**
 * @author stefano
 *
 */

@RestController
@RequestMapping("/api")
public class FranchiseController {
	
	@Autowired
	FranchiseService franchiseService;

	// http://localhost:8080/api/test (GET)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String test() {
		return "Test done";
	}

	//SHOPS
	
	// http://localhost:8080/api/GET/shops/idShop (GET) -> GET Shop by ID
	@RequestMapping(path = "GET/shops/{idShop}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ShopDTO getShopById(@PathVariable("idShop") long idShop) {
		return franchiseService.getShopById(idShop);

	}

	// http://localhost:8080/api/POST/shops (POST) -> CREATE New Shop
	@RequestMapping(path = "POST/shops", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addShop(@RequestBody ShopDTO newShop) {

		String message = franchiseService.addShop(newShop);
		return message;

	}

	// http://localhost:8080/api/DELETE/shops/id (DELETE) -> DELETE Employee by ID
	@RequestMapping(path = "/DELETE/shops/{idShop}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteShop(@PathVariable("idShop") long idShop) {
		String message = franchiseService.deleteShop(idShop);
		return message;

	}

	// http://localhost:8080/api/PUT/shops/idShop (PUT) -> UPDATE Shop by ID
	@RequestMapping(path = "/PUT/shops/{idShop}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public String updateShopById(@PathVariable("idShop") long idShop, @RequestBody ShopDTO shopUpdated) {

		String message = franchiseService.updateShop(idShop, shopUpdated);
		return message;

	}

	// http://localhost:8080/api/GET/shops (GET) -> GET all Shops of Franchise
	@RequestMapping(path = "GET/shops", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ShopDTO> getAllShops() {
		return franchiseService.getAllShops();

	}

	// http://localhost:8080/api/DELETE/shops (DELETE) -> DELETE all Shops  of Franchise
	@RequestMapping(path = "DELETE/shops", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteAllShops() {
		return franchiseService.deleteAllShops();

	}
	
	//PAINTINGS
	
	
	// http://localhost:8080/api/GET/shops/idShop/paintings/idPainting (GET) -> GET Painting by idShop and idPainting
	@RequestMapping(path = "GET/shops/{idShop}/paintings/{idShop}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public PaintingDTO getPaintingById(@PathVariable("idShop") long idShop,@PathVariable("idPainting") long idPainting) {
		return franchiseService.getPaintingById(idShop, idPainting);

	}

	// http://localhost:8080/api/POST/shops/idShop/paintings (POST) -> CREATE New Painting
	@RequestMapping(path = "POST/shops/{idShop}/paintings", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addPainting(@PathVariable("idShop") long idShop, @RequestBody PaintingDTO newPainting) {

		String message = franchiseService.addPainting(idShop, newPainting);
		return message;

	}

	// http://localhost:8080/api/DELETE/shops/idShop/paintings/idPainting (DELETE)-> DELETE Painting by idShop and idPainting	
	@RequestMapping(path = "/DELETE/shops/{idShop}/paintings/{idPainting}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteShop(@PathVariable("idShop") long idShop, @PathVariable("idPainting") long idPainting) {
		String message = franchiseService.deletePainting(idShop, idPainting);
		return message;

	}

	// http://localhost:8080/api/PUT/shops/idShop/paintings/idPainting (PUT) ->  UPDATE painting by idShop and idPainting
	@RequestMapping(path = "/PUT/shops/{idShop}/paintings/{idPainting}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public String updatePaintingById(@PathVariable("idShop") long idShop, @PathVariable("idPainting") long idPainting,@RequestBody PaintingDTO paintingUpdated) {

		String message = franchiseService.updatePainting(idShop,idPainting, paintingUpdated);
		return message;

	}

	// http://localhost:8080/api/GET/shops/idShop/paintings (GET) -> GET all Paintings of a Shop
	@RequestMapping(path = "GET/shops/{idShop}/paintings", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<PaintingDTO> getAllPaintingsofShop(@PathVariable("idShop") long idShop) {
		return franchiseService.getAllPaintingsOfShop(idShop);

	}
	
	// http://localhost:8080/api/GET/shops/idShop/paintings (DELETE) -> DELETE all Paintings of a Shop
	// Paintings of a Shop
	@RequestMapping(path = "GET/shops/{idShop}/paintings", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteAllPaintingsofShop(@PathVariable("idShop") long idShop) {
		String message = franchiseService.deleteAllPaintingsOfShop(idShop);
		return message;

	}
	
	
	
	// http://localhost:8080/api/GET/shops/paintings (GET) -> GET all Paintings of
	// Franchise
	@RequestMapping(path = "GET/shops/paintings", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<PaintingDTO> getAllPaintings() {
		return franchiseService.getAllPaintings();

	}

	// http://localhost:8080/api/DELETE/shops/paintings (DELETE) -> DELETE all
	// Paintings of Franchise
	@RequestMapping(path = "DELETE/shops/paintings", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteAllPaintings() {
		return franchiseService.deleteAllPaintings();

	}

}
