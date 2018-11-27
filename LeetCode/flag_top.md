## 199. Binary Tree Right Side View
<pre>
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> map;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        map = new HashMap<>();        
        helper(root, 1);  
        
        int i = 1;
        while (map.containsKey(i)) {
            list.add(map.get(i));
            i ++;
        }
        
        return list;        
    }
    
    private void helper(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        
        map.put(d, root.val);
        helper(root.left, d + 1);
        helper(root.right, d + 1);
    }
}
</pre>

## 301. Remove Invalid Parentheses
<pre>
class Solution {
    Set<String> cands = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        
        if (s == null) {
            return list;        
        }
        
        int left = 0, right = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                left ++;
            } else if ( c == ')') {
                if (left == 0) {
                    right ++;
                }
                
                if (left > 0) {
                    left --;
                }            
            }        
        }
        
        dfs(s, 0, 0, 0, left, right, new StringBuilder());  
        
        return new ArrayList<String>(cands);
    }
    
    private void dfs(String s, int ind, int l_count, int r_count, int l_rem, int r_rem, StringBuilder sb) {
        if (ind == s.length()) {
            if (l_rem == 0 && r_rem == 0) {
                cands.add(sb.toString());
            }
        } else {
            char c = s.charAt(ind);
            int len = sb.length();
            if ((c == '(' && l_rem > 0) || (c == ')' && r_rem > 0)) {
                dfs(s, ind + 1, l_count, r_count, c == '(' ? l_rem - 1 : l_rem, c == ')' ? r_rem - 1 : r_rem, sb);         
            }
            
            sb.append(c);
            if (c != '(' && c != ')') {
                dfs(s, ind + 1, l_count, r_count, l_rem, r_rem, sb);
            } else if ( c == '(') {
                dfs(s, ind + 1, l_count + 1, r_count, l_rem, r_rem, sb);
            } else if (r_count < l_count) {
                dfs(s, ind + 1, l_count, r_count + 1, l_rem, r_rem, sb);
            }
            
            sb.deleteCharAt(len);    
        }
    }
}
</pre>

## 621. Task Scheduler
<pre>
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (char t: tasks) {
            hash[t - 'A'] ++;        
        }
        
        Arrays.sort(hash);
        
        int k = hash[25];
        
        int p = 0;
        int i = 25;
        
        while (i >= 0) {
            if (hash[i] == k) {
                p ++;
                i --;
            } else {
                break;
            }     
        }
        
        int rst = (k - 1) * (n + 1) + p;
        
        return Math.max(tasks.length, rst);    
        
    }
}
</pre>

## 535. Encode and Decode TinyURL
<pre>
public class Codec {
    String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    Map<String, String> map = new HashMap<>();
    
    private String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            sb.append(s.charAt(rand.nextInt(62)));        
        }
        
        return sb.toString(); 
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getRand();
        while (map.containsKey(key)) {
            key = getRand();
        }
        
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;     
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(19);
        return map.get(key);        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
</pre>

## 904. Fruit Into Baskets
<pre>
class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null) {
            return 0;
        }
        
        int rst = 0;
        int curtMax = 0;
        int last = -1;
        int secondLast = -1;
        int lastCount = 0;
        
        for (int curt: tree) {
            if (curt == last || curt == secondLast) {
                curtMax ++;
            } else {
                curtMax = lastCount + 1;            
            }
            
            if (curt == last) {
                lastCount ++;            
            } else {
                lastCount = 1;
                secondLast = last;
                last = curt;            
            }
            
            rst = Math.max(rst, curtMax);
        }
        
        return rst;     
    }
}
</pre>

## 406. Queue Reconstruction by Height
<pre>
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                }
                
                return a[1] - b[1];            
            }       
        };
        
        Arrays.sort(people, comp);
        
        List<int[]> list = new ArrayList<>();
        
        for (int[] p: people) {
            list.add(p[1], p);        
        }
        
        return list.toArray(new int[people.length][2]);
        
    }
}
</pre>

## 312. Burst Balloons
<pre>
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] arr = init(nums);
        int len = arr.length;
        
        int[][] dp = new int[len][len];
        
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 2; j < len; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);                
                }            
            }            
        }
        
        return dp[0][len - 1];        
        
    }
    
    private int[] init(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 2];
        arr[0] = 1;
        for (int i = 0; i < len; ++i) {
            arr[i + 1] = nums[i];
        }
        
        arr[len + 1] = 1;
        
        return arr;
    }
}
</pre>

## 388. Longest Absolute File Path
<pre>
class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        int[] sums = new int[input.length() + 1];
        int maxLen = 0;
        
        for (String s: input.split("\n")) {
            int level = s.lastIndexOf("\t") + 2;
            int len = s.length() - (level - 1);
            if (s.indexOf('.') != -1) {
                maxLen = Math.max(maxLen, sums[level - 1] + len);                
            } else {
                sums[level] = sums[level - 1] + len + 1;
            }    
        }
        
        return maxLen;
        
    }
}
</pre>

## 421. Maximum XOR of Two Numbers in an Array
<pre>
class TrieNode {
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[2];    
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        TrieNode root = new TrieNode();
        
        for (int num: nums) {
            TrieNode curt = root;
            for (int i = 31; i >= 0; -- i) {
                int bit = (num >>> i) & 1;
                if (curt.children[bit] == null) {
                    curt.children[bit] = new TrieNode();
                }
                
                curt = curt.children[bit];
            }
        }
        
        int rst = Integer.MIN_VALUE;
        
