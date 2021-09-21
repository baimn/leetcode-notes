package p0003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by baimn on 2021/9/6.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return v2(s);

    }

    // v1 as ususal, directly solution, O(n^2)
    // Runtime:75ms, Memory:39MB
    // map only indicates showing
    public int v1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            map.clear();
            for (int j = i; j < len; ++j) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), 1);
                } else {
                    break;
                }
            }
            max = max < map.size() ? map.size() : max;
        }
        return max;
    }

    // v2,O(n)
    // Runtime:14ms, Memory:41MB
    // use window,(fast and slow pointers), i for left, j for right
    // map acturally shows the char and the index of last occurring
    public int v2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); ) {
            if (map.containsKey(s.charAt(j))) {
                int lastOccuring = map.get(s.charAt(j));
                if (lastOccuring >= i) {//if last occuring is between i and j
                    i = lastOccuring + 1;
                }
            }
            map.put(s.charAt(j), j);
            max = max < j - i + 1 ? j - i + 1 : max;
            j++;
        }
        return max;
    }

    //官方解答
    public int v3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}