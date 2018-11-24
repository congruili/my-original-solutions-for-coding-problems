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

