package sortingAlgorithm;

import utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class ModifiedQuickSort {

    public static void sort(int[] array, int min, int max){
        /* Perform quick sort if array length less than or equal to 10 */
        if(min + 10 <= max){
            /* Get the pivot by performing median of three */
            int pivot = medianOfThree(array, min, max);
            int temp;
            int i = min+1;
            int j = max-2;
            while(i<=j){
                while(i<=j && array[i] <= pivot)
                    i++;
                while(i<=j && array[j] > pivot)
                    j--;
                if(i<j){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            temp = array[i];
            array[i] = array[max-1];
            array[max-1] = temp;
            sort(array, min, i-1);
            sort(array, i+1, max);
        }else{
            InsertionSort.sort(array, min, max);
        }
    }

    /* Function to get the pivot using median of three */
    private static int medianOfThree(int[] array, int min, int max){
        int temp;
        int mid = (min + max) / 2;
        if (array[mid] < array[min]){
            temp = array[min];
            array[min] = array[mid];
            array[mid] = temp;
        }
        if (array[max] < array[min]){
            temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        if (array[max] < array[mid]){
            temp = array[mid];
            array[mid] = array[max];
            array[max] = temp;
        }
        temp = array[max-1];
        array[max-1] = array[mid];
        array[mid] = temp;
        return array[max-1];
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
