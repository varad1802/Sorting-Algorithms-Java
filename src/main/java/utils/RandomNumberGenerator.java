package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RandomNumberGenerator {
    /* Generate Random number sequence */
    public static int[] generateRandomNumbers(int size){
        return new Random().ints(0, 100000).limit(size).toArray();
    }

    /* Generate Sorted Sequence of number */
    public static int[] generateSortedRandomNumbers(int size){
        return new Random().ints(0, 100000).limit(size).sorted().toArray();
    }

    /* Generate a reverse sorted sequence */
    public static int[] generateReverseSortedRandomNumbers(int size){
        Integer[] randomList = new Random().ints(0, 100000).limit(size).boxed().toArray(Integer[]::new);
        Arrays.sort(randomList, Collections.reverseOrder());
        return Arrays.stream(randomList).mapToInt(Integer::intValue).toArray();
    }
}
