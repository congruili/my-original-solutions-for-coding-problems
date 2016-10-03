public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        int[][] rst = new int[m][2];
        Arrays.fill(rst, new int[]{-1, -1});
        
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare (int[] A, int[] B) {
                if (A[0] != B[0]) return A[0] - B[0];
                return B[1] - A[1];
            }
        };
        
        Arrays.sort(people, comp);
        
        for (int[] person: people) {
            int empty = person[1];
            int count = 0;
            int ind = 0;
            while(count < empty) {
                if (rst[ind][0] == -1) count++;
                ind++;
            }
            
            while(rst[ind][0] != -1) ind++;
            rst[ind] = person;
        }
        
        return rst;
    }
}