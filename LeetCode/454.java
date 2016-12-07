public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int lenA = A.length, lenB = B.length, lenC = C.length, lenD = D.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < lenA; ++i) {
            for (int j = 0; j < lenB; ++j) {
                int curt = A[i] + B[j];
                if (!map.containsKey(curt)) map.put(curt, 0);
                map.put(curt, map.get(curt) + 1);
            }
        }
        
        int rst = 0;
        for (int i = 0; i < lenC; ++i) {
            for (int j = 0; j < lenD; ++j) {
                int curt = 0 - C[i] - D[j];
                if (map.containsKey(curt)) rst += map.get(curt);
            }
        }
        
        return rst;
    }
}