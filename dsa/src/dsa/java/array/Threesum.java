package dsa.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Leetcode: https://leetcode.com/problems/3sum/
public class Threesum {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Threesum().threeSum(numbers));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //  {-4,-1,-1,0,1,2};
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip dupliactes
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }
        return result;

    }


}
