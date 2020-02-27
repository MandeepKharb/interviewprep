package dynamicprog;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* You are given a cost array of length 9 that says the cost of picking the i(1 to 9) and some price money. You have to construct the largest number possible with that given price
* */

public class LargestNumberPossibleFromGivenArray {

/*
* Simply sorting the array in descending order will give the answer as sorting in descending order will give - 75682112107
* which is less than 77568211210
* idea here is to write our own custom comparator function for sorting
* For two numbers this function will compare xy with yx and the greater number will come first in sorted order
* xy denotes number formed by appending y to x and yx denotes the number formed by appending x to y
*
* for example - x=15, y= 4
*  then xy =154
*  yx=415
*  as clear yx>xy
*  this way it will give us largest number
*
* */


        public static void main(String[] args)
        {
            List<String> numbers = Arrays.asList("10", "68", "97", "9", "21", "12");

            // sort using a custom function object
            Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

            // print the sorted sequence
            numbers.stream().forEach(System.out::print);
        }

}
