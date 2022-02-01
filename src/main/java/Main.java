import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import sortingAlgorithm.*;
import utils.LineChart;
import utils.RandomNumberGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] size = new int[] {10000, 20000, 25000, 50000, 75000, 100000};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Array type you want for the run:");
        System.out.println("1. Sorted Array");
        System.out.println("2. Reverse Sorted Array");
        System.out.println("3. Random Array");
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        for(int runSize : size){
            System.out.println("\n-----------------------------------------\n");
            System.out.println("Size of data: " + runSize);
            int[] array;
            if(choice ==1){
                System.out.println("Selected Random Sorted Array");
                array = RandomNumberGenerator.generateSortedRandomNumbers(runSize);
            }else if(choice == 2){
                System.out.println("Selected Random Reverse Sorted Array");
                array = RandomNumberGenerator.generateReverseSortedRandomNumbers(runSize);
            }else{
                System.out.println("Selected Random Array");
                array = RandomNumberGenerator.generateRandomNumbers(runSize);
            }
            long start,stop;
            int count = 5;
            long avgTimeInsertionSort = 0;
            long avgTimeMergeSort = 0;
            long avgTimeHeapSort = 0;
            long avgTimeInplaceQuickSort = 0;
            long avgTimeModifiedQuickSort = 0;
            while(count>0){
                int [] array1 = array.clone();
                start = System.currentTimeMillis();
                InsertionSort.sort(array1, 0, array.length-1);
                stop = System.currentTimeMillis();
                avgTimeInsertionSort += (stop - start);
                int [] array2 = array.clone();
                start = System.currentTimeMillis();
                MergeSort.sort(array2, 0, array.length-1);
                stop = System.currentTimeMillis();
                avgTimeMergeSort += (stop - start);
                int [] array3 = array.clone();
                start = System.currentTimeMillis();
                HeapSort.sort(array3, 0, array.length-1);
                stop = System.currentTimeMillis();
                avgTimeHeapSort += (stop - start);
                int [] array4 = array.clone();
                start = System.currentTimeMillis();
                InplaceQuickSort.sort(array4, 0, array.length-1);
                stop = System.currentTimeMillis();
                avgTimeInplaceQuickSort += (stop - start);
                int [] array5 = array.clone();
                start = System.currentTimeMillis();
                ModifiedQuickSort.sort(array5, 0, array.length-1);
                stop = System.currentTimeMillis();
                avgTimeModifiedQuickSort += (stop - start);
                count--;
            }
            System.out.println("Average Execution Times for the run:");
            System.out.println("Execution Time for Insertion sort: " + (avgTimeInsertionSort/5) + "ms");
            dataset.addValue(avgTimeInsertionSort/5, "Insertion sort" , Integer.toString(runSize));
            System.out.println("Execution Time for Merge sort: " + (avgTimeMergeSort/5) + "ms");
            dataset.addValue(avgTimeMergeSort/5, "Merge sort" , Integer.toString(runSize));
            System.out.println("Execution Time for Heap sort: " + (avgTimeHeapSort/5) + "ms");
            dataset.addValue(avgTimeHeapSort/5, "Heap sort" , Integer.toString(runSize));
            System.out.println("Execution Time for In-place Quick sort: " + (avgTimeInplaceQuickSort/5) + "ms");
            dataset.addValue(avgTimeInplaceQuickSort/5, "In-place Quick sort" , Integer.toString(runSize));
            System.out.println("Execution Time for Modified Quick sort: " + (avgTimeModifiedQuickSort/5) + "ms");
            dataset.addValue(avgTimeModifiedQuickSort/5, "Modified Quick sort" , Integer.toString(runSize));
        }

        LineChart chart = new LineChart(
                "Algorithm Analysis" ,
                "Algorithm Analysis",
                dataset);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible( true );
    }
}
