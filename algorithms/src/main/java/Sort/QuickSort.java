package Sort;

import java.util.Comparator;

/**
 * Created by mandy on 2016/1/5.
 */
public class QuickSort {
    private int partition(Comparable[] array, int low, int high) {

        Comparable pivot = array[high];
        int i = low - 1;
        int j = low -1;
        while (j < high-1) {
            j++;
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array,i, j);
            }
        }
        swap(array,i+1,high);
        return i+1;


    }

    private void swap(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void sort(Comparable[] array,int low, int high) {
        if (low >= high)
            return ;
        int i =partition(array,low, high);
        sort(array, low, i-1);
        sort(array,i+1,high);

    }

    public void sort(Comparable[] array) {
        sort(array,0,array.length-1);
    }
}
