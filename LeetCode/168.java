public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int res = (n - 1) % 26;
            n = (n - 1) / 26;
            char curt = (char)('A' + res);
            sb.insert(0, curt);
        }
        
        return sb.toString();
    }
}