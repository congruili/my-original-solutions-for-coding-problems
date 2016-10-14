import java.util.*;

public class ZiplineHills {

    public static void main(String[] args) {

        int[] nums = {67, 40, 21, 9, 37, 77};
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        int len = nums.length;

        for (int i = 0; i < len; ++i) {
            for (int j = Math.max(i - 2, 0); j <= Math.min(i + 2, len - 1); ++j) {
                if (nums[j] < nums[i]) {
                    if (!map.containsKey(i)) map.put(i, new HashSet<Integer>());
                    map.get(i).add(j);
                    children.add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; ++i) {
            if (!children.contains(i)) queue.offer(i);
        }

        int rst = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<Integer> nextLevel = new HashSet<>();
            for (int i = 0; i < size; ++i) {
                int curt = queue.poll();
                if (map.containsKey(curt)) nextLevel.addAll(map.get(curt));
            }
            for (int j: nextLevel) queue.offer(j);
            rst++;

        }

        System.out.println(rst - 1);
    }
}
