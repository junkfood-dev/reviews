## 컴포넌트 스캔(@ComponentScan)
- 자동으로 클래스를 탐색하고 빈으로 등록
- 스캔 대상
  - @Component : 일반적인 스프링 빈
    - @Service : 비즈니스 로직을 담당하는 빈
    - @Repository : 데이터 엑세스를 담당하는 빈
    - @Controller : Spring MVC 컨트롤러
    - @Configuration : 스프링 설정 정보
- 스캔 옵션
  - basePackages : 컴포넌트 스캔을 수행할 패키지의 범위 지정
  - basePackageClasses : 특정 클래스가 속한 패키지부터 컴포넌트 스캔 시작
  - includeFilters : 스캔할 대상 추가
  - excludeFilters : 스캔 제외할 대상 지정
- 빈의 이름 규칙
  - 클래스 이름의 첫글자를 소문자로 변환하여 사용
    - ex. 클래스 이름 : UserService -> 빈의 이름 : userService
  - 빈의 이름을 명시적으로 지정
    - ex. @Service("user")

## 의존 관계 (DI)
- 주로 어노테이션 기반으로 처리
  - 필드 주입 : 필드에 직접 의존성을 주입하는 방식
    - @Autowhired 를 통해 의존성 주입
  - 생성자 주입 : 생성자를 통해 의존성 주입 (주로 사용)
    - 객체가 생성될 때 불변성을 보장함.
    - @Autowhired 생략가능
    - 순환 참조 방지
  - 세터 주입 set
    - 선택적인 의존성이나, 필요할 때만 의존성을 주입

### @SpringBootApplication
- 자바의 main 메소드와 같은 역할
- Auto-configuration : 스프링부트는 애플리케이션의 의존성을 기반으로 필요한 빈을 자동으로 구성
- Component Scanning : 스프링부트 애플리케이션의 패키지를 스캔하여, 빈으로 등록할 수 있는 클래스를 찾음
- Main method : 스프링부트 애플리케이션의 시작점으로 메인 메소드 제공

### @RestController
- @Controller + @ResponseBody
  - @ResponseBody 
  - html 페이지가 아닌, 데이터 자체를 응답으로 보내고자 할 때 사용
  - 해당 객체는 직렬화되어 JSON 형식으로 변환
- 라우터(HTTP요청과 메소드를 연결하는 장치)역할을 하는 어노테이션

# 스프링 부트 3구조
- 각 계층이 양 옆의 계층과 통신하는 구조
  - controller <-> service <-> repository
- 각 계층은 서로 소통할 수는 있지만, 다른 계층에 직접 간섭하거나 영향을 미치지 않음.
- @Controller : 프레젠테이션 계층
  - HTTP 요청을 받고 이 요청을 비즈니스 계층으로 전송하는 역할
  - XxxController
- @Service : 비즈니스 계층
  - 모든 서비스를 만들기 위한 로직 처리
  - XxxService
- @Repository : 퍼시스턴스 계층
  - 모든 데이터베이스 관련 로직 처리
  - DAO(데이터베이스 계층과 상호작용하기 위한 객체) 사용
  - XxxRepository 또는 XxxDAO

## Lombok(롬복)
- Java코드에서 반복되는 생성자, getter, setter, toString등의 코드를 줄여주는 라이브러리
- 간단하게 어노테이션을 작성하면 컴파일 시점에서 내부적으로 자동코드생성을 함.
- 생성자 생성
  - @AllArgsConstructor : 모든 필드를 초기화하는 생성자를 생성
  - @NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
  - @RequiredArgsConstructor: final로 선언된 필드나 @NonNull로 지정된 필드에 대해 생성자를 자동으로 생성
- @Getter : getter 생성
- @Setter : setter 생성

#### API 설계
- HTTP Method
  - GET : 데이터 조회
  - POST : 데이터 생성
  - PUT : 데이터 수정/갱신
  - DELETE : 데이터 삭제