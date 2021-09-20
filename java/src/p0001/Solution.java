package p0001;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baimn on 2021/2/14.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return v3(nums, target);
    }

    //v1
    //Runtime:55ms, beats 29%
    //Memory:38.9MB, beats 92%
    //First trial, use double loop to solve the problem directly.
    public int[] v1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //v2
    //Runtime:2ms, beats 87.9%
    //Memory:38.3MB,beats 91.23%
    // there are two ways of solution, one is a+a=2a, and a+b=c
    // v2 simply iterate through the array twice
    public int[] v2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && target % 2 == 0 && nums[i] == target / 2) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (target % 2 == 0 && nums[i] == target / 2) {
                continue;
            }
            int lookingFor = target - nums[i];
            if (map.containsKey(lookingFor)) {
                res[0] = i;
                res[1] = map.get(lookingFor);
                return res;
            }
        }
        return res;
    }

    //v2
    //Runtime:3ms, beats 25.4%
    //Memory:39.2MB,beats 62.2%
    //optimise v2, conbined two loops, and time consuming reduces by half
    public int[] v3(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length - 1);
        for (int i = 0; i < nums.length; ++i) {
            int lookingFor = target - nums[i];
            if (map.containsKey(lookingFor)) {
                res[0] = map.get(lookingFor);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

}