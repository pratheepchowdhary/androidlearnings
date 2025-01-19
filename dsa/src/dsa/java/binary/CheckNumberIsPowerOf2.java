package dsa.java.binary;

public class CheckNumberIsPowerOf2 {
    public static void main(String[] args) {


        System.out.println(isPowerOfTwo(8)); // true
        System.out.println(isPowerOfTwo(16)); // false
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // binary conv of 7
        //7%2 = 1
        // 7/2 = 3.5 eql to 3
        //3%2 = 1
        //3/2 = 1
        //1%2 = 1.5 equal to 1
        //example 8 & 7
        // 1000 & 111
        //1000
        // 0111
        // 0000
        return (n & (n - 1)) == 0;
    }


}
