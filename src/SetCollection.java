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

    public static void main(String... args) {
        final int NUMBER_OF_DIGITS = 1000000;
        final int DATA_LEN = 10;

        int[] arr = new int[DATA_LEN];

        for (int i = 0; i < DATA_LEN; i++) {
            arr[i] = (int)(java.lang.Math.random() * NUMBER_OF_DIGITS - java.lang.Math.random() * NUMBER_OF_DIGITS);
        }

        SetCollection setFromArray = new SetCollection(arr);
        SetCollection emptySet = new SetCollection();
        SetCollection setFromSet = new SetCollection(setFromArray);

        for (int i = 0; i < DATA_LEN; i++) {
            emptySet.addElement((int)(java.lang.Math.random() * NUMBER_OF_DIGITS - java.lang.Math.random() * NUMBER_OF_DIGITS));
        }

        SetCollection combinedSet = setFromArray.combine(setFromSet);

        // emptySet test
        emptySet.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", emptySet.findMax(), emptySet.findMin());
        System.out.printf(
                "emptySet == emptySet? %b\nemptySet == setFromArray? %b\nemptySet == setFromSet? %b\n\n",
                emptySet.areEqual(emptySet), emptySet.areEqual(setFromArray), emptySet.areEqual(setFromSet)
        );

        // setFromSet test
        setFromSet.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", setFromSet.findMax(), setFromSet.findMin());
        System.out.printf(
                "setFromSet == setFromSet? %b\nsetFromSet == setFromArray? %b\nsetFromSet == emptySet? %b\n\n",
                setFromSet.areEqual(setFromSet), setFromSet.areEqual(setFromArray), setFromSet.areEqual(emptySet)
        );

        // setFromArray test
        setFromArray.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", setFromArray.findMax(), setFromArray.findMin());
        System.out.printf(
                "setFromArray == setFromArray? %b\nsetFromArray == setFromSet? %b\nsetFromArray == emptySet? %b\n\n",
                setFromArray.areEqual(setFromArray), setFromArray.areEqual(setFromSet), setFromArray.areEqual(emptySet)
        );

        // combinedSet test
        combinedSet.iterate();
    }
}