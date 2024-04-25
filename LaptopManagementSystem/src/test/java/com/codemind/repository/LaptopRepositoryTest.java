package com.codemind.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.codemind.model.Laptop;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class LaptopRepositoryTest {
@Autowired
private LaptopRepository laptopRepository;

@Test
void saveLaptop() {
	Laptop lap= new Laptop();
	lap.setId(1);
	lap.setBrand("hp");
	lap.setName("xxx");
	lap.setPrice(120000.00);
	Laptop laptop=laptopRepository.save(lap);
	assertNotNull(laptop);
	assertThat(laptop.getId()).isNotEqualTo(null);
}

@Test
void getAllLaptop() {
	Laptop lap1= new Laptop();
	lap1.setId(1);
	lap1.setBrand("dell");
	lap1.setName("faster");
	lap1.setPrice(1256.00);
	laptopRepository.save(lap1);
	Laptop lap2= new Laptop();
	lap2.setId(2);
	lap2.setBrand("hp");
	lap2.setName("boomer");
	lap2.setPrice(12569.00);
	laptopRepository.save(lap2);
	List<Laptop> list= laptopRepository.findAll();
	assertNotNull(list);
	assertThat(list).isNotNull();
	//assertEquals(2, list.size());
}
@Test
void getById() {
	Laptop lap1= new Laptop();
	lap1.setId(1);
	lap1.setBrand("dell");
	lap1.setName("faster");
	lap1.setPrice(1256.00);
	Laptop laptop=laptopRepository.save(lap1);
	assertNotNull(laptop);
	assertEquals("faster", laptop.getName());
}/*
  @Test
  void updateLaptop() {
	  Laptop lap= new Laptop();
	  lap.setId(1);
	  lap.setBrand("dell");
	  lap.setName("faster");
	  lap.setPrice(1234.45);
	  Laptop laptop=laptopRepository.save(lap);
	  assertEquals("faster", laptop.getName());
	  assertEquals("dell", laptop.getBrand());
  }*/

@Test
void deleteMovie() {
	Laptop lap= new Laptop();
	lap.setId(100);
	lap.setBrand("apple");
	lap.setName("love");
	lap.setPrice(1234567.90);
	long id=lap.getId();
	laptopRepository.delete(lap);
	Optional<Laptop> avLaptop= laptopRepository.findById((int) id);
	assertThat(avLaptop).isEmpty();
			
}
}
















