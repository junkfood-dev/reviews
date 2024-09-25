package _2024_09_19.practice;

public class Product<T, V> {
    private T name;
    private V value;

    public Product(T name, V value) {
        this.name = name;
        this.value = value;
    }

    public T getName() {
        return name;
    }

    public V getValue() {
        return value;
    }
}
