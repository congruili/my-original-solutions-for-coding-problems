public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int flag = 1;
        int len = points.size();
        
        List<Integer> last = points.get(len - 1);
        List<Integer> zero = points.get(0);
        List<Integer> one = points.get(1);
        
        int a1 = last.get(0) - zero.get(0);
        int b1 = last.get(1) - zero.get(1);
        int a2 = zero.get(0) - one.get(0);
        int b2 = zero.get(1) - one.get(1);
        
        if (a1 * b2 - a2 * b1 < 0) flag = -1;
        
        for (int i = 1; i < len; ++i) {
            List<Integer> first = points.get(i - 1);
            List<Integer> second = points.get(i);
            List<Integer> third = new ArrayList<>();
            if (i == len - 1) third = points.get(0);
            else third = points.get(i + 1);
            
            a1 = first.get(0) - second.get(0);
            b1 = first.get(1) - second.get(1);
            a2 = second.get(0) - third.get(0);
            b2 = second.get(1) - third.get(1);
            
            if ((a1 * b2 - a2 * b1) * flag < 0) return false;
        }
        
        return true;
    }
}