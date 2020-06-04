package SWEA.D3;

import java.io.*;

public class Solution9480 {
    static int answer;
    static final int chk = (1 << 26) - 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n;
        int[] word;

        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            answer = 0;
            n = Integer.parseInt(br.readLine().trim());
            word = new int[n];
            for(int i = 0; i < n; i++) {
                char[] input = br.readLine().trim().toCharArray();
                for(int j = 0; j < input.length; j++) {
                    word[i] |= 1 << input[j]-'a';
                }
            }
            dfs(n, word, 0, 0);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int n, int[] word, int idx, int flag) {
        if(flag == chk) answer++;
        for(int i = idx; i < n; i++) {
            dfs(n, word, i+1, flag|word[i]);
        }
    }
}