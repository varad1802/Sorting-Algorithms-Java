package sortingAlgorithm;

import utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InplaceQuickSort {
    public static void sort(int[] array, int min, int max){
        if(min < max){
            /* Leftmost element selected as the pivot */
            int pivotIndex = min;
            int pivot = array[pivotIndex];
            /* Get the position of the pivot in the array to divide it into two sub arrays
            *  with value of numbers less than or equal to and one greater than the pivot */
            int index = inPlacePartition(array, pivot, min, max, pivotIndex);

            /* Recursive call to the sub arrays */
            sort(array, min, index-1);
            sort(array, index+1, max);
        }
    }

    private static int inPlacePartition(int[] array,int pivot, int min, int max, int pivotIndex){
        int i = min+1;
        int j = max;
        while(i <= j){
            while(i<=j && array[i] <= pivot)
                i++;
            while(i<=j && array[j] > pivot)
                j--;
            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[j];
        array[j] = pivot;
        array[pivotIndex] = temp;
        return j;
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
