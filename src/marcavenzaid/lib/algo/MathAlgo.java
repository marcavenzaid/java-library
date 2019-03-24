package marcavenzaid.lib.algo;

import java.util.ArrayList;

public final class MathAlgo {

    /**
     * Returns the sum of all integers between l[inclusive] and r[inclusive].
     *
     * <p>Time complexity: O(1)</p>
     * @param l
     * @param r
     * @return
     */
    public static long sumConsecutive(long l, long r) {
        return r*(r+1)/2 - l*(l-1)/2;
    }

    /**
     * Given an array a of size n, find the sum of all sub-arrays.
     *
     * <p>Time complexity: O(n)</p>
     * @param a
     * @return
     */
    public static int subarraysSum(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * (i+1) * (n-i);
        }
        return sum;
    }

    public static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> u = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    u.add(i);
                } else {
                    u.add(i);
                    v.add(n / i);
                }
            }
        }
        u.addAll(v);
        return u;
    }

    /**
     * Return the LCM (Least Common Multiple) of 2 or more numbers.
     * @param args
     * @return
     */
    public static int lcm(int... args) {
        if (args.length < 1) { return -1; }
        if (args.length < 2) { return args[0]; }
        if (args.length == 2) {
            return lcmUtil(args[0], args[1]);
        }
        int result = args[0];
        for (int i = 1; i < args.length; i++) {
            result = (result * args[i]) / gcd(result, args[i]);
        }
        return result;
    }

    /**
     * Return the LCM (Least Common Multiple) of 2 numbers.
     * @param a
     * @param b
     * @return
     */
    public static int lcmUtil(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Computes the GCD (Greatest Common Factor) of the varargs.
     *
     * <p>Time complexity: If {@code args.length == 2} O(log min(args[0], args[1])).</p>
     * @param args
     * @return
     */
    public static int gcd(int... args) {
        if (args.length < 1) { return -1; }
        if (args.length < 2) { return args[0]; }
        if (args.length == 2) {
            return gcdUtil(args[0], args[1]);
        }
        int result = args[0];
        for (int i = 1; i < args.length; i++) {
            result = gcd(result, args[i]);
        }
        return result;
    }

    /**
     * Computes the GCD (Greatest Common Factor) of two integers.
     *
     * <p>Time complexity: O(log min(a, b)).</p>
     * @param a
     * @param b
     * @return
     */
    private static int gcdUtil(int a, int b) {
        if (a == 0) { return b; }
        return gcd(b % a, a);
    }

    /**
     * Returns {@code true} if the integer argument is true.
     * @param x
     * @return a {@code boolean} value.
     */
    public static boolean isPrime(int x) {
        if (x <= 1) { return false; }
        if (x <= 3) { return true; }
        if (x % 2 == 0 || x % 3 == 0) { return false; }
        for (int i = 5; i * i <= x; i = i + 6) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an {@code ArrayList<Integer>} of all prime factors of argument {@code n}.
     * @param x
     * @return an {@code ArrayList<Integer>} of prime factors.
     */
    public static ArrayList<Integer> primeFactorization(int x) {
        ArrayList<Integer> al = new ArrayList<>();
        while (x % 2 == 0) {
            al.add(2);
            x /= 2;
        }
        for (int i = 3; i <= java.lang.Math.sqrt(x); i += 2) {
            while (x % i == 0) {
                al.add(i);
                x = x / i;
            }
        }
        if (x > 2) {
            al.add(x);
        }
        return al;
    }

    /**
     * Computes (b^e) % mod.
     *
     * <p>Time complexity: O(log y)</p>
     * <p>Space complexity: O(1)</p>
     * @param b the base number.
     * @param e the exponent.
     * @param mod the modulus.
     * @return
     */
    public static int modularExponentiation(int b, int e, int mod) {
        int res = 1;
        b %= mod;
        while (e > 0) {
            if ((e & 1) == 1) {
                res = (res * b) % mod;
            }
            e >>= 1;
            b = (b * b) % mod;
        }
        return res;
    }

    /**
     * Returns the answer to nCr or the number of ways of choosing
     * r unordered outcomes from n possibilities. More formally,
     * the number of r-element subsets (or r-combinations) of an
     * n-element set. Also known as a combination or combinatorial number.
     * <p>Time complexity: O(n*k)</p>
     * <p>Space complexity: O(k)</p>
     * @param n
     * @param r
     * @param p
     * @return
     */
    public static int binomialCoefficient(int n, int r, int p) {
        int[] c = new int[r + 1];
        c[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                c[j] = (c[j] + c[j-1])%p;
            }
        }
        return c[r];
    }
}
