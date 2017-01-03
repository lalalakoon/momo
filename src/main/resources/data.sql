insert into REST_ROOM  (ID,ADDRESS,ESTABLISH_DATE,LATITUDE,LONGITUDE,MANAGEMENT,MEN_CHILD_LAVATORY,MEN_CHILD_URINAL,MEN_DISABLED_LAVATORY,	MEN_DISABLED_URINAL,MEN_LAVATORY,MEN_URINAL,NAME,OPEN_TIME,PHONE_NUMBER,REG_DT,ROAD_ADDRESS,TOILET_TYPE,UNISEXYN,WOMEN_CHILD_LAVATORY,WOMEN_DISABLED_LAVATORY,WOMEN_LAVATORY)
	SELECT rownum as ID, ADDRESS,ESTABLISH_DATE,LATITUDE,LONGITUDE,MANAGEMENT,MEN_CHILD_LAVATORY,MEN_CHILD_URINAL,MEN_DISABLED_LAVATORY,MEN_DISABLED_URINAL,MEN_LAVATORY,MEN_URINAL,NAME,OPEN_TIME,PHONE_NUMBER,REG_DT,ROAD_ADDRESS,TOILET_TYPE,UNISEXYN,WOMEN_CHILD_LAVATORY,WOMEN_DISABLED_LAVATORY,WOMEN_LAVATORY
			FROM CSVREAD('classpath:toiletlist.csv','TOILET_TYPE,NAME,ROAD_ADDRESS,UNISEXYN,MEN_LAVATORY,MEN_URINAL,MEN_DISABLED_LAVATORY,MEN_DISABLED_URINAL,MEN_CHILD_LAVATORY,MEN_CHILD_URINAL,WOMEN_LAVATORY,WOMEN_DISABLED_LAVATORY,WOMEN_CHILD_LAVATORY,MANAGEMENT,PHONE_NUMBER,OPEN_TIME,ESTABLISH_DATE,ADDRESS,LONGITUDE,LATITUDE,REG_DT','charset=UTF-8' )   ; 