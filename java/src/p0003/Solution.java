package p0003;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baimn on 2021/9/6.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return v1(s);

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

    // v2,O(n^2)
    // Runtime:75ms, Memory:39MB (Why!)
    // use window,(fast and slow pointers), i for left, j for right
    // map actural shows the char and the index of last occurring
    public int v2(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        for (int i = 0, j = 0; i < len; ) {
            if (map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(i)) + 1;// move i to the new beginning
            }
            map.put(s.charAt(j), j);
            max = max < j - i + 1 ? j - i + 1 : max;
        }
        return max;
    }

}