public class SetCollection {
    private int size;
    private final DynamicArray data;

    public SetCollection() {
        this.data = new DynamicArray();
        this.size = 0;
    }

    public SetCollection(int[] values) {
        this.data = new DynamicArray();
        this.size = 0;

        for (int el : values) {
            addElement(el);
        }
    }

    public SetCollection(SetCollection set) {
        this.data = new DynamicArray(set.getData());
        this.size = data.getSize();
    }

    public void addElement(int element) {
        if (contains(element)) {
            return;
        }

        for (int i = 0; i < size; i++) {
            if (data.get(i) > element) {
                data.addElement(i, element);
                size++;
                return;
            } else if (i == size - 1) {
                data.addElement(i + 1, element);
                size++;
                return;
            }
        }

        data.addElement(0, element);
        size++;
    }

    public void removeElement(int element) {
        int foundIndex = findElement(element);
        data.pop(foundIndex);
        size--;
    }

    public boolean contains(int element) {
        return findElement(element) != -1;
    }

    private int findElement(int element) {
        int index = -1;
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (data.get(mid) < element) {
                low = mid + 1;
            } else if (data.get(mid) > element) {
                high = mid - 1;
            } else if (data.get(mid) == element) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int findMax() {
        return data.get(size - 1);
    }

    public int findMin() {
        return data.get(0);
    }

    public void iterate() {
        for (int i = 0; i < size; i++) {
            System.out.println(data.get(i));
        }
    }

    public SetCollection combine(SetCollection set) {
        SetCollection combinedSet = new SetCollection(this);

        for (int i = 0; i < set.getSize(); i++) {
            combinedSet.addElement(set.getData().get(i));
        }

        return combinedSet;
    }

    public boolean areEqual(SetCollection set) {
        if (size != set.getSize()) {
            return false;
        }

        DynamicArray setData = set.getData();
        for (int i = 0; i < size; i++) {
            if (data.get(i) != setData.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public DynamicArray getData() {
        return data;
    }
}