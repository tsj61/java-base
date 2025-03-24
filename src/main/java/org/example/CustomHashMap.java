package org.example;

import java.util.Map;
import java.util.Objects;

public class CustomHashMap<K, V> {

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> nextElement;

        Node(int hash, K key, V value, Node<K, V> nextElement) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextElement = nextElement;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Node<?, ?> e
                    && Objects.equals(this.key, e.getKey())
                    && Objects.equals(this.value, e.getValue());
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    // вместимость должна быть кратна 2. TODO: реализовать метод, чтобы вместимость всегда была кратна 2
    static final int DEFAULT_CAPACITY = 1 << 4;

    private Node<K, V>[] table;
    int size;

    public CustomHashMap() {
        this.table = new Node[DEFAULT_CAPACITY];
    }


    public CustomHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость меньше 0: " + capacity);
        } else if (capacity == 0) {
            capacity = DEFAULT_CAPACITY;
        }
        if (capacity > MAXIMUM_CAPACITY) {
            capacity = MAXIMUM_CAPACITY;
        }
        table = new Node[capacity];
    }

    //TODO: Реализовать конструктор на основе другой коллекции
    public CustomHashMap(Map<? extends K, ? extends V> m) {

    }


}
