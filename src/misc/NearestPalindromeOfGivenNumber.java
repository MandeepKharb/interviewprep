package misc;

/*
* The simplest solution is to consider every possible number smaller than the given number nn, starting by decrementing 1 from the given number and go on in descending order.
 * Similarly, we can consider every possible number greater than nn starting by incrementing 1 from the given number and going in ascending order. We can continue doing so in an alternate manner
  * till we find a number which is a palindrome.
* */

public class NearestPalindromeOfGivenNumber {
    public static String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        for (long i = 1;; i++) {
            if (isPalindrome(num - i))
                return "" + (num - i);
            if (isPalindrome(num + i))
                return "" + (num + i);
        }
    }
    static boolean  isPalindrome(long givenNumber) {
        long t = givenNumber, revised = 0;

        while (t > 0) {
            revised = 10 * revised + t % 10;
            t /= 10;
        }
        return revised == givenNumber;
    }

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("121"));
    }
}
