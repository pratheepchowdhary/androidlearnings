package dsa.java.binary;

public class DecimalToBinary {
    public static void main(String[] args) {
       System.out.println(decimalBinary(7));
    }
    public static String decimalBinary(int number){
        StringBuilder binary = new StringBuilder();
        while (number != 0){
            int rem = number % 2;
            System.out.println(number+"%"+2+" result: "+rem);
            number/=2;
            binary.append(rem);
        }
        return binary.reverse().toString();
    }
}
