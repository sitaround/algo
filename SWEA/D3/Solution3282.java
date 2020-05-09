package SWEA.D3;

import java.io.*;

public class Solution3282 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n, k; // n은 물건 개수, k는 가방의 부피
        Stuff[] stuff;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            k = Integer.parseInt(parse[1]);
            stuff = new Stuff[n];
            for(int i = 0; i < n; i++) {
                parse = br.readLine().trim().split(" ");
                stuff[i] = new Stuff(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));
            }
            answer = solve(n, k, stuff);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int k, Stuff[] s) {
        int[] dp = new int[k+1];
        for(int i = 0; i < n; i++) {
            for(int j = k; j >= s[i].volume; j--) {
                dp[j] = max(dp[j], dp[j-s[i].volume] + s[i].value);
            }
        }
        return dp[k];
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static class Stuff {
        int volume;
        int value;
        Stuff(int v, int c){
            this.volume = v;
            this.value = c;
        }
    }
}