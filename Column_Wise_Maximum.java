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

        // First column initialization
        for (int i = 0; i < R; i++) {
            dp[i][0] = arr[i][0];
        }

        // DP column-wise
        for (int j = 1; j < C; j++) {
            for (int i = 0; i < R; i++) {
                long max = 0;

                // Find maximum from previous column
                // excluding the same row
                for (int k = 0; k < R; k++) {
                    if (k != i) {
                        max = Math.max(max, dp[k][j - 1]);
                    }
                }

                dp[i][j] = arr[i][j] + max;
            }
        }

        // Find answer in last column
        long ans = dp[0][C - 1];
        for (int i = 1; i < R; i++) {
            ans = Math.max(ans, dp[i][C - 1]);
        }

        System.out.println(ans);
    }
}
