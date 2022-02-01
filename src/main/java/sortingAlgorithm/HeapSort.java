package sortingAlgorithm;

import dataStructure.Heap;
import utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    static Heap heap = null;

    public static void sort(int[] array, int min, int max){
        heap = new Heap(array);
        /* Insert elements in the heap */
        for (int i = min; i <= max; i++) {
            heap.insert(array[i]);
        }

        /* Remove the minimum element from the heap and put it back in the sequence */
        for(int i = min; i <= max; i++) {
            array[i] = heap.removeMin();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Array type you want for the run:");
        System.out.println("1. Sorted Array");
        System.out.println("2. Reverse Sorted Array");
        System.out.println("3. Random Array");
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        System.out.println("Enter the size of Array:");
        int size = scanner.nextInt();
        int [] array;
        if(choice == 1)
            array = RandomNumberGenerator.generateSortedRandomNumbers(size);
        else if(choice == 2)
            array = RandomNumberGenerator.generateReverseSortedRandomNumbers(size);
        else
            array = RandomNumberGenerator.generateRandomNumbers(size);
        System.out.println("\nBefore sorting:");
        Arrays.stream(array).forEach(e -> System.out.print("\t"+e+"\t"));
        sort(array, 0, array.length-1);
        System.out.println("\nAfter sorting:");
        Arrays.stream(array).forEach(e -> System.out.print("\t"+e+"\t"));
        System.out.println("\nExecution Complete");
    }
}
