# momo
##1. 준비사항
다음 명령으로 패키징 및 실행

1. cmd에서 project 경로로 이동
2. jar로 패키지 : mvnw clean package
3. 실행 : java -jar target/map-rest-1.0.0-SNAPSHOT.jar

##2. API 기본 정보

1. API명 : 직사각형내의 공공화장실 API
2. 메서드 : GET
3. 요청 URL : http://localhost:8080/json/rest_find, http://localhost:8080/xml/rest_find
4. 출력포멧 :json, xml
5. 설명 : 직사각형의 가로/세로 값과 중심값의 좌표(위도,경도)를 파라미터로 던지면, 해당 직사각형에 존재하는 공공화장실의 정보를 리턴

##3. 요청 변수

1. lat : 직사각형의 중심점 위도
2. lon : 직사각형의 중심점 경도
3. width : 직사격형의 가로길이(km)
4. height: 직사각형의 세로길이(km)

##4. 출력 결과
