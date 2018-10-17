// 403. Continuous Subarray Sum II

public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    int curtMax = Integer.MIN_VALUE;
    int curtMin = Integer.MAX_VALUE; 
     
    public List<Integer> continuousSubarraySumII(int[] A) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (A == null || A.length == 0) {
            return list;
        }
        
        int len = A.length;
        
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += A[i];
        }
        
        List<Integer> maxList = findMax(A);
        List<Integer> minList = findMin(A);
        
        if (minList.get(1) - minList.get(0) == len - 1) {
            return maxList;
        }
        
        if (curtMax > sum - curtMin) {
            return maxList;
        }
        
        list.add(minList.get(1) == len - 1 ? 0 : minList.get(1) + 1);
        list.add(minList.get(0) == 0 ? len - 1: minList.get(0) - 1);
        
        return list;
    }
    
    private List<Integer> findMax(int[] A) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        int sum = 0, minSum = 0;
        int begin = -1;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            if (curtMax < sum - minSum) {
                curtMax = sum - minSum;
                list.set(0, begin + 1);
                list.set(1, i);            
            }
            
            if (minSum > sum) {
                minSum = sum;
                begin = i;
            }        
        }
        
        return list;    
    }
    
    private List<Integer> findMin(int[] A) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        int sum = 0, maxSum = 0;
        int begin = -1;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            if (curtMin > sum - maxSum) {
                curtMin = sum - maxSum;
                list.set(0, begin + 1);
                list.set(1, i);            
            }
            
            if (maxSum < sum) {
                maxSum = sum;
                begin = i;
            }        
        }
        
        return list;    
    }
}