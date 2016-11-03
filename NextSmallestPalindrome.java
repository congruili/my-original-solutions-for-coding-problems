public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 9, 3, 2};

        int[] rst = findNext(nums);

        for (int i: rst) System.out.print(i);

    }

    public static int[] findNext(int[] nums) {
        int len = nums.length;
        int countNine = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 9) countNine++;
        }

        if (countNine == len) {
            int[] rst = new int[len + 1];
            rst[0] = 1;
            for (int i = 1; i < len; ++i) rst[i] = 0;
            rst[len] = 1;
            return rst;
        }

        int mid = len / 2;
        int i = mid - 1;
        int j = (len % 2 == 1) ? (mid + 1) : mid;

        while(i >= 0 && nums[i] == nums[j]) {
            i--; j++;
        }

        boolean leftSideSmaller = false;

        if (i < 0 || nums[i] < nums[j]) leftSideSmaller = true;

        while(i >= 0) {
            nums[j] = nums[i];
            i--;
            j++;
        }

        if (leftSideSmaller) {
            int carry = 1;
            if (len % 2 == 1) {
                nums[mid] += carry;
                carry = nums[mid] / 10;
                nums[mid] %= 10;
            }

            i = mid - 1;
            j = (len % 2 == 1) ? (mid + 1) : mid;

            while(i >= 0) {
                nums[i] += carry;
                carry = nums[i] / 10;
                nums[i] %= 10;
                nums[j] = nums[i];
                i--;
                j++;
            }
        }

        return nums;
    }
}
