package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfGivenArray {



        public static void main(String[] args) {
            System.out.println(new AllPermutationsOfGivenArray().permute(new int[] { 1, 2, 3 }));
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> bigList = new ArrayList<List<Integer>>();
            permute(nums, 0, bigList);
            return bigList;
        }

        private void permute(int[] nums, int index, List<List<Integer>> bigList) {
            if (index == nums.length) {
                List l = new ArrayList(nums.length);
                for (int num : nums)
                    l.add(num);
                bigList.add(l);
                return;
            }
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                permute(nums, index + 1, bigList);
                swap(nums, i, index);
            }
        }

        private void swap(int[] nums, int i, int index) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

}
