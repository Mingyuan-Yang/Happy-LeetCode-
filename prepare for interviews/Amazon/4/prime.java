import java.util.*;
public class prime {
//    public static boolean[] sieve = new boolean[1000000];
//    public int countPrimeStringS(String s) {
//        int len = s.length();
//        int[] dp = new int[len + 1];
//        Arrays.fill(dp, -1);
//        dp[0] = 1;
//        return helper(s, len, dp);
//    }
//    private int helper(String s, int i, int[] dp) {
//        if (dp[i] != -1) return dp[i];
//        int count = 0;
//        for (int j = 1; j <= 6; j++) {
//            if (i - j >= 0 && s.charAt(i - j) != '0' && isPrime(s.substring(i - j, i))) {
//                count += helper(s, i - j, dp);
//            }
//        }
//        return dp[i] = count;
//    }
//    public boolean isPrime(String str) {
//        int num = Integer.valueOf(str);
//        return sieve[num];
//    }
//    public static void buildSieve() {
//        Arrays.fill(sieve, true);
//        sieve[0] = false;
//        sieve[1] = false;
//        for (int i = 2; i * i <= 1000000; i++) {
//            if (sieve[i] == true) {
//                for (int j = i * i; j < 1000000; j += i) {
//                    sieve[j] = false;
//                }
//            }
//        }
//    }
static int MOD = 1000000007;
    static boolean []sieve = new boolean[1000000];

    // Function to build sieve
    static void buildSieve()
    {
        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        for(int p = 2; p * p <= 1000000; p++)
        {

            // If p is a prime
            if (sieve[p] == true)
            {

                // Update all multiples
                // of p as non prime
                for(int i = p * p; i < 1000000;
                    i += p)
                    sieve[i] = false;
            }
        }
    }

    // Function to check whether a number
// is a prime number or not
    static boolean isPrime(String number)
    {
        int num = Integer.valueOf(number);
        return sieve[num];
    }

    // Function to find the count
// of ways to split String
// into prime numbers
    static int rec(String number, int i,
                   int []dp)
    {
        if (dp[i] != -1)
            return dp[i];
        int cnt = 0;

        for(int j = 1; j <= 6; j++)
        {

            // Number should not have a
            // leading zero and it
            // should be a prime number
            if (i - j >= 0 &&
                    number.charAt(i - j) != '0' &&
                    isPrime(number.substring(i - j, i)))
            {
                cnt += rec(number, i - j, dp);
                cnt %= MOD;
            }
        }
        return dp[i] = cnt;
    }

    // Function to count the
// number of prime Strings
    static int countPrimeStrings(String number)
    {
        int n = number.length();
        int []dp = new int[n + 1];

        Arrays.fill(dp, -1);
        dp[0] = 1;

        return rec(number, n, dp);
    }

    public static void main(String[] args) {
        prime test = new prime();
        String s = "11373";
        int res = test.countPrimeStrings(s);
        System.out.print(res);
    }
}

