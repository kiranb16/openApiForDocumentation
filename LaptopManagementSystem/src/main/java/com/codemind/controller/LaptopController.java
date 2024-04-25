package com.codemind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.model.Laptop;
import com.codemind.repository.LaptopRepository;

@RestController
public class LaptopController {

	@Autowired
	private LaptopRepository laptopRepository;
	@PostMapping("/laptops")
	public Laptop saveLaptop(@RequestBody Laptop laptop) {
		return laptopRepository.save(laptop);
	}

	@GetMapping("/laptops")
	public List<Laptop> getAllLaptop() {
		return laptopRepository.findAll();
	}

	@GetMapping("laptops/getByNameOrBrand/{name}/{brand}")
	public List<Laptop> getByNameOrBrand(@PathVariable String name, @PathVariable String brand) {
		return laptopRepository.findByNameOrBrand(name, brand);
	}
 
    @GetMapping("laptops/{name}")
    public List<Laptop> getLaptopByName(@PathVariable String name){
    	return laptopRepository.FindByname(name);
    }
    @GetMapping("laptops/{brand}/{name}")
    public List<Laptop> getBybrandAndName( @PathVariable String brand, @PathVariable String name){
    	return laptopRepository.FindByBrandAndName(brand, name);
    }
    @GetMapping("laptops/price/{price}")
    public List<Laptop> getByPriceGreaterThan(@PathVariable int price){
    	
    	return laptopRepository.findPriceGreaterThan(price);
    }
    @GetMapping("laptops/lessthan/{price}")
    public List<Laptop> getByPriceLessThan(@PathVariable int price){
    	return laptopRepository.findPriceLessThan(price);
    }
    @GetMapping("/laptops/getByBrandOrPrice/{brand}/{price}")
    public List<Laptop> getLaptopByBrandOrPrice( @PathVariable String brand,@PathVariable int price) {
    	return laptopRepository.findByBrandOrPrice(brand, price);
    }
    
    @GetMapping("/laptops/getById/{id}")
    public Laptop getById(@PathVariable int id) {
    	return laptopRepository.findById(id).get();
    } 
    
    @DeleteMapping("laptops/deleteById/{id}")
     public String deleteById(@PathVariable int id) {
          laptopRepository.deleteById(id);
          return "deleted successfully";
    }
    @GetMapping("/laptops/getByprices/{price}")
    public List<Laptop> getByprice(@PathVariable double price){
    	return laptopRepository.findByPrice(price);
    }
    @GetMapping("/laptops/byasc/{price}")
    public List<Laptop> getLaptopByAsc(@PathVariable double price ){
    	return laptopRepository.findBypriceasc(price);
    }
}
