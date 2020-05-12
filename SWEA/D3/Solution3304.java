package SWEA.D3;

import java.io.*;

public class Solution3304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        char[] str1, str2;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            str1 = parse[0].toCharArray();
            str2 = parse[1].toCharArray();
            answer = solve(str1, str2);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(char[] str1, char[] str2) {
        int[][] lcs = new int[str1.length+1][str2.length+1];
        for(int i = 1; i <= str1.length; i++) {
            for(int j = 1; j <= str2.length; j++) {
                if(str1[i-1] == str2[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[str1.length][str2.length];
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}