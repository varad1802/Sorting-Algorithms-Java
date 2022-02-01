package sortingAlgorithm;

import utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void sort(int[] array, int min, int max){
        if(min < max){
            /* Get the middle element to divide the array into two sub-parts*/
            int mid = (min + max)/2;
            sort(array, min, mid);
            sort(array, mid+1, max);
            merge(array, min, mid, max);
        }
    }

    /* Merge function to sort and merge the two sub arrays */
    private static void merge(int[] array, int min, int mid, int max){
        int[] leftArray = new int[mid - min + 1];
        int[] rightArray = new int[max - mid];
        int k = min;

        for(int i = 0; i < leftArray.length; i++){
            leftArray[i] = array[k++];
        }
        k = mid + 1;
        for(int i = 0; i < rightArray.length; i++){
            rightArray[i] = array[k++];
        }

        int i = 0;
        int j = 0;
        k = min;

        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] < rightArray[j]){
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while(i < leftArray.length)
            array[k++] = leftArray[i++];
        while(j < rightArray.length)
            array[k++] = rightArray[j++];
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
