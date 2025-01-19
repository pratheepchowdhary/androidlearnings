package dsa.java.binary;

public class ReverseBitsOfInteger {
    public static int reverseBits(int n) {
        System.out.println(DecimalToBinary.decimalBinary(n));
        int result = 0;
        for (int i = 0; i < 32; i++) { // Integer is 32-bit
            result <<= 1; // Shift left
            result |= (n & 1); // Add the last bit
            n >>= 1; // Shift right
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(5)); // -536870912 (101 becomes 101...000)
    }

}
