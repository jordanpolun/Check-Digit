public class CheckDigit
{
    public static boolean isValid(int numWithCheckDigit)
    {
        // Split numWithCheckDigit into num and checkDigit
        int num = numWithCheckDigit / 10; // Get left part of number
        int extractedCheckDigit = numWithCheckDigit % 10; // Get right-most part of number

        // Run getCheck(num)
        int ourCheckDigit = getCheck(num);

        // Compare answer^^ above with checkDigit
        return ourCheckDigit == extractedCheckDigit;
    }

    public static int getCheck(int num)
    {
        // Adds all products using sum
        int sum = 0;
        int multiplier = 7;

        for (int i = getNumberOfDigits(num); i > 0; i--)
        {
            // Get this digit
            int digit = getDigit(num, i - 1);

            // Multiply digit by multiplier
            digit = digit * multiplier;

            // Add the multiplied digit to the sum
            sum = sum + digit;

            // Decrement the multiplier
            multiplier = multiplier - 1;
        }

        // Returns right-most digit
        return sum % 10;
    }

    public static int getNumberOfDigits(int num)
    {
        // There are more mathy ways to do this, but this works
        // Convert this integer to a String
        String numString = num + "";

        // Get length of String
        int numDigits = numString.length();

        // Return that length
        return numDigits;
    }

    public static int getDigit(int num, int n)
    {
        // Get left part of num
        int digit = (num / (int)Math.pow(10, n));

        // Get right-most digit
        digit = digit % 10;

        return digit;
    }
}