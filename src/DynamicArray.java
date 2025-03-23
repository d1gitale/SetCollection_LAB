import java.util.NoSuchElementException;

public class DynamicArray {
    private int size;
    private int capacity;
    private int[] backingArr;

    public DynamicArray(int ...values) {
        this.size = values.length;
        this.capacity = values.length * 2;
        this.backingArr = new int[capacity];

        System.arraycopy(values, 0, this.backingArr, 0, values.length);
    }

    public DynamicArray(int size, int capacity, int[] values) {
        this.size = size;
        this.capacity = capacity;
        this.backingArr = values;
    }

    public DynamicArray() {
        this.size = 0;
        this.capacity = 10;
        this.backingArr = new int[capacity];
    }

    public int get(int index) {
        return 0;
    }

    public int[] append(int value) {
        return new int[0];
    }

    public int pop(int index) {
        if (size == 0 || index > size - 1 || index < 0) {
            throw new NoSuchElementException("Tried to pop not existing element");
        }

        size--;
        int value = backingArr[index];
        backingArr[index] = 0;
        return value;
    }

    private void resize() {

    }

    public int getSize() {
        return size;
    }
}
