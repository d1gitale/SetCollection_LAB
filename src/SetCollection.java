public class SetCollection {
    private int size;
    private DynamicArray data;

    public SetCollection() {
        this.size = 0;
        this.data = new DynamicArray();
    }

    public SetCollection(int[] values) {
        for (int el : values) {
            addElement(el);
        }
    }

    public SetCollection(SetCollection set) {
        this.size = set.getSize();
        this.data = new DynamicArray(set.getData());
    }

    public void addElement(int element) {
        if (contains(element)) {
            return;
        }

        for (int i = 0; i < size; i++) {
            if (data.get(i) == element) {
                data.addElement(i, element);
            }
        }
    }

    public void removeElement(int element) {
        return;
    }

    public boolean contains(int element) {
        return false;
    }

    public int findMax() {
        return 0;
    }

    public int findMin() {
        return 0;
    }

    public void iterate() {
        return;
    }

    public SetCollection combine(SetCollection set) {
        return new SetCollection();
    }

    public boolean areEqual(SetCollection set) {
        return false;
    }

    public int getSize() {
        return size;
    }

    public DynamicArray getData() {
        return data;
    }
}