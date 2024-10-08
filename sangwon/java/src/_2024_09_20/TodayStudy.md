# Collection
- Java에서 제공해주는 '자료구조'
- 사전적의미로 요소를 수집해서 저장하는 것
- 배열의 문제점을 해결하고, 객체들을 효율적으로 추가,삭제,검색 할 수 있게 해줌
  - 배열은 저장할 수 있는 객체 수가 정해져있고 객체를 삭제했을 때 해당 인덱스가 비어있게 됨
- List 인터페이스를 구현한 클래스: 순서를 유지하고 저장, 중복 저장 기능
  - ArrayList
  - Vector
  - LinkedList
- Set 인터페이스를 구현한 클래스: 순서를 유지하지 않고 저장, 중복 저장 불가
  - HashSet
  - TreeSet
- Map 인터페이스를 구현한 클래스: 키와 값의 쌍으로 저장, 키는 중복 저장 불가
  - HashMap
  - Hashtable
  - treeMap
  - Properites

## List 인터페이스
- 삽입된 순서를 유지, 중복요소 허용
- 인덱스 기반 접근
- 메소드
  - size() list의 크기
  - get() list의 값 찾기
  - add() list에 추가
  - remove() list에서 제거
  - clear() 모든 요소 제거
  - contains() list에 저장되어있는지 확인
  - isEmpty() 컬렉션이 비어있는지 여부

### ArrayList
  - 데이터를 자주 읽고, 삽입/삭제는 리스트 끝에서만 이루어 질 때 적합
  - 장점
    - 동적 배열: 필요에 따라 자동으로 크기가 늘어남
    - 빠른 랜덤 접근: 인덱스를 통한 임의 접근이 O(1)의 시간 복잡도로 빠름
  - 단점
    - 느린 삽입/삭제: 
      - 제거하면 제거된 인덱스 바로 뒤부터 한칸씩 당겨짐
      - 특정인덱스에 객체를 삽입하면 한칸씩 밀림
      - O(n)의 시간 복잡도
    - 공간 낭비: 배열 크기보다 적은 요소가 있을 때, 빈 공간이 남을 수 있음.

### LinkedList
  - 리스트 중간에 자주 삽입/삭제가 일어나고, 데이터 접근은 상대적으로 적을 때 적합
  - 이중 연결 리스트 : 각 요소는 Node객체로 표현 (이전 및 다음 노드를 참조)
  - 장점
    - 빠른 삽입/삭제
      - 리스트의 중간에 요소를 추가/삭제 할 때 링크만 변경하면 되어 O(1)시간 소요
      - 양방향 탐색 가능
  - 단점
    - 인덱스를 통해 임의 접근하는 성능이 느림 O(n)
    - 각 요소가 추가 메모리(참조값)를 차지하여 메모리 사용량이 큼

## Set 인터페이스
- 중복 허용 안함
- 순서 없이 저장
### HashSet
  - 중복체크 : 각 객체의 hashCode()와 equals()로 비교
    - 기본적으로 객체의 메모리 주소를 기준으로 중복을 판단하지만,
      오버라이딩으로 hashCode()와 equals()를 재정의 하여,
      객체의 내용에 따라 중복 여부를 결정
    - 중복인 객체는 저장하지 않는다.
  - 메소드
    - add()
    - size()
    - remove()
    - clear()
    - contains()
    - isEmpty()
    - Iterator<E> iterator() 저장된 객체를 한 번씩 가져오는 반복자 리턴
      - hasNext() 가져올 객체가 있으면 true, 없으면 false 리턴
      - next() 컬렉션에서 하나의 객체를 가져옴
      - remove() Set 컬렉션에서 객체 제거

## Map 인터페이스
- 키와 값으로 구성된 객체를 저장하는 구조 (키+값 = Entry)
- 키를 이용해 값에 빠르게 접근 가능
- 키는 중복될 수 없지만, 값은 중복 저장 가능
  - 저장되있던 키값과 동일한 키값으로 저장하면 기존의 값은 없어지고 새로운 값으로 대체
- 메소드
  - put(K key, V value) : 객체 추가
  - containsKey, containsValue
  - Set<Map.Entry<K,V>> entrySet() : 모든 Map.Entry객체를 Set에 담아서 리턴
  - Set<K> keySet() : 모든 키를 Set객체에 담아서 리턴
  - get() : 주어진 키가 있는 값을 리턴
  - isEmpty()
  - size()
  - clear()
  - remove()
  - getOrDefault(key, defaultValue) : 해당 key가 없을때 나올 기본 값 설정(설정안하면 null)
### HashMap
  - 비동기적: 동기화되지 않은 클래스
    - 멀티스레드 환경에서 사용하려면 외부에서 동기화 처리를 해야함
  - 순서 보장 안함
    - 키의 해시값에 따라 내부적으로 저장
  - null허용
  - 일반적으로 O(1) 시간 복잡도로 빠른 검색,삽입,삭제 지원
### Hashtable
  - 동기화됨(synchronized): 멀티스레드 환경에서 안전하게 사용(thread safe)
    - 멀티스레드가 동시에 실행할 수 없고, 하나의 스레드가 실행을 완료해야 다른 스레드 실행 가능
  - 순서 보장 안함
  - null 허용안함
  - 동기화로 인해 hashmap보다 약간 느림

## Stack(LIFO, 후입선출), Queue(FIFO, 선입선출)
### Stack
  - 메소드
    - push() 객체를 스택에 넣는다
    - peek() 스택의 맨위 객체를 가져오고, 스택에서는 제거되지않음 (확인하기)
    - pop() 스택의 맨 위 객체를 가져오고, 스택에서는 제거 (꺼내오기)
### Queue
  - queue 인터페이스를 구현한 대표적인 클래스는 LinkedList
  - 메소드
    - offer() 객체를 넣기
    - peek() 객체 하나를 가져오고, 큐에서는 제거안함 (확인하기)
    - poll() 객체 하나를 가져오고, 큐에서 제거 (꺼내오기)

## Big-O 표기법
- 알고리즘의 성능을 측정할 때 사용되는 수학적 표기법
- 입력크기 (n)에 따라 알고리즘의 실행 시간이 어떻게 증가하는지 나타냄
- 알고리즘의 최악의 경우 성능을 표현