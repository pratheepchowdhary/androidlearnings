package dsa.java.binary;

public class CountNumberOfBitsInInteger {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n&1);
            n>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(1999999999) +"("+DecimalToBinary.decimalBinary(1999999999)+")"); // 2 (101 in binary)
    }

}
