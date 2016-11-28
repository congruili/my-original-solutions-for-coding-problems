public class Solution {
    List<String> rst = new ArrayList<>();
    
    public List<String> generateAbbreviations(String word) {
        char[] letters = word.toCharArray();
        helper("", 0, 0, letters);
        return rst;
    }
    
    public void helper(String curt, int ind, int count, char[] letters) {
        if (ind == letters.length) {
            if (count > 0) curt = curt + "" + count;
            rst.add(curt);
            return;
        }
        
        helper(curt, ind + 1, count + 1, letters);
        helper(curt + "" + (count > 0 ? count : "") + letters[ind], ind + 1, 0, letters);
    }
}