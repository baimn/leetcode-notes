//package com.baimn.hello;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baimn on 2021/2/14.
 */
class No0001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return v2(nums, target);
    }

    //v1
    //Runtime:0ms, beats 100%
    //Memory:38.9MB, beats 92%
    //直接使用双重循环破解此题
    public int[] v1(int[] nums, int target){
        int[] res = new int[2];
        for(int i = 0; i < nums.length - 1; ++i){
            for(int j = i+1; j < nums.length; ++j){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //v2
    //Runtime:3ms, beats 25.4%
    //Memory:39.2MB,beats 62.2%
    //将数组转化为HashMap<value,index>,进而便于直接寻找第二个数字存在与否
    public int[] v2(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i]) && target%2 == 0 && nums[i] == target/2){
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; ++i){
            if(target%2 == 0 && nums[i] == target/2){
                continue;
            }
            int lookingFor = target - nums[i];
            if(map.containsKey(lookingFor)){
                res[0] = i;
                res[1] = map.get(lookingFor);
                return res;
            }
        }
        return res;
    }

}
