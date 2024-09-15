### 예외 트랜잭션 처리방법  
- 트랜잭션
  - 데이터베이스의 상태를 변환 시키는 하나의 논리적 기능을 수행하기 위한 작업의 단위
  - 특징
    - 원자성 : 완벽하게 성공하거나 완벽하게 실패(rollback) / 부분적으로 실행되거나 중단되지 않는 것을 보장.
    - 일관성 : 데이터에 일관성이 있어야한다.
    - 독립성 : 다른 트랜잭션의 영향을 받지 않아야함.
    - 지속성 : 트랜잭션이 완료된 후, 그 결과는 영구적으로 저장 / 시스템 오류나 장애가 발생해도 트랜잭션이 결과는 손실되면안됨.
- 중간에 하나라도 실패하면 예외를 발생시켜서 이전 상태로 롤백(모두 취소하는 행위)시킴.
***
#### try-with-resource
- 자동 리소스 닫기
- 자바7에서 새롭게 추가됨
- 예외발생 여부와 상관없이 사용했던 리소스 객체의 close()메소드를 호출
- java.lang.AutoCloseable 인터페이스를 구현하고 있어야 사용가능
- close()메소드는 try문 끝날때 호출됨
***
##### 상속에서 메소드 재정의 시
- 부모 메소드와 다른 예외를 throws 할수 없음.
- 부모 메소드와 같은 예외 혹은 그 하위 예외는 가능
- 단, 런타임예외는 해당 규칙에 적용안됨.
  - 부모클래스 메소드에 들어갈 예외
    - IOException
    - Exception
    - SQLException
  - 자식클래스 메소드
    - FileNotFoundException
    - 런타임예외
      - NumberFormatException
      - ClassCastException
      - ArithmeticException
      - NullpointerException
***
## 제네릭 (generic)
- 타입<'참조형'데이터타입> 변수 = new 타입<>();
- 클래스, 인터페이스, 메소드정의 할때 타입을 파라미터로 사용 할 수 있도록 함.
- 데이터의 타입을 일반화 한다는 것
- 컴파일 시에 미리 타입검사를 수행
  - 타입 검사나 변환(Casting) 같은 번거로운 작업 생략 - 성능 향상
  - 클래스나 메소드 내부에서 사용하는 타입 안전성 증가
- 클래스에서 사용 class<T>
- 인터페이스에서 사용 Interface<T>
***
#### 제네릭 메소드
- <타입파라미터, ...> 리턴타입 메소드명 (매개변수...) {}
- 매개타입과 리턴타입으로 타입 파라미터를 갖는 메소드
- 특징
  - 재사용성, 유연성 : 하나의 메소드로 다양한 타입처리
  - 타입 안전성 : 컴파일 시 타입을 검사하여 타입오류를 줄임