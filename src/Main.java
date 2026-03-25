import java.util.Scanner;

public class Main {

    public static void printDigits(int n) {
        if (n == 0) return;
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    public static void main(String[] args) {
        printDigits(5481);
    }
}

public class Main {

    public static int sum(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sum(arr, index + 1);
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        int total = sum(arr, 0);
        double avg = (double) total / arr.length;
        System.out.println(avg);
    }
}

public class Main {
    public static boolean isPrime(int n, int divisor) {
        if (n <= 2) return (n == 2);
        if (n % divisor == 0) return false;
        if (divisor * divisor > n) return true;
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(isPrime(num, 2) ? "Prime" : "Composite");
    }
}

public class Main{
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial: " + factorial(5));
    }
}

public class Main{
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci: " + fibonacci(5));
    }
}

public class Main{
    public static long power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Power: " + power(2, 10));
    }
}

public class Main{
    public static void reversePrint(Scanner sc, int n) {
        if (n == 0) return;
        int x = sc.nextInt();
        reversePrint(sc, n - 1);
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n followed by numbers:");
        int n = sc.nextInt();
        reversePrint(sc, n);
        sc.close();
    }
}

public class Main{
    public static boolean isAllDigits(String s, int index) {
        if (index == s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return isAllDigits(s, index + 1);
    }

    public static void main(String[] args) {
        String s = "123456";
        System.out.println(isAllDigits(s, 0) ? "Yes" : "No");
    }
}

public class Main{
    public static int countChars(String s) {
        if (s.equals("")) return 0;
        return 1 + countChars(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("Length: " + countChars("hello"));
    }
}

public class Main{
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("GCD: " + gcd(32, 48));
    }
}
