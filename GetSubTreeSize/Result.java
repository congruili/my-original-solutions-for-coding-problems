public class Result {
    int start, end, count;
    Result left, right;
    public Result(int start, int end) {
        this.start = start;
        this.end = end;
        left = null;
        right = null;
        count = 1;
    }
}
