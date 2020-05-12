package SWEA.D3;

import java.io.*;

public class Solution3750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        String answer;
        char[] n;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = br.readLine().trim().toCharArray();
            answer = solve(n);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(char[] n) {
        int tmp = 0;
        while(n.length > 1) {
            for(int i = 0; i < n.length; i++) {
                tmp += n[i] - '0';
            }
            n = Integer.toString(tmp).toCharArray();
            tmp = 0;
        }
        return n[0]+"";
    }
}