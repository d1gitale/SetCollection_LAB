public class Main {
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

        emptySet.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", emptySet.findMax(), emptySet.findMin());
        System.out.printf(
                "emptySet == combinedSet? %b\nemptySet == setFromArray? %b\nemptySet == setFromSet? %b\n\n",
                emptySet.areEqual(combinedSet), emptySet.areEqual(setFromArray), emptySet.areEqual(setFromSet)
        );

        setFromSet.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", setFromSet.findMax(), setFromSet.findMin());
        System.out.printf(
                "setFromSet == combinedSet? %b\nsetFromSet == setFromArray? %b\nsetFromSet == emptySet? %b\n\n",
                setFromSet.areEqual(combinedSet), setFromSet.areEqual(setFromArray), setFromSet.areEqual(emptySet)
        );

        setFromArray.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", setFromArray.findMax(), setFromArray.findMin());
        System.out.printf(
                "setFromArray == combinedSet? %b\nsetFromArray == setFromSet? %b\nsetFromArray == emptySet? %b\n\n",
                setFromArray.areEqual(combinedSet), setFromArray.areEqual(setFromSet), setFromArray.areEqual(emptySet)
        );

        combinedSet.iterate();
        System.out.printf("\nMax: %d\nMin: %d\n", combinedSet.findMax(), combinedSet.findMin());
        System.out.printf(
                "combinedSet == setFromArray? %b\ncombinedSet == setFromSet? %b\ncombinedSet == emptySet? %b\n\n",
                combinedSet.areEqual(setFromArray), combinedSet.areEqual(setFromSet), combinedSet.areEqual(emptySet)
        );

        emptySet.removeElement(emptySet.getData().get(9));
        emptySet.iterate();
        System.out.println();
        emptySet.removeElement(emptySet.getData().get(0));
        emptySet.iterate();
        System.out.println();
        emptySet.removeElement(emptySet.getData().get(4));
        emptySet.iterate();
    }
}
