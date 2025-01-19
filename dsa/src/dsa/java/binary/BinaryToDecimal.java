package dsa.java.binary;

public class BinaryToDecimal {
    public static void main(String[] args) {
     String binary = "0111";
     System.out.println(binary + " in binary = " + binaryToDecimal(binary)+ " in decimal.");
    }

    public static double binaryToDecimal(String decimal){
        char[] binary =  decimal.toCharArray();
        double number  = 0;
        int j =0;
        for(int i = binary.length - 1 ; i>=0 ; i--){
            int val = Character.getNumericValue(binary[i]);
            if(val !=0){
            number= number+ (val*Math.pow(2,j));
            }
            j++;
        }
        return  number;
    }

}
