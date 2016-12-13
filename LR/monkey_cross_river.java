public static int solution(int[] A, int D) {
    if (A == null || A.length == 0) return -1;
    int len = A.length;
    if (D > len) return 0;

    int[] B = new int[len + 1];

    for (int i = 0; i < D; ++i) B[i] = A[i];

    for (int i = D; i < len; ++i) {
        if (A[i] == -1) {
            B[i] = -1;
            continue;
        }

        int count = 0;
        int tmp = Integer.MAX_VALUE;

        for (int j = 1; j <= D; ++j) {
            if (B[i - j] == -1) count++;
            else tmp = Math.min(tmp, B[i - j]);
        }

        B[i] = count == D ? -1 : Math.max(A[i], tmp);
    }

    int count = 0;
    int rst = Integer.MAX_VALUE;

    for (int j = 1; j <= D; ++j) {
        if (B[len - j] == -1) count++;
        else rst = Math.min(rst, B[len - j]);
    }

    rst = count == D ? -1 : rst;
    return rst;  
}