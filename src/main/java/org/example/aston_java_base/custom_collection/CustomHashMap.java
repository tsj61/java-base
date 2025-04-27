package org.example.aston_java_base.custom_collection;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class CustomHashMap<K, V> {

    static class CustomNode<K, V> {

        final int hash;
        final K key;
        V value;
        CustomNode<K, V> nextElement;

        CustomNode(int hash, K key, V value, CustomNode<K, V> nextElement) {
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

            return o instanceof CustomHashMap.CustomNode<?, ?> e
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
    // вместимость должна быть кратна 2.
    private static final int DEFAULT_CAPACITY = 1 << 4;

    private CustomNode<K, V>[] table;
    private int size;

    /**
     * Конструктор по умолчанию с дефолтной вместимостью
     */
    public CustomHashMap() {
        this.table = new CustomNode[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор с заданной вместимостью
     *
     * @param capacity вместимость
     */
    public CustomHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость меньше 0: " + capacity);
        } else if (capacity == 0) {
            capacity = DEFAULT_CAPACITY;
        }

        if (capacity > MAXIMUM_CAPACITY) {
            capacity = MAXIMUM_CAPACITY;
        }

        table = new CustomNode[capacity];
    }

    /**
     * Перевод мапы в CustomHashMap
     *
     * @param map мапа
     */
    public CustomHashMap(Map<? extends K, ? extends V> map) {
        int mapSize = map.size();

        if (mapSize > 0) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Вытаскивает значение по ключу
     *
     * @param key ключ
     * @return знаечние
     */
    public V get(K key) {
        int number = getBucketNumber(key);
        CustomNode<K, V> currentNode = table[number];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.nextElement;
        }

        return null;
    }

    /**
     * Проверка наличия ключа
     *
     * @param key ключ
     * @return true, если есть
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Вставка в мапу
     *
     * @param key   ключ
     * @param value значение
     */
    public void put(K key, V value) {
        // высчитывается значения hashCode у ключа
        int keyHash = hash(key);
        // высчитывается бакет для хранения этого элемента
        int number = getBucketNumber(key);

        CustomNode<K, V> newNode = new CustomNode<>(keyHash, key, value, null);
        // если бакет пустой .то элемент просто добавляется
        if (this.table[number] == null) {
            this.table[number] = newNode;
            this.size++;
        } else {
            // идем по списку и сравниваем ключ нового и ключ в списке по хэшкодам
            CustomNode<K, V> currentNode = this.table[number];
            CustomNode<K, V> previousNode = null;
            while (currentNode != null) {

                // если ключи равны, то сравниваем по equals
                if (currentNode.hash == keyHash && Objects.equals(currentNode.key, key)) {
                    // перезаписываем значение
                    currentNode.value = value;
                    return;
                }

                previousNode = currentNode;
                currentNode = currentNode.nextElement;

                // если хэшкоды не равны, или ключи не равны по equals, то идем к следующему
            }

            // если дошли до конца, то вставляем новый элемент
            if (previousNode == null) {
                // Если это был первый элемент в бакете
                table[number] = newNode;
            } else {
                previousNode.nextElement = newNode;
            }

            this.size++;
        }
    }

    /**
     * Удаление по ключу
     *
     * @param key ключ
     */
    public void remove(K key) {
        int number = getBucketNumber(key);
        CustomNode<K, V> current = table[number];
        CustomNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[number] = current.nextElement;
                } else {
                    prev.nextElement = current.nextElement;
                }

                size--;
                return;
            }

            prev = current;
            current = current.nextElement;
        }
    }


    /**
     * Возвращает значение, а если такого ключа нет, то возвращает значение по умолчанию
     *
     * @param key          ключ
     * @param defaultValue дефолтное значение
     * @return значение по ключу либо дефолтное
     */
    public V getOrDefault(K key, V defaultValue) {
        V value = get(key);
        return (value != null) ? value : defaultValue;

    }

    /**
     * Добавляет элемент с указанным значением, если такого ключа еще нет в мапе
     *
     * @param key   ключ
     * @param value значение
     */
    public void putIfAbsent(K key, V value) {
        if (get(key) == null) {
            put(key, value);
        }
    }

    /**
     * Добавляет элемент со значением, вычисленным с использованием ключа, если такого ключа еще нет в мапе
     *
     * @param key             ключ
     * @param mappingFunction функция вычисления значения по ключу
     */
    public void computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        V value = get(key);
        if (value == null) {
            value = mappingFunction.apply(key);
        }

        put(key, value);
    }


    /**
     * Возвращает размер мапы
     *
     * @return размер мапы
     */
    public int size() {
        return size;
    }

    /**
     * Проверка.является ли мапа пустой
     *
     * @return true если мапа пустая
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * вычисление хэшкода ключа
     *
     * @param key ключ
     * @return хэшкод ключа
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Высчитывается бакет хранения элемента
     *
     * @param key ключ
     * @return номер бакета
     */
    private int getBucketNumber(K key) {
        return hash(key) % this.table.length;
    }
}
