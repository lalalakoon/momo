package com.dhmo.controller;



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhmo.dao.RestRoomRepository;
import com.dhmo.model.RestRoom;
import com.dhmo.service.RestRoomService;

@RestController
public class RestRoomController {
	private static final Logger log = LoggerFactory.getLogger(RestRoomController.class);

	@Autowired
	private RestRoomService restRoomService;
    
    /**
     * 
     * @param lat  : 사각형의 무게중심 위도
     * @param lon  : 사각형의 무게중심 경도
     * @param width  : 사각형의 가로길이
     * @param height : 사각형의 세로 길이
     * @return
     */
    
    
    @RequestMapping("/json/rest_find")
    public ArrayList<RestRoom> findRestRoom(@RequestParam(value="lat", required=true) String lat, 
					    		 @RequestParam(value="lon", required=true) String lon,
    							 @RequestParam(value="width", required=true) String width,
    							 @RequestParam(value="height", required=true) String height) {
    	
    	//TODO 로직 구하자.
    	ArrayList<RestRoom> restRoomList = restRoomService.checkRectangle(Double.parseDouble(lat),Double.parseDouble(lon),
    																		Double.parseDouble(width), Double.parseDouble(height));
    	
    	log.info("restRoomList size : " + restRoomList.size());
		return restRoomList;
    }
    
    
    @RequestMapping("/json/rest_find.xml")
    public RestRoom findRestRoomXml(@RequestParam(value="lat", defaultValue="2") Long lat, 
    							 @RequestParam(value="lon", defaultValue="2") Long lon) {
    	RestRoom restRoom = null;
		return restRoom;
    }
    
    
//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (Customer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
//		};
//	}
}
