package SWEA.D3;

import java.io.*;

public class Solution5215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n, limit;
        Material[] m;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            limit = Integer.parseInt(parse[1]);
            m = new Material[n];
            for(int i = 0; i < n; i++) {
                parse = br.readLine().trim().split(" ");
                m[i] = new Material(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));
            }
            answer = solve(n, limit, m);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int limit, Material[] m) {
        int[] dp = new int[limit+1];
        for(int i = 0; i < n; i++) {
            for(int j = limit; j >= m[i].calorie; j--) {
                dp[j] = max(dp[j], dp[j-m[i].calorie] + m[i].score);
            }
        }
        return dp[limit];
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static class Material {
        int score;
        int calorie;
        Material(int s, int c) {
            this.score = s;
            this.calorie = c;
        }
    }
}