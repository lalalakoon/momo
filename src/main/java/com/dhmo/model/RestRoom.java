package com.dhmo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "REST_ROOM")
public class RestRoom {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	//구분
	@Column(name="TOILET_TYPE")
	private String toiletType;
	
	//화장실명
	@Column(name="NAME")
	private String name;
	
	//소재지 도로명주소
	@Column(name="ROAD_ADDRESS")
	private String roadAddress;
	
	//남녀 공용여부
	@Column(name="UNISEXYN")
	private String unisexYN;
	
	//남성 대변기
	@Column(name="MEN_LAVATORY")
	private String menLavatory;
	
	//남성 소변기
	@Column(name="MEN_URINAL")
	private String menUrinal;
	
	//장애인용 대변기 
	@Column(name="MEN_DISABLED_LAVATORY")
	private String menDisabledLavatory ;
	
	//장애인용 소변기
	@Column(name="MEN_DISABLED_URINAL")
	private String menDisabledUrinal;
	
	//어린이용 대변기
	@Column(name="MEN_CHILD_LAVATORY")
	private String menChildLavatory;
	
	//어린이용 소변기
	@Column(name="MEN_CHILD_URINAL")
	private String menChildUrinal;

	//여성용 대변기
	@Column(name="WOMEN_LAVATORY")
	private String womenLavatory;
	
	//여성용 장애인용 대변기
	@Column(name="WOMEN_DISABLED_LAVATORY")
	private String womenDisabledLavatory;
	
	//여성용 어린이 대변기
	@Column(name="WOMEN_CHILD_LAVATORY")
	private String womenChildLavatory;
	
	//관리기관
	@Column(name="MANAGEMENT")
	private String management;
	
	//연락처
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	//개방시간
	@Column(name="OPEN_TIME")
	private String openTime;
	
	//설치년도
	@Column(name="ESTABLISH_DATE")
	private String establishDate;
	
	//소재지번
	@Column(name="ADDRESS")
	private String address;
	
	//위도
	@Column(name="LATITUDE")
	private String latitude;
	
	//경도
	@Column(name="LONGITUDE")
	private String longitude;
	
	//데이터 기준일자
	@Column(name="REG_DT")
	private String regDt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToiletType() {
		return toiletType;
	}
	public void setToiletType(String toiletType) {
		this.toiletType = toiletType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getUnisexYN() {
		return unisexYN;
	}
	public void setUnisexYN(String unisexYN) {
		this.unisexYN = unisexYN;
	}
	public String getMenLavatory() {
		return menLavatory;
	}
	public void setMenLavatory(String menLavatory) {
		this.menLavatory = menLavatory;
	}
	public String getMenUrinal() {
		return menUrinal;
	}
	public void setMenUrinal(String menUrinal) {
		this.menUrinal = menUrinal;
	}
	public String getMenDisabledLavatory() {
		return menDisabledLavatory;
	}
	public void setMenDisabledLavatory(String menDisabledLavatory) {
		this.menDisabledLavatory = menDisabledLavatory;
	}
	public String getMenDisabledUrinal() {
		return menDisabledUrinal;
	}
	public void setMenDisabledUrinal(String menDisabledUrinal) {
		this.menDisabledUrinal = menDisabledUrinal;
	}
	public String getMenChildLavatory() {
		return menChildLavatory;
	}
	public void setMenChildLavatory(String menChildLavatory) {
		this.menChildLavatory = menChildLavatory;
	}
	public String getMenChildUrinal() {
		return menChildUrinal;
	}
	public void setMenChildUrinal(String menChildUrinal) {
		this.menChildUrinal = menChildUrinal;
	}
	public String getWomenLavatory() {
		return womenLavatory;
	}
	public void setWomenLavatory(String womenLavatory) {
		this.womenLavatory = womenLavatory;
	}
	public String getWomenDisabledLavatory() {
		return womenDisabledLavatory;
	}
	public void setWomenDisabledLavatory(String womenDisabledLavatory) {
		this.womenDisabledLavatory = womenDisabledLavatory;
	}
	public String getWomenChildLavatory() {
		return womenChildLavatory;
	}
	public void setWomenChildLavatory(String womenChildLavatory) {
		this.womenChildLavatory = womenChildLavatory;
	}
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public RestRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestRoom(Long id, String toiletType, String name,
			String roadAddress, String unisexYN, String menLavatory,
			String menUrinal, String menDisabledLavatory,
			String menDisabledUrinal, String menChildLavatory,
			String menChildUrinal, String womenLavatory,
			String womenDisabledLavatory, String womenChildLavatory,
			String management, String phoneNumber, String openTime,
			String establishDate, String address, String latitude,
			String longitude, String regDt) {
		super();
		this.id = id;
		this.toiletType = toiletType;
		this.name = name;
		this.roadAddress = roadAddress;
		this.unisexYN = unisexYN;
		this.menLavatory = menLavatory;
		this.menUrinal = menUrinal;
		this.menDisabledLavatory = menDisabledLavatory;
		this.menDisabledUrinal = menDisabledUrinal;
		this.menChildLavatory = menChildLavatory;
		this.menChildUrinal = menChildUrinal;
		this.womenLavatory = womenLavatory;
		this.womenDisabledLavatory = womenDisabledLavatory;
		this.womenChildLavatory = womenChildLavatory;
		this.management = management;
		this.phoneNumber = phoneNumber;
		this.openTime = openTime;
		this.establishDate = establishDate;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.regDt = regDt;
	}
	
}
