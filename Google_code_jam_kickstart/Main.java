import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Interval {
    int begin, end;
    public Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        final String dir = System.getProperty("user.dir");
        System.out.println(dir);
        String fin = dir + "/sub-2.in";

        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = br.readLine().trim();
        int caseCount = Integer.parseInt(line);
        int caseInd = 0;

        while (caseInd < caseCount) {
            line = br.readLine().trim();
            int busCount = Integer.parseInt(line);
            line = br.readLine().trim();
            String[] strs = line.split(" ");

            // System.out.println(strs.length == (busCount * 2));

            Interval[] intervals = new Interval[busCount];

            for (int i = 0; i < busCount; ++i) {
                int begin = Integer.parseInt(strs[2 * i]);
                int end = Integer.parseInt(strs[2 * i + 1]);
                intervals[i] = new Interval(begin, end);
            }

            line = br.readLine().trim();
            int subcaseCount = Integer.parseInt(line);
            String[] rst = new String[subcaseCount];
            for (int i = 0; i < subcaseCount; ++i) {
                line = br.readLine().trim();
                int city = Integer.parseInt(line);
                // System.out.println("city: " + city);
                rst[i] = countValidSubcase(city, intervals) + "";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(caseInd + 1);
            sb.append(": ");
            sb.append(String.join(" ", rst));

            System.out.println(sb.toString());
            caseInd++;
            if (caseInd < caseCount) {
                br.readLine();
            }
        }

        br.close();


    }

    private static int countValidSubcase(int city, Interval[] intervals) {
        int rst = 0;
        for (Interval i: intervals) {
            if (i.begin <= city && city <= i.end) {
                rst++;
            }
        }

        return rst;
    }
}
