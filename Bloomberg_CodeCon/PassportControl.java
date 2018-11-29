//Problem        : Passport Control
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.8
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.*;
//Your submission should *ONLY* use the following class name
public class Problem
{
    static class Booth {
        int id;
        int time;
        int count;
        Booth(int id, int time, int count) {
            this.id = id;
            this.time = time;
            this.count = count;
        }
    }
    
    public static void main(String[] args)
    {

       Scanner in = new Scanner(System.in);
       int len = in.nextInt();
       int n_groups = in.nextInt();
       int[] groups = new int[n_groups];
       for (int i = 0; i < n_groups; ++i) {
           groups[i] = in.nextInt();
       }
       
       Comparator<Booth> comp = new Comparator<Booth>() {
           public int compare(Booth a, Booth b) {
               if (a.time == b.time) {
                   return a.id - b.id;
               }
               
               return a.time - b.time;
           }
       };
       
       Queue<Booth> q = new PriorityQueue<Booth>(len, comp);
       
       for (int i = 0; i < len; ++i) {
           q.offer(new Booth(i, 0, 0));
       }
       
       for (int g: groups) {
           Booth curt = q.poll();
           curt.time += g;
           curt.count ++;
           if (curt.count % 10 == 0) {
                curt.time += 5;
           }
           
           q.offer(curt);
       }
       
       int[] rst = new int[len];
       while (!q.isEmpty()) {
           Booth curt = q.poll();
           rst[curt.id] = curt.count;
       }
       
       StringBuilder sb = new StringBuilder();
       for (int r: rst) {
           sb.append(r).append(" ");
       }
       
       System.out.print(sb.toString().trim());
    }

}
