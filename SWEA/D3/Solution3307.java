package SWEA.D3;

import java.io.*;

public class Solution3307 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n;
        int[] num;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            num = new int[n];
            String[] parse = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                num[i] = Integer.parseInt(parse[i]);
            }
            answer = solve(n, num);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int[] num) {
        int ans = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(num[i] > num[j]){
                    dp[i] = dp[i] < dp[j] ? dp[j] : dp[i];
                }
            }
            dp[i]++;
            ans = dp[i] > ans ? dp[i] : ans;
        }
        return ans;
    }
}