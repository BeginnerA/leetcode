package com.reid.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。
 * 示例 ：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </p>
 *
 * @Author REID
 * @Blog https://blog.csdn.net/qq_39035773
 * @GitHub https://github.com/BeginnerA
 * @Data 2021/2/25
 * @Version V1.0
 **/
public class TwoSum {

    int[] nums = new int[]{2,7,11,15,2};
    int target = 9;

    /**
     * 简单粗暴些，两重循环，遍历所有情况看相加是否等于目标和，如果符合直接输出。
     * 时间复杂度：两层 for 循环，O（n²）
     * 空间复杂度：O（1）
     */
    @Test
    public void test1() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i+1); j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    System.out.println("下标("+i+":"+j+"):"+nums[i]+"+"+nums[j]+"="+(nums[i]+nums[j]));
                }
            }
        }
    }

    /**
     * 在test1中就行优化
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    @Test
    public void test2() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i+1); j < nums.length; j++) {
                if (nums[j] == target-nums[i]) {
                    System.out.println("下标("+i+":"+j+"):"+nums[i]+"+"+nums[j]+"="+(nums[i]+nums[j]));
                }
            }
        }
    }

    /**
     * 把数组的每个元素保存为 hash 的 key，下标保存为 hash 的 value，判断 sub 在不在 hash 的 key 里就可以了。
     * 时间复杂度：比解法一少了一个 for 循环，降为 O（n）
     * 空间复杂度：O（n）
     */
    @Test
    public void test3() {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i <nums.length; i++){
            int sub = target-nums[i];
            if(map.containsKey(sub)){
                System.out.println("下标("+i+":"+map.get(sub)+"):"+nums[i]+"+"+sub+"="+(nums[i]+sub));
            }
            map.put(nums[i], i);
        }
    }

}
