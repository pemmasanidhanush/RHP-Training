import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] arr = new int[R][C];
        long[][] dp = new long[R][C];

        // Input matrix
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // First row initialization
        for (int j = 0; j < C; j++) {
            dp[0][j] = arr[0][j];
        }

        // DP row-wise
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                long max = 0;

                // Find maximum from previous row
                // excluding the same column
                for (int k = 0; k < C; k++) {
                    if (k != j) {
                        max = Math.max(max, dp[i - 1][k]);
                    }
                }

                dp[i][j] = arr[i][j] + max;
            }
        }

        // Find answer in last row
        long ans = dp[R - 1][0];
        for (int j = 1; j < C; j++) {
            ans = Math.max(ans, dp[R - 1][j]);
        }

        System.out.println(ans);
    }
}
