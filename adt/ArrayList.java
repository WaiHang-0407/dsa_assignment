package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListInterface<T> {
    private T[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList(){
        capacity = 10;
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // Resize the array
    @SuppressWarnings("unchecked")
    public void resize(){
        capacity *= 2;
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void add(T element){
        if (size == capacity){
            resize();
        }
        data[size++] = element;
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
        
    }

    @Override
    public void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        for (int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) data[currentIndex++];
            }
        };
    }
}
