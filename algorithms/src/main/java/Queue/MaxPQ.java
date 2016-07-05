package Queue;

/**
 * Created by mandy on 2015/11/27.
 */
public  class MaxPQ<Key extends Comparable<Key>> {
    private Key[] heap;
    private int capacity;
    private int num;

    public  MaxPQ(int capacity){
        heap =(Key[]) new Comparable[capacity + 1];


    }

    void insert(Key v){
        num ++;
         heap[num] = v;
         swim(num);
    }
    public Key max(){
        return heap[1];

    }

    Key delMax(){
        Key max = heap[1];
        heap[1] = heap[num];
        heap[num] = null;
        num --;
        sink(1);
        return max;



    }
    boolean isEmpty (){
        return num == 0;
    }

    int size(){
        return num;
    }


    private void swim(int k){
        while (k > 1 && less(parent(k), k)){
            swap(k, parent(k));
            k = parent(k);
        }

    }

    private void swap(int i, int k) {
        Key t = heap[i];
        heap[i] = heap[k];
        heap[k] = t;
    }


    private int parent(int i){
            return i/2; //index begin with 1
        }
    private int left(int i){
        return 2*i;
    }
    private int right(int i){
        return 2*i + 1;
    }
    private boolean less(int i, int j){
        return heap[i].compareTo(heap[j]) < 0;

    }

    private void sink(int k){
              reHeapify(k);
//        while (left(k) <= num) {
//            int j = left(k);
//            if(j + 1<=num && less(j,j+1)) j++;
//            if (!less(k, j)) break;
//            swap(k,j);
//            k = j;
//        }
    }
    private void reHeapify(int k) {

        if (left(k) > num) return;
        int largest = left(k);
        if(largest + 1<=num && less(largest,largest+1)) largest++;
        if (!less(k, largest)) return;
        swap(k,largest);
        reHeapify(largest);



    }
}
