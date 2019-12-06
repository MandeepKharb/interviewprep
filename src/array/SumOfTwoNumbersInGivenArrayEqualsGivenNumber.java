package array;

public class SumOfTwoNumbersInGivenArrayEqualsGivenNumber {

    public static int[] twoSum(int[] numbers, int target) {
        int indexs[]=new int [2];


        int leftIndex=0;
        int rightIndex=numbers.length-1;

        while(leftIndex<rightIndex){

            if(numbers[leftIndex]+numbers[rightIndex]==target)
            {
                System.out.println(leftIndex);
                System.out.println(rightIndex);
                indexs[0]=leftIndex+1;
                indexs[1]=rightIndex+1;
                break;
            }
            else if(numbers[leftIndex]+numbers[rightIndex]<target){

                leftIndex++;
            }
            else
                rightIndex--;

        }

        return indexs;

    }

    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        twoSum(arr, 9);
    }
}
