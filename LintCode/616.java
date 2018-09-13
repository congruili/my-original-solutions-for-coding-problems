// 616. Course Schedule II

class Course {
    int degree;
    List<Integer> next;
    public Course(int degree) {
        this.degree = degree;
        next = new ArrayList<>();
    }
}

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses == 0) {
            return new int[0];
        }
        
        Course[] courses = new Course[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            courses[i] = new Course(0);
        }
        
        for (int[] item: prerequisites) {
            int first = item[1];
            int second = item[0];
            
            courses[second].degree++;
            courses[first].next.add(second);
        }
        
        int[] rst = new int[numCourses];
        int ind = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; ++i) {
            if (courses[i].degree == 0) {
                q.offer(i);
                rst[ind++] = i;
            }
        }
        
        while (!q.isEmpty()) {
            int curt = q.poll();
    
            for (int item: courses[curt].next) {
                courses[item].degree--;
                if (courses[item].degree == 0) {
                    q.offer(item);
                    rst[ind++] = item;
                }
            }
        }
        
        if (ind == numCourses) {
            return rst;
        }
        
        return new int[0];
    }
}