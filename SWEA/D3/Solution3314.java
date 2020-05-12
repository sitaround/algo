package SWEA.D3;

import java.io.*;

public class Solution3314 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int[] score;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            score = new int[5];
            for(int i = 0; i < 5; i++) {
                score[i] = Integer.parseInt(parse[i]);
            }
            answer = solve(score);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int[] num) {
        int ans = 0;
        for(int i = 0; i < 5; i++) {
            ans += num[i] < 40 ? 40 : num[i];
        }
        return ans/5;
    }
}