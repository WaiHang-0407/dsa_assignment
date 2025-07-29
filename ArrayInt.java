public class ArrayInt<T> implements MyList<T> {
    private T[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayInt(){
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
}
