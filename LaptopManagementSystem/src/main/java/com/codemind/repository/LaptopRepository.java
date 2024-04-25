package com.codemind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codemind.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	public List<Laptop> findByNameOrBrand(String name, String brand);

	@Query("select l from laptop l where l.name=?1")
	public List<Laptop> FindByname(String name);

	@Query("select l from laptop l where l.brand=?1 and l.name=?2")
	public List<Laptop> FindByBrandAndName(String brand, String name);

	@Query(value = "select * from laptop where price >15000", nativeQuery = true)
	public List<Laptop> findPriceGreaterThan(int price);

	@Query("select l from laptop l where l.price<30000")
	public List<Laptop> findPriceLessThan(int price);

	@Query(value = "select * from laptop where brand=?1 or price=?2", nativeQuery = true)
	public List<Laptop> findByBrandOrPrice(String brand, int price);

	@Query(value=" select * from laptop order by price desc limit 03; ",nativeQuery = true)
	public List<Laptop> findByPrice(double price);
    @Query(value=" select * from laptop order by price asc limit 03;" , nativeQuery =  true)
	public List<Laptop> findBypriceasc(double price);
}
