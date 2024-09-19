<aside>
💡 제네릭 퀴즈
</aside>

### 1. 제네릭에 대한 설명으로 틀린 것은 무엇입니까?

1) 컴파일시 강한 타입 체크를 할 수 있다.
2) 타입 변환(casting)을 제거한다.
3) 제네릭 타입은 타입 파라미터를 가지는 제네릭 클래스와 인터페이스를 말한다.
4) 제네릭 메소드는 리턴 타입으로 타입 파라미터를 가질 수 없다.

답) 4: 제네릭 메소드는 리턴타입으로 타입 파라미터를 가질 수 있다.

### 2. `ContainerExample` 클래스의 main() 메소드는 `Container` 제네릭 타입을 사용하고 있습니다. main() 메소드에서 사용하는 방법을 참고해서 `Container` 제네릭 타입을 선언해보세요.
```java
public class ContainerExample {

	public static void main(String[] args) {
		Container<String> stringContainer = new Container<>();
		stringContainer.set("홍길동");
		String str = stringContainer.get();

		Container<Integer> intContainer = new Container<>();
		intContainer.set(6);
		int value = intContainer.get();
	}
}
```
답)
```java
public class Container<T> {
    private T object;

    public void set(T object) {
        this.object = object;
    }
    public T get() {
        return object;
    }
}
```

### 3. `TwoContainerExample` 클래스의 main() 메소드는 `TwoContainer` 제네릭 타입을 사용하고 있습니다. main() 메소드에서 사용하는 방법을 참고해서 `TwoContainer` 제네릭 타입을 선언해보세요.
```java
public class TwoContainerExample {

	public static void main(String[] args) {
		TwoContainer<String, String> container = new TwoContainer<>();
		container.set("홍길동", "도적");
		String name = container.getKey();
		String job = container.getValue();

		TwoContainer<String, Integer> secondContainer = new TwoContainer<>();
		secondContainer.set("홍길동", 35);
		String name2 = secondContainer.getKey();
		Integer age = secondContainer.getValue();
	}
}
```
답)
```java
public class TwoContainer<T, E> {
    private T name;
    private E object;

    public void set(T name, E object) {
        this.name = name;
        this.object = object;
    }
    public E getKey() {
        return this.object;
    }
    public E getValue() {
        return this.object;
    }
}
```

### 4. Util.getValue() 메소드는 첫 번째 매개값으로 `Pair` 타입과 하위 타입만 받고, 두 번째 매개값으로 키를 받습니다. 리턴값은 키값이 일치할 경우 `Pair`에 저장된 값을 리턴하고, 일치하지 않으면 null을 리턴하도록 getValue() 제네릭 메소드를 정의해보세요.
```java
public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("삼길동", 20);
		Integer childAge = Util.getValue(pair, "이길동");
		System.out.println(childAge);

		// OtherPair는 Pair를 상속하지 않으므로 예외가 발생해야합니다.
		/* OtherPair<String, Integer> otherPair = new OtherPair<>("삼길동, 20");
		   int otherAge = Util.getValue(otherPair, "삼길동");
		   System.out.println(otherAge); */
	}
}
```
```java
public class Pair<K, V> {
	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
```
```java
public class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K key, V value) {
		super(key, value);
	}
}
```
```java
public class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
```
실행결과는 다음과 같습니다.
```
35
null
```
답)
```java
public class Util {
    public static <K, V> V getValue(Pair<? extends K, V> pair, K key) {
        if (pair.getKey().equals(key)) {
            return pair.getValue();
        }
        return null;
    }
}
```