import java.util.Scanner;

public class Main {

    public static void printDig(int n) {
        if (n == 0) return;
        printDig(n / 10);
        System.out.println(n % 10);
    }

    public static void main(String[] args) {
        printDig(5481);
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
    public static boolean Prime(int n, int divisors) {
        if (n <= 2) return (n == 2);
        if (n % divisors == 0) return false;
        if (divisors * divisors > n) return true;
        return Prime(n, divisors + 1);
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(Prime(num, 2) ? "Prime" : "Composite");
    }
}

public class Main{
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}

public class Main{
    public static int fibonaccin(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonaccin(n - 1) + fibonaccin(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonaccin(5));
    }
}

public class Main{
    public static long Power(int a, int n) {
        if (n == 0) return 1;
        return a * Power(a, n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Power: " + Power(2, 10));
    }
}

public class Main{
    public static void reverse(Scanner sc, int n) {
        if (n == 0) return;
        int x = sc.nextInt();
        reverse(sc, n - 1);
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n followed by numbers:");
        int n = sc.nextInt();
        reverse(sc, n);
        sc.close();
    }
}

public class Main{
    public static boolean alldigits(String s, int index) {
        if (index == s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return alldigits(s, index + 1);
    }

    public static void main(String[] args) {
        String s = "123456";
        System.out.println(alldigits(s, 0) ? "Yes" : "No");
    }
}

public class Main{
    public static int countChar(String s) {
        if (s.equals("")) return 0;
        return 1 + countChar(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("Length: " + countChar("hello"));
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
