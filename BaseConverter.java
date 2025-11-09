import java.util.Scanner;

public class BaseConverter {
    
    static int toDecimal(String num, int base) {
        int value = 0;
        int power = 1; 
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int digit;

            if (c >= '0' && c <= '9')
                digit = c - '0';
            else
                digit = 10 + (c - 'A'); 

            value += digit * power;
            power *= base;
        }
        return value;
    }

    static String fromDecimal(int num, int base) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int rem = num % base;
            if (rem < 10)
                result.insert(0, (char)('0' + rem));
            else
                result.insert(0, (char)('A' + (rem - 10))); // For hex digits
            num /= base;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        String number = sc.next().toUpperCase();
        System.out.print("Enter the source base (2, 8, 10, 16): ");
        int fromBase = sc.nextInt();
        System.out.print("Enter the target base (2, 8, 10, 16): ");
        int toBase = sc.nextInt();
        
        int decimalValue = toDecimal(number, fromBase);
        String convertedValue = fromDecimal(decimalValue, toBase);
        
        System.out.println("Converted Value: " + convertedValue);
        
        sc.close();
    }
}
