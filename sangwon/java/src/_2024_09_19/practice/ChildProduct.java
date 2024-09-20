package _2024_09_19.practice;

public class ChildProduct<T, V, E> extends Product<T, V> {
    private E value2;

    public ChildProduct(T name, V value, E value2) {
        super(name, value);
        this.value2 = value2;
    }

    public E getValue2() {
        return value2;
    }
}