        for (int num: nums) {
            int curtMax = 0;
            TrieNode curt = root;
            for (int i = 31; i >= 0; -- i) {
                int bit = (num >>> i) & 1;
                if (curt.children[bit ^ 1] != null) {
                    curt = curt.children[bit ^ 1];
                    curtMax += (1 << i);             
                } else {
                    curt = curt.children[bit];                    
                }         
            }
            
            rst = Math.max(rst, curtMax);        
        
        }
        
        return rst;        
        
    }
}
</pre>

## 65. Valid Number
<pre>
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        s = s.trim() + " ";
        char[] sc = s.toCharArray();
        
        int len = sc.length - 1;
        int i = 0;
        if (sc[i] == '+' || sc[i] == '-') {
            i ++;
        }
        
        int nDigit = 0, nDot = 0;
        while (i < len) {
            if (sc[i] == '.') {
                nDot ++;
            } else if (sc[i] >= '0' && sc[i] <= '9') {
                nDigit ++;
            } else {
                break;
            }
            
            i ++;
        }
        
        if (nDigit == 0 || nDot > 1) {
            return false;
        }
        
        if (sc[i] == 'e') {
            i ++;
            if (sc[i] == '+' || sc[i] == '-') {
                i ++;
            }
            
            if (i == len) {
                return false;
            }
            
            while (i < len) {
                if (!Character.isDigit(sc[i])) {
                    return false;
                }
                
                i ++;                
            }    
        }
        
        return i == len;
        
    }
}
</pre>

## 68. Text Justification
<pre>
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        
        int len = words.length, i = 0;
        while (i < len) {
            int left = i;
            int count = words[i].length();
            i ++;
            while (i < len && count + 1 + words[i].length() <= maxWidth) {
                count += (1 + words[i].length());
                i ++;            
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[left]);
            
            if (i == len) {           
                for (int j = left + 1; j < i; ++j) {
                    sb.append(' ').append(words[j]);
                }
                
                if (sb.length() < maxWidth) {
                    int nSpace = maxWidth - count;
                    for (int k = 0; k < nSpace; ++k) {
                        sb.append(' ');
                    }
                }
                
                list.add(sb.toString());
                break;            
            }
            
            int dividend = maxWidth - count;
            int divisor = i - left - 1;
            
            if (divisor == 0) {
                for (int k = 0; k < dividend; ++k) {
                    sb.append(' ');
                }
                
                list.add(sb.toString());
                continue;
            }
            
            int n = dividend / divisor;
            int extra = dividend % divisor;
            
            for (int j = left + 1; j < i; ++j) {
                int curt = n + 1;
                if (j - left <= extra) {
                    curt ++;
                }
                
                for (int k = 0; k < curt; ++k) {
                    sb.append(' ');
                }
                
                sb.append(words[j]);        
            }
            
            list.add(sb.toString());
        }
        
        return list;        
        
    }
}
</pre>

## 528. Random Pick with Weight
<pre>
class Solution {
    int[] sums;
    int sum;
    Random rand;

    public Solution(int[] w) {
        int len = w.length;
        sums = new int[len];
        sums[0] = w[0];
        for (int i = 1; i < len; ++i) {
            sums[i] = sums[i - 1] + w[i];        
        }
        
        sum = sums[len - 1];
        rand = new Random();     
    }
    
    public int pickIndex() {
        int curt = rand.nextInt(sum) + 1;
        return search(sums, curt);     
    }
    
    private int search(int[] sums, int t) {
        int begin = 0, end = sums.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (sums[mid] >= t) {
                end = mid;
            } else {
                begin = mid;
            }     
        }
        
        if (sums[begin] >= t) {
            return begin;
        }
        
        return end;    
    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
</pre>

## 698. Partition to K Equal Sum Subsets
<pre>
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        if (k == 1) {
            return true;
        }
        
        int len = nums.length;
        int sum = 0;
        
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
        }
        
        if (sum < k || sum % k != 0) {
            return false;
        }
        
        int t = sum / k;
        
        Arrays.sort(nums);
        if (nums[len - 1] > t) {
            return false;
        }
        
        boolean[] visited = new boolean[len];
        
        for (int i = 0; i < k; ++i) {
            if (!dfs(nums, t, visited)) {
                return false;
            }        
        }
        
        return true;
        
    }
    
    private boolean dfs(int[] nums, int target, boolean[] visited) {
        if (target == 0) {
            return true;
        }
        
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] <= target && !visited[i]) {
                visited[i] = true;
                if (dfs(nums, target - nums[i], visited)) {
                    return true;
                }
                
                visited[i] = false;            
            }        
        }
        
        return false;    
    
    }
}
</pre>

## 605. Can Place Flowers
<pre>
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        
        for (int i = 0; i < len; ++i) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                count ++;
                flowerbed[i] = 1;
            }
            
            if (count >= n) {
                return true;
            }     
        }
        
        return false;        
    }
}
</pre>

## 730. Count Different Palindromic Subsequences
<pre>
class Solution {
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int len = S.length();
        
        int[][] dp = new int[len][len];
        
        for (int i = 0; i < len; ++i) {
            dp[i][i] = 1;
        }
        
        char[] sc = S.toCharArray();
        
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                if (sc[i] != sc[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];             
                } else {
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high && sc[low] != sc[i]) {
                        low ++;
                    }
                    
                    while (low <= high && sc[high] != sc[j]) {
                        high --;
                    }
                    
                    if (low > high) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;                    
                    } else if (low == high) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;                    
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];                    
                    }                
                }
                
                if (dp[i][j] < 0) {
                    dp[i][j] += 1000000007;
                } else {
                    dp[i][j] %= 1000000007;
                }            
            }     
        }
        
        return dp[0][len - 1];
        
    }
}
</pre>

## 633. Sum of Square Numbers
<pre>
class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i <= (int)Math.sqrt(c); ++i) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }     
        }
        
        return false;        
    }
}
</pre>
