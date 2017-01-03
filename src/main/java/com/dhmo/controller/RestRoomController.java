package com.dhmo.controller;



import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value = "/json/rest_find" ,method = RequestMethod.GET, produces = { "application/json;charset=utf-8", "text/json" }, consumes = MediaType.ALL_VALUE)
    public ArrayList<RestRoom> findRestRoom(@RequestParam(value="lat", required=true) String lat, 
					    		 @RequestParam(value="lon", required=true) String lon,
    							 @RequestParam(value="width", required=true) String width,
    							 @RequestParam(value="height", required=true) String height) {
    	
    	ArrayList<RestRoom> restRoomList = restRoomService.checkRectangle(Double.parseDouble(lat),Double.parseDouble(lon),
    																		Double.parseDouble(width), Double.parseDouble(height));
    	
    	log.info("restRoomList size : " + restRoomList.size());
		return restRoomList;
    }
    
    
    @RequestMapping(value = "/xml/rest_find",method = RequestMethod.GET, produces = { "application/xml;charset=utf-8", "text/xml" }, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public ArrayList<RestRoom> findRestRoomXml(@RequestParam(value="lat", required=true) String lat, 
					    		 @RequestParam(value="lon", required=true) String lon,
    							 @RequestParam(value="width", required=true) String width,
    							 @RequestParam(value="height", required=true) String height) {
    	
    	ArrayList<RestRoom> restRoomList = restRoomService.checkRectangle(Double.parseDouble(lat),Double.parseDouble(lon),
    																		Double.parseDouble(width), Double.parseDouble(height));
    	
    	log.info("restRoomList size : " + restRoomList.size());
		return restRoomList;
    }
    
}
