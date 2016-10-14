// Please refer to Bézout's identity here: https://en.wikipedia.org/wiki/B%C3%A9zout%27s_identity


import java.util.*;

public class RoboGolfer {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = in.nextInt();

        int len = in.nextInt();
        int[] rsts = new int[len];
        for (int i = 0; i < len; ++i) rsts[i] = in.nextInt();

        int gcd = nums[0];

        for (int i = 1; i < n; ++i) {
            if (gcd == 1) break;
            gcd = GCD(gcd, nums[i]);
        }

        for (int i = 0; i < len; ++i) {
            if (rsts[i] % gcd == 0) System.out.println("yes");
            else System.out.println("no");
        }
    }

    public static int GCD(int a, int b) {
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }


}
