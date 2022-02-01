package dataStructure;

public class Heap {
    int noOfElements;
    int[] array;

    public Heap(int[] array){
        this.array = new int[array.length + 1];
        this.noOfElements = 0;
    }

    public void insert(int element){
        noOfElements = ++noOfElements;
        array[noOfElements] = element;
        int i = noOfElements;
        while (i > 1 && array[i/2] > array[i]){
            int temp = array[i/2];
            array[i/2] = array[i];
            array[i] = temp;
            i = i/2;
        }
    }

    public int removeMin(){
        int temp = array[1];
        array[1] = array[noOfElements];
        noOfElements--;
        int i =1;
        while(i < noOfElements){
            if((2 * i) + 1 <= noOfElements){
                if(array[i] <= array[2*i] && array[i] <= array[(2*i)+1])
                    return temp;
                else{
                    int min = Math.min(array[2*i], array[(2*i)+1]);
                    int j = min == array[2*i]? (2*i) : (2*i)+1;
                    min = array[j];
                    array[j] = array[i];
                    array[i] = min;
                    i=j;
                }
            } else {
                if(2*i <= noOfElements){
                    if(array[i] > array[2*i]){
                        int min = array[i];
                        array[i] = array[2*i];
                        array[2*i] = min;
                    }
                }
                return temp;
            }
        }
        return temp;
    }
}
