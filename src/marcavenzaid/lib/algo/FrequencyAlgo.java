package marcavenzaid.lib.algo;

public final class FrequencyAlgo {

    /**
     * Count how many times a digit {@code d} appears in {@code int n}.
     * @param n the integer.
     * @param d the digit.
     * @return the frequency of {@code d} in {@code n}.
     */
    public static int frequencyOfDigit(int n, int d) {
        int f = 0;
        while (n > 0) {
            if (n % 10 == d) {
                f++;
            }
            n /= 10;
        }
        return f;
    }
}
