package Sort;

import java.util.Comparator;

/**
 * Created by mandy on 2016/1/4.
 */
public class MergeSort {
    private Comparable[] aux;
    private void merge(Comparable[] array, int low , int mid, int high) {
        int i = low;
        int j = mid+1;
        for (int k = low; k <= high  ; k++) {
            aux[k] = array[k];
        }
        for (int k  = low; k <= high ; k++) {
            if (i>mid) array[k] = aux[j++];
            else if (j > high) array[k] = aux[i++];
            else if (aux[i].compareTo(aux[j])  < 0) array[k] = aux[i++];
            else array[k] = aux[j++];

        }


    }
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        sort(array,0,array.length - 1);
    }
    private void sort(Comparable[] array, int low, int high){
        if (low  >=  high)
            return;

        int mid = (low + high) / 2;
        sort(array,low, mid);
        sort(array, mid+1, high);
        merge(array,low, mid, high );
    }

    public void ButtomUpSort(Comparable[] array) {
        aux = new Comparable[array.length];
        int N = array.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int low = 0; low < N - sz; low += 2 * sz) {
                merge(array, low, low + sz, Math.min(N-1, low + 2 * sz));

            }

        }

    }
}
