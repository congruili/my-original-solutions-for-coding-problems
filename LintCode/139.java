// 139. Subarray Sum Closest

class Pair{
    int sum, ind;
    public Pair(int sum, int ind) {
        this.sum = sum;
        this.ind = ind;
    }
}

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        List<Pair> list = new ArrayList<>();        
        list.add(new Pair(0, 0));
        
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            list.add(new Pair(sum, i + 1));            
        }
        
        Comparator<Pair> comp = new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }        
        };
        
        Collections.sort(list, comp);
        
        int minDiff = Integer.MAX_VALUE;
        int begin = 0, end = 0;        
        for (int i = 0; i < nums.length; ++i) {
            Pair one = list.get(i);
            Pair two = list.get(i + 1);
            if (minDiff > Math.abs(one.sum - two.sum)) {
                minDiff = Math.abs(one.sum - two.sum);
                begin = Math.min(one.ind, two.ind);
                end = Math.max(one.ind, two.ind) - 1;                
            }            
        }
        
        int[] rst = new int[2];
        rst[0] = begin;
        rst[1] = end;
        
        return rst;       
    }
}