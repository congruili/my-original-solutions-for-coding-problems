/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> rst = new HashMap<>();
        
        if (results == null || results.length == 0) {
            return rst;
        }
        
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        for (Record r: results) {
            if (!map.containsKey(r.id)) {
                map.put(r.id, new PriorityQueue<Integer>());
            }
            
            Queue<Integer> q = map.get(r.id);
            
            if (q.size() < 5) {
                q.offer(r.score);
            } else {
                if (q.peek() < r.score) {
                    q.poll();
                    q.offer(r.score);
                }
            }
        }
        
        for (int key: map.keySet()) {
            Queue<Integer> q = map.get(key);
            int size = q.size();
            
            double sum = 0.0;
            while (!q.isEmpty()) {
                sum += q.poll();
            }
            
            rst.put(key, sum / size);
        }
        
        return rst;
    }
}