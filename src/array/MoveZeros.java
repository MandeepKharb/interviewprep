package array;

/*
* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
* */
public class MoveZeros {

    public static int [] moveZeroes(int[] nums) {
        int lastNonZeroFoundAt=0;

        for(int i =0; i<nums.length; i++){

            if(nums[i]!=0){
                //lastNonZeroFoundAt++;
                nums[lastNonZeroFoundAt++]=nums[i];
                //lastNonZeroFoundAt++;
            }

        }

        for(int j=lastNonZeroFoundAt; j<nums.length;j++){
            nums[j]=0;
        }

        return nums;
    }

    public static void main(String[] args) {
        int nums[]=moveZeroes(new int[]{0,1,0,3,12});
        for (int arg : nums) {
            System.out.println(arg);
        }

    }
}
