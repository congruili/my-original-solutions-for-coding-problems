// 17. Subsets (bfs version)

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<>();
        
        if (nums == null) {
            return rst;
        }
        
        Arrays.sort(nums);        
        List<Integer> list = new ArrayList<>();        
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(list);
        
        while (!q.isEmpty()) {
            List<Integer> curt = q.poll();
            rst.add(curt);
            for (int i = 0; i < nums.length; ++i) {
                if (curt.size() == 0 || curt.get(curt.size() - 1) < nums[i]) {
                    List<Integer> newList = new ArrayList<>(curt);
                    newList.add(nums[i]);
                    q.offer(newList);
                }
            }            
        }
        
        return rst;
    }
}