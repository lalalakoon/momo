##1. 준비사항
다음 명령으로 패키징 및 실행

1. cmd에서 project 경로로 이동
2. jar로 패키지 : mvnw clean package
3. 실행 : java -jar target/map-rest-1.0.0-SNAPSHOT.jar

       - h2 database 확인 : http://localhost:8080/h2-console
  
##2. API 기본 정보

- API명 : 직사각형내의 공공화장실 API
- 메서드 : GET
- 요청 URL : http://localhost:8080/json/rest_find, http://localhost:8080/xml/rest_find
- 출력포멧 :json, xml
- 설명 : 직사각형의 가로/세로 값과 중심값의 좌표(위도,경도)를 파라미터로 던지면, 해당 직사각형에 존재하는 공공화장실의 정보를 리턴

##3. 요청 변수

- lat : 직사각형의 중심점 위도
- lon : 직사각형의 중심점 경도
- width : 직사격형의 가로길이(km)
- height: 직사각형의 세로길이(km)


 ex) http://localhost:8080/json/rest_find?lon=128.44883116420243&lat=35.263795115189694&width=0.1&height=0.1
 
##4. 출력 결과

- id : 화장실구분번호
- toiletType : 구분
- name : 화장실명
- roadAddress : 소재지도로명주소
- unisexYN : 남녀공용화장실여부
- menLavatory : 남성용-대변기수
- menUrinal : 남성용-소변기수
- menDisabledLavatory : 남성용-장애인용대변기수
- menDisabledUrinal : 남성용-장애인용소변기수
- menChildLavatory : 남성용-어린이용대변기수
- menChildUrinal : 남성용-어린이용소변기수
- womenLavatory : 여성용-대변기수
- womenDisabledLavatory : 여성용-장애인용대변기수
- womenChildLavatory : 여성용-어린이용대변기수
- management : 관리기관명
- phoneNumber : 연락처
- openTime : 개방시간
- establishDate : 설치년도
- address : 소재지지번주소
- latitude : 위도
- longitude : 경도
- regDt : 데이터기준일자

##5. 호출예시

1. json 호출 

        - 호출 url : http://localhost:8080/json/rest_find?lon=128.44883116420243&lat=35.263795115189694&width=0.0001&height=0.1
        
        - 응답 : [{"id":1,"toiletType":"공중화장실","name":"입곡군립공원1(입구)","roadAddress":null,"unisexYN":"N","menLavatory":"2","menUrinal":"3","menDisabledLavatory":"1","menDisabledUrinal":"1","menChildLavatory":"0","menChildUrinal":"0","womenLavatory":"3","womenDisabledLavatory":"1","womenChildLavatory":"0","management":"경상남도 함안군청 환경보호과","phoneNumber":"055-580-2431","openTime":"24시간","establishDate":"2009-01-01","address":"경상남도 함안군 산인면 입곡리 산137-1","latitude":"35.263795115189694","longitude":"128.44883116420243","regDt":"2015-09-10"}]
 
2. xml 호출

       - 호출 url : http://localhost:8080/xml/rest_find?lon=128.44883116420243&lat=35.263795115189694&width=0.0001&height=0.1

       - 응답  :  \<ArrayList>\<item>\<id>1</id>\<toiletType>공중화장실</toiletType>\<name>입곡군립공원1(입구)</name>\<roadAddress/>\<unisexYN>N</unisexYN>\<menLavatory>2</menLavatory>\<menUrinal>3</menUrinal>\<menDisabledLavatory>1</menDisabledLavatory>\<menDisabledUrinal>1</menDisabledUrinal>\<menChildLavatory>0</menChildLavatory>\<menChildUrinal>0</menChildUrinal>\<womenLavatory>3</womenLavatory>\<womenDisabledLavatory>1</womenDisabledLavatory>\<womenChildLavatory>0</womenChildLavatory>\<management>경상남도 함안군청 환경보호과</management>\<phoneNumber>055-580-2431</phoneNumber>\<openTime>24시간</openTime>\<establishDate>2009-01-01</establishDate>\<address>경상남도 함안군 산인면 입곡리 산137-1</address>\<latitude>35.263795115189694</latitude>\<longitude>128.44883116420243</longitude>\<regDt>2015-09-10</regDt>\</item>\</ArrayList>"
