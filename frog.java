public int solution (int[] A, int X, int D) {
    if (X <= D) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < A.length; ++i) {
        if (map.containsKey(A[i])) continue;
        else map.put(A[i], i);
    }

    int[] time = new int[X];
    Arrays.fill(time, -1);
    time[0] = 0;
    for (int i = 1; i < X; ++i) {
        if (map.containsKey(i)) time[i] = map.get(i);
    }

    int[] rst = new int[X];

    for (int i = 0; i <= D; ++i) rst[i] = time[i];

    for (int i = D + 1; i < X; ++i) {
        if (time[i] == -1) {
            rst[i] = -1;
            continue;
        }

        int count = 0;
        int tmp = Integer.MAX_VALUE;

        for (int j = 1; j <= D; ++j) {
            if (rst[i - j] == -1) count++;
            else tmp = Math.min(tmp, rst[i - j]);
        }

        rst[i] = count == D ? -1 : Math.max(time[i], tmp);
    }

    int count = 0;
    int final_rst = Integer.MAX_VALUE;

    for (int j = 1; j <= D; ++j) {
        if (rst[X - j] == -1) count++;
        else final_rst = Math.min(final_rst, rst[X - j]);
    }

    final_rst = count == D ? -1 : final_rst;
    return final_rst;
}