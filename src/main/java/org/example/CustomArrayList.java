package org.example;


import java.util.Arrays;
import java.util.Collection;

public class CustomArrayList<E> {
    /**
     * Дефолтная вместимость списка
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Массив с элементами
     */
    private Object[] elements;
    /**
     * Количество элементов
     */
    private int size;

    /**
     * Конструктор по умолчанию с пустым массивом
     */
    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор с заданной вместимостью
     *
     * @param capacity вместимость списка
     * @throws IllegalArgumentException если вместимость меньше 0
     */
    public CustomArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Вместимость меньше 0: " + capacity);
        }
    }

    /**
     * Перевод коллекции в CustomArrayList
     *
     * @param collection коллекция
     */
    public CustomArrayList(Collection<? extends E> collection) {
        Object[] newArray = collection.toArray();
        this.size = newArray.length;

        if (size == 0) {
            this.elements = new Object[DEFAULT_CAPACITY];
            return;
        }

        this.elements = Arrays.copyOf(newArray, size, Object[].class);
    }

    /**
     * Возвращает размер списка
     *
     * @return размер списка
     */
    public int size() {
        return this.size;
    }

    /**
     * Возвращает элемент списка по индексу
     *
     * @param index индекс элемента
     * @return элемент по индексу
     */
    public E get(int index) {
        checkIndex(index);
        return (E) this.elements[index];
    }

    /**
     * Добавить элемент в конец списка
     *
     * @param element элемент
     */
    public void add(E element) {
        if (this.size == this.elements.length) {
            grow();
        }
        this.elements[this.size++] = element;
    }

    /**
     * Добавление элементов другой коллекции в конец списка
     *
     * @param collection коллекция для до
     */
    public void addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
    }

    /**
     * Удаляет элемент по индексу и создает копию списка без него
     *
     * @param index индекс
     */
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Удаляет элемент из списка(первое совпадение)
     *
     * @param element удаляемый элемент
     */
    public void remove(E element) {
        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(this.elements[i])) {
                    remove(i);
                    return;
                }
            }
        }
    }

    /**
     * Устанавливает все элементы списка в null и устанавливает размер списка в 0
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elements[i] = null;
        }
        size = 0;
    }

    /**
     * Расширение массива в полтора раза от текущей вместимости
     */
    private void grow() {
        int newCapacity = (int) ((this.elements.length * 1.5) + 1);
        this.elements = Arrays.copyOf(this.elements, newCapacity);
    }

    /**
     * Проверка, что индекс находится в пределах размера списка1
     *
     * @param index индекс элемента
     */
    private void checkIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне пределов списка");
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}