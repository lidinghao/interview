/**
 * Created by mandy on 2016/1/13.
 */
public class NumArray {
    public int[] intervals;
    private int[] nums;
    public NumArray(int[] nums) {
        intervals = new int[4*nums.length];;
        this.nums = nums;
        if(nums.length > 0)
        build(1,0,nums.length -1);

    }

    void update(int i, int val) {
        modify(i, val, 1, 0, nums.length - 1);

    }

    public int sumRange(int i, int j) {
        if (i>j)
            return 0;
        return sum(i, j, 1, 0, nums.length - 1);

    }
    // range interval segment ? what ever
    //root from 1
    public void build(int root, int range_l, int range_r) {
        if (range_r == range_l) {
            intervals[root] = nums[range_l];
            return;

        }

        int mid = (range_l + range_r) / 2;
        build(root*2, range_l, mid);
        build(root*2 + 1, mid+1, range_r);
        intervals[root] = intervals[root * 2] + intervals[root * 2 + 1];
       // s[id] = s[id * 2] + s[id * 2 + 1];
    }

    private int sum(int x, int y, int root, int range_l, int range_r) {
        if( x <= range_l && range_r <= y)
            return intervals[root];
        // rang_l <= rang_r < x <= y or x <= y < rang_l <= rang_r
        else if(range_l >y || range_r < x  ){
            return 0;
        }
        int mid = (range_l + range_r) / 2;
        return  sum(x, y, root*2, range_l, mid) + sum(x, y, root*2+1, mid+1,range_r);

    }

    private void modify(int index, int value, int root, int range_l, int range_r) {
        //x <= range_l <= range_r <= y
        if(range_l==range_r && range_l == index){
            intervals[root] = value;
            return;
        }

        int mid = (range_l + range_r) / 2;
           if(index <= mid)
            modify(index,value, root*2, range_l, mid);
        else
            modify(index,value, root*2+1, mid+1, range_r);

        intervals[root] = intervals[root*2] + intervals[root*2 + 1];

    }
}
