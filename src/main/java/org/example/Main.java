package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(6);
        myArrayList.add(8);
        myArrayList.add(0);
        myArrayList.print();
        myArrayList.quick_sort();
        myArrayList.print();
        myArrayList.remove(1);
        myArrayList.print();
        myArrayList.removeByIndex(1);
        myArrayList.print();
        myArrayList.removeAll();
        myArrayList.print();
    }
}

/**
 * Реализация ArrayList, размер которого будет увеличиваться по мере надобности (после добавления элементов) и методы добавления элемента, удаления, получения элемента, удаление всех элементов, сортировка и Быстрая сортировка
 */
class MyArrayList<T extends Comparable<T>> {
    private static final int INITIAL_CAPACITY = 10;
    private int array_size;
    private Object[] array;

    /**
     * Метод возвращает размер массива
     */
    public int getArray_size() {
        return array_size;
    }

    /**
     * Конструктор, инициализирующий массив с дефолтным размером = 10
     */
    public MyArrayList() {
        array = new Object[INITIAL_CAPACITY];
    }

    /**
     * Метод добавляет элемент в конец массива, принимает в качестве параметра значение добавляемого элемента
     */
    public void add(T element) {
        increaseArraySize();
        array[array_size++] = element;
    }

    /**
     * Метод добавляет элемент на указанный индекс, переданный в качестве первого параметра, и в качестве второго параметра - значение добавляемого элемента
     */
    public void add(int index, T element) {
        check(index);
        increaseArraySize();
        for (int i = array_size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        array_size++;
    }

    /**
     * Метод удаляет элемент, принимает в качестве параметра значение удаляемого элемента
     */
    public void remove(T element) {
        for (int i = 0; i < array_size; i++) {
            if (array[i].equals(element)) {
                removeByIndex(i);
                return;
            }
        }
    }

    /**
     * Метод удаляет элемент по указанному индексу, переданному в качестве параметра
     */
    public void removeByIndex(int index) {
        check(index);
        for (int i = index; i < array_size; i++) {
            array[i] = array[i + 1];
        }
        array_size--;
    }

    /**
     * Метод возвращает элемент с указанным индексом, переданным в качестве параметра
     */
    public T get(int index) {
        check(index);
        T element = (T) array[index];
        return element;
    }

    /**
     * Метод удаляет все элементы из массива
     */
    public void removeAll() {
        array_size = 0;
    }

    /**
     * Метод увеличивает вместимость массива (capacity), если при добавлении элемента его вместимости недостаточно
     */
    private void increaseArraySize() {
        if (array_size + 1 >= array.length) {
            int new_capacity = array_size * 2 + 5;
            Object[] array_increased = new Object[new_capacity];
            System.arraycopy(array, 0, array_increased, 0, array.length);
            array = array_increased;
        }
    }

    /**
     * Метод сортирует элементы в порядке возрастания, алгоритм "Сортировка выбором"
     */
    public void sort() {
        int min;
        T temp;
        for (int i = 0; i < array_size; i++) {
            min = i;
            for (int j = i + 1; j < array_size; j++) {
                if (((T) array[j]).compareTo((T) array[min]) < 0) {
                    min = j;
                }
            }
            temp = (T) array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Метод сортирует элементы в порядке возрастания, алгоритм "Быстрая сортировка", вызывает приватный метод реализующий алгоритм, на вход принимает параметры: индексы диапазона сортировки
     */
    public void quick_sort() {
        quickSort(0, array_size - 1);
    }

    private void quickSort(int start, int end) {
        if (array_size == 0 || start >= end) return;
        int midIndex = start + (end - start) / 2;
        T mid = (T) array[midIndex];

        int i = start;
        int j = end;
        while (i <= j) {
            while (((T) array[i]).compareTo(mid) < 0) i++;
            while (((T) array[j]).compareTo(mid) > 0) j--;
            if (i <= j) {
                T temp = (T) array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) quickSort(start, j);
        if (end > i) quickSort(i, end);
    }

    /**
     * Метод выводит в консоль массив, его размер и длину(capacity)
     */
    public void print() {
        for (int i = 0; i < array_size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nArray size: " + array_size);
        System.out.println("Array length: " + array.length);
    }

    private void check(int index) {
        if (index < 0 || index > array_size) {
            throw new IndexOutOfBoundsException();
        }
    }
}