# TO DO List 프로젝트

## Front Controller 패턴
* 각 path(URL)마다 Servlet을 작성하는 기존의 프로젝트를 변경
* 1개의 Servlet Controller 에서 모든 요청을 수신하고  
각각의 path에 따라 다른 클래스를 호출하여 실행하기

## Command 패턴
* Servlet에서 처리할 요청을 Command 클래스를 생성하여 요청의 응답을  
대신 수행하도록 하는 패턴

* 원래대로라면 httpServlet을 extends 하는 Controller를 사용해야하는데 저게 사용가능한 메서드가 제한적이래

## pom.xml 상속받기
* pom.xml 이 완성된 maven 프로젝트의 package 를 pom으로 바꾸기
* maven build를 이용하여 repo 에 프로젝트 install 하기
* 실제 프로젝트에서 parent tag를 이용하여 pom.xml 을 상속받아 사용
* 다중 프로젝트에서 pom.xml