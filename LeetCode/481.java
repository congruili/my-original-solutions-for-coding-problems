public class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        
        int[] nums = new int[n + 1];
        
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        
        int numInd = 3;
        int count = 2;
        int curt = 1;
        
        while (numInd < n) {
            for (int j = 0; j < nums[count]; ++j) {
                nums[numInd++] = curt;
            }
            
            count++;
            if (curt == 1) curt = 2;
            else curt = 1;
        }
        
        int rst = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) rst++;
        }
        
        return rst;
    }
}