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
		//같은 경도에서 높이값을 이용해 위도차이를 구한다.
		double diffLat = calculateLatitude3(height/2d, lat,lon);
		//같은 위도에서 width값을 이용해 경도차이를 구한다.
		double diffLon = calculateLongitude3(width/2d, lat, lon);
		double minLat =  lat - Math.abs(diffLat);
		double maxLat =  lat + Math.abs(diffLat);
		double minLon =  lon - diffLon;
		double maxLon =  lon + diffLon;
		
		
		log.info("diffLat : "+ diffLat);
		log.info("diffLon : "+ diffLon);
		
    	ArrayList<RestRoom> restRoomList = new ArrayList<RestRoom>();
    	double modelLat=0d;
    	double modelLon=0d;
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
		
//		double theta = lon1 - lon2;
//		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
//		dist = Math.acos(dist);
//		dist = rad2deg(dist);
//		dist = dist * 60 * 1.1515;
//		if (unit == "K") {
//			dist = dist * 1.609344;
//		} else if (unit == "N") {
//			dist = dist * 0.8684;
//		}
		
		
	}
	
	public double calculateLatitude(double h, double lat, double lon) {
		//근의공식 ax2 + bx + c = 0 
		//km 단위의 distance를 기본 값인 마일로 변경.	 1위도당 60*1.1515 마일
		double kRad =(h*Math.PI/(69.1*180d));
		double radLat1 = degToRad(lat);
		double a = 1d + Math.sin(radLat1)*Math.sin(radLat1);
		double b = -2*Math.cos(kRad)*Math.cos(radLat1);
		double c = Math.cos(kRad)*Math.cos(kRad) - Math.sin(radLat1)*Math.sin(radLat1);
		double sqrtVal = Math.sqrt(b*b-(4*a*c));
		double x = (-b + sqrtVal)/(2d*a);
		double radLat2 = Math.acos(x); 
		double lat2 = radToDeg(radLat2);
		
		log.info("distance : " +kRad);
		log.info("radLat1 : " +radLat1);
		log.info("a : " +a);
		log.info("b : " +b);
		log.info("c : " +c);
		log.info("sqrtVal : " +sqrtVal);
		log.info("x : " +x);
		log.info("radLat2 : " +radLat2);
		log.info("lat2 : " +lat2);
		return (lat2 - lat);
	}

	
	public double calculateLongitude(double w, double lat, double lon) {
		double distance = (w/1.609344)/(60*1.1515);
		double radLat1 = degToRad(lat);
		double radLon1 = degToRad(lon);
		double arcCosInner = (distance - Math.sin(radLat1)*Math.sin(radLat1))/(Math.cos(radLat1)*Math.cos(radLat1)); 
		double radLon2 = Math.acos(arcCosInner)+ radLon1;
		double lon2 = radToDeg(radLon2);
		
		return (lon2 - lon);
	}

	public double degToRad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public double radToDeg(double rad) {
		return (rad * 180 / Math.PI);
	}
	

		
	public double calculateLatitude3(double h, double lat, double lon) {
		double kRad =(h/(110d));
		double radLat1 = lat;
		double a = 1d ;
		double b = -2*radLat1;
		double c = radLat1*radLat1 - kRad*kRad;
		double sqrtVal = Math.sqrt(b*b-(4*a*c));
		double x = (-b + sqrtVal)/(2d*a);
		
		log.info("distance : " +kRad);
		log.info("radLat1 : " +radLat1);
		log.info("a : " +a);
		log.info("b : " +b);
		log.info("c : " +c);
		log.info("sqrtVal : " +sqrtVal);
		log.info("x : " +x);
		return (x - lat);
	}
	
	public double calculateLongitude3(double w, double lat, double lon) {
		double distance = w;
		double k = 110d*110d*Math.cos(lat/57.3)*Math.cos(lat/57.3);
		double a = k ;
		double b = -2*k*lon;
		double c = k*lon*lon-distance*distance;
		double sqrtVal = Math.sqrt(b*b-(4*a*c));
		double x = (-b + sqrtVal)/(2d*a);
		
		log.info("distance : " +distance);
		log.info("a : " +a);
		log.info("b : " +b);
		log.info("c : " +c);
		log.info("sqrtVal : " +sqrtVal);
		log.info("x : " +x);
		
		return (x - lon);
	}
	

}
