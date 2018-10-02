// 180. Binary Representation

public class Solution {
    /**
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        String[] strs = n.split("\\.");
        
        String rst = "";
        
        rst += getInt(strs[0]);
        
        if (rst.length() == 0) {
            rst = "0";
        }
        
        if (strs.length == 1) {
            return rst;
        }

        String decimal = getDecimal(strs[1]);
        
        if (decimal.equals("ERROR")) {
            return "ERROR";
        }
        
        if (decimal.equals("0") || decimal.length() == 0) {
            return rst;
        }
        
        return rst + "." + decimal;
    }
    
    private String getInt(String s) {
        long num = Long.parseLong(s);
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            sb.insert(0, num % 2);
            num /= 2;
        }
        
        return sb.toString();
    }
    
    private String getDecimal(String s) {
        double num = Double.parseDouble("0." + s);
        
        StringBuilder sb = new StringBuilder();
        double curt = 0.5;
        
        while (num != 0) {
            int n = 0;
            if (num >= curt) {
                n = (int)(num / curt);
            }
            
            sb.append(n);
            
            if (sb.length() > 32) {
                return "ERROR";
            }
            
            num = num - n * curt;
            curt /= 2.0;
        }
        
        return sb.toString();
    }
    
    
}