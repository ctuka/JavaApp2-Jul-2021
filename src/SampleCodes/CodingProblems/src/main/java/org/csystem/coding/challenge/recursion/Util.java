package org.csystem.coding.challenge.recursion;

import org.csystem.util.console.Console;

public final class Util {
    private Util()
    {
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        long result = 1;

        for (; n > 1; --n)
            result *= n;

        return result;
    }

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return n - 1;

        int prev1 = 1, prev2 = 0, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev2 = prev1;
            prev1 = val;
        }

        return val;
    }

    public static int gcd(int a, int b)
    {
        int min = Math.min(Math.abs(a), Math.abs(b));

        for (int i = min; i >= 2; --i)
            if (a % i == 0 && b % i == 0)
                return i;

        return 1;
    }

    public static String reversed(String s)
    {
        char [] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return String.valueOf(chars);
    }

    public static void writeCollatz(int n)
    {
        for (;;) {
            Console.writeLine(n);

            if (n == 1)
                break;

            n = n % 2 == 0 ? n /= 2 : 3 * n + 1;
        }
    }

    public static void writeNumber(int val)
    {
        writeNumber(val, 10);
    }

    public static void writeNumber(int val, int radix)
    {
        if (val == 0) {
            System.out.write('0');
            return;
        }

        char [] s = new char[11];
        int i;
        boolean isNegative = false;

        if (val < 0) {
            isNegative = true;
            val = -val;
        }

        for (i = 0; val != 0; ++i) {
            s[i] = (char)((val % radix >= 10 ? 'A'- 10 : '0') + val % radix);
            val /= radix;
        }

        if (isNegative)
            s[i++] = '-';

        for (--i; i >= 0; --i)
            System.out.write(s[i]);

        System.out.flush();
    }

    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            Console.write(s.charAt(i));
    }
}
