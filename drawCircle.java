public class drawCircle {

    public static void main(String[] args) {
        drawCircle(10);
    }

    public static void drawPoint(int x, int y) {
        System.out.print(x);
        System.out.print(" ");
        System.out.println(y);
    }

    public static void drawCircle(int r) {
        int y = r;
        for (int x = 0; x <= r; ++x) {
            while (x * x + y * y >= r * r && y >= 0) {
                drawPoint(x, y);
                drawPoint(-x, y);
                drawPoint(x, -y);
                drawPoint(-x, -y);
                y--;
            }
        }
    }
}