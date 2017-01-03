package com.dhmo.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhmo.NaverCodingApplication;
import com.dhmo.dao.RestRoomRepository;
import com.dhmo.model.RestRoom;

@Service
public class RestRoomService {
	private static final Logger log = LoggerFactory.getLogger(RestRoomService.class);

	
	@Autowired
	private RestRoomRepository restRoomRepository;

	
	public ArrayList<RestRoom> checkRectangle(double lat, double lon, double width, double height){
		//같은 경도에서 높이값을 이용해 중심점과의 위도차이를 구한다.
		double diffLat = calculateLatitude(height/2d, lat,lon);
		//같은 위도에서 width값을 이용해 중심점과의 경도차이를 구한다.
		double diffLon = calculateLongitude(width/2d, lat, lon);
		
		//위도 최소값
		double minLat =  lat - Math.abs(diffLat);
		//위도 최대값
		double maxLat =  lat + Math.abs(diffLat);
		//경도 최소값
		double minLon =  lon - diffLon;
		//경도 최대값
		double maxLon =  lon + diffLon;
		
		
		log.info("diffLat : "+ diffLat);
		log.info("diffLon : "+ diffLon);
		
    	ArrayList<RestRoom> restRoomList = new ArrayList<RestRoom>();
    	double modelLat=0d;
    	double modelLon=0d;
    	
    	//각 화장실의 위도 경도가 직사각형의 위도와 경도의 범위 안에 있는지 체크.
    	for (RestRoom restRoom : NaverCodingApplication.it) {
    		try {
    			modelLat = Double.parseDouble(restRoom.getLatitude());
    			modelLon = Double.parseDouble(restRoom.getLongitude());
    			//범위에 해당하는 모델만 리스트에 넣는다.
    			if(modelLat>= minLat && modelLat <= maxLat){
    				if(modelLon >= minLon && modelLon <= maxLon){
    					restRoomList.add(restRoom);
    				}
    			}
				
			} catch (Exception e) {
    			log.error("exception : " + e.getMessage());
			}
			
		}
    	return restRoomList;
	}
		
	
	/**
	 * 다음 식을 이용하여 Longitude2 와 Longitude1이 같을 때의 h만큼 떨어진 거리의 위도값을 구한다.
	 * 여기서 h는 직사각형의 높이/2의 값으로 단위는 km이다.
	 * distance^2 = (distanceLatitude)^2 + (distanceLongitude)^2
	 * distanceLatitude = 69.1*(latitude2 - latitude1)
	 * distanceLongitude = 69.1*(longitude2 - longitude1)*cos(latitude1/57.3)
	 */
	public double calculateLatitude(double h, double lat, double lon) {
		//근의공식 사용하여  위도(x)를 구한다. : ax2 + bx + c = 0 
		//1km = 0.621371 mile
		double kmToMile = 0.621371;
		double distance =h*kmToMile;
		double lat1 = lat;
		double a = 1d ;
		double b = -2*lat1;
		double c = lat1*lat1 - (distance/(69.1d))*(distance/(69.1d));
		double sqrtVal = Math.sqrt(b*b-(4*a*c));
		double x = (-b + sqrtVal)/(2d*a);
		
		log.info("distance(mile) : " +distance);
		log.info("radLat1 : " +lat1);
		log.info("a : " +a);
		log.info("b : " +b);
		log.info("c : " +c);
		log.info("sqrtVal : " +sqrtVal);
		log.info("x : " +x);
		return (x - lat);
	}
	
	/**
	 * 다음 식을 이용하여 distanceLatitude2 와 distanceLatitude1이 같을 때의 w만큼 떨어진 거리의 위도값을 구한다.
	 * 여기서 w는 직사각형의 가로/2의 값으로 단위는 km이다.
	 * distance^2 = (distanceLatitude)^2 + (distanceLongitude)^2
	 * distanceLatitude = 69.1*(latitude2 - latitude1)
	 * distanceLongitude = 69.1*(longitude2 - longitude1)*cos(latitude1/57.3)
	 */
	public double calculateLongitude(double w, double lat, double lon) {
		//근의공식 사용하여  경도(x)를 구한다. : ax2 + bx + c = 0 
		//1km = 0.621371 mile
		double kmToMile = 0.621371;
		double distance = w*kmToMile;
		double k = 69.1d*69.1d*Math.cos(lat/57.3)*Math.cos(lat/57.3);
		double a = k ;
		double b = -2*k*lon;
		double c = k*lon*lon-distance*distance;
		double sqrtVal = Math.sqrt(b*b-(4*a*c));
		double x = (-b + sqrtVal)/(2d*a);
		
		log.info("distance(mile) : " +distance);
		log.info("a : " +a);
		log.info("b : " +b);
		log.info("c : " +c);
		log.info("sqrtVal : " +sqrtVal);
		log.info("x : " +x);
		
		return (x - lon);
	}
	

}
