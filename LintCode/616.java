class Course {
    int degree;
    List<Integer> nextCourses;
    
    public Course(int degree) {
        this.degree = degree;
        nextCourses = new ArrayList<>();
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
            courses[first].nextCourses.add(second);
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] rst = new int[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            if (courses[i].degree == 0) {
                rst[count++] = i;
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curt = q.poll();
            for (int nextCourse: courses[curt].nextCourses) {
                courses[nextCourse].degree--;
                if (courses[nextCourse].degree == 0) {
                    rst[count++] = nextCourse;
                    q.offer(nextCourse);
                }
            }
        }
        
        if (count == numCourses) {
            return rst;
        }
        
        return new int[0];
        
    }
}
