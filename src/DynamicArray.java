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

    public DynamicArray(DynamicArray arr) {
        this.size = arr.size;
        this.capacity = arr.capacity;
        this.backingArr = new int[capacity];

        System.arraycopy(arr.backingArr, 0, this.backingArr, 0, arr.size);
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Tried to access not existing element");
        }

        return backingArr[index];
    }

    public void append(int value) {
        if (size == capacity) {
            resize();
        }

        backingArr[size++] = value;
    }

    public int pop(int index) {
        if (size == 0 || index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Tried to pop not existing element");
        }

        size--;
        int value = backingArr[index];
        backingArr[index] = 0;
        return value;
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(backingArr, 0, newArray, 0, backingArr.length);
        backingArr = newArray;
    }

    public int getSize() {
        return size;
    }
}
