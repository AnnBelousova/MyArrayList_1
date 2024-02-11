package org.example;

import org.junit.jupiter.api.Assertions;
/**
 * Класс Test - тестирует все методы из класса MyArrayList
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void testGetReturnException() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(0));
    }

    @org.junit.jupiter.api.Test
    public void testAddOneElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        Assertions.assertEquals(1, myArrayList.get(0).intValue());
    }

    @org.junit.jupiter.api.Test
    public void testReturnArraySize() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        Assertions.assertEquals(myArrayList.getArray_size(), 3);
    }

    @org.junit.jupiter.api.Test
    public void testReturnElementAddedByIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0, 6);
        Assertions.assertEquals(6, myArrayList.get(0).intValue());
    }

    @org.junit.jupiter.api.Test
    public void testReturnArraySizeAfterRemovingOneElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(2);
        Assertions.assertEquals(myArrayList.getArray_size(), 2);
    }

    @org.junit.jupiter.api.Test
    public void testReturnArraySizeAfterRemovingOneElementByIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.removeByIndex(1);
        Assertions.assertEquals(myArrayList.getArray_size(), 2);
    }

    @org.junit.jupiter.api.Test
    public void testReturnSizeEmptyArray() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.removeAll();
        Assertions.assertEquals(myArrayList.getArray_size(), 0);
    }

    @org.junit.jupiter.api.Test
    public void testReturnSortedArray() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(30);
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.sort();
        Assertions.assertEquals(myArrayList.get(0).intValue(), 4);
        Assertions.assertEquals(myArrayList.get(1).intValue(), 6);
        Assertions.assertEquals(myArrayList.get(2).intValue(), 30);
    }

    @org.junit.jupiter.api.Test
    public void testReturnSortedArrayQuickMethod() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(30);
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.quick_sort();
        Assertions.assertEquals(myArrayList.get(0).intValue(), 4);
        Assertions.assertEquals(myArrayList.get(1).intValue(), 6);
        Assertions.assertEquals(myArrayList.get(2).intValue(), 30);
    }
}
