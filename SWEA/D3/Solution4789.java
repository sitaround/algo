package SWEA.D3;

import java.io.*;

public class Solution4789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int[] n;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            char[] parse = br.readLine().trim().toCharArray();
            n = new int[parse.length];
            for(int i = 0; i < n.length; i++) {
                n[i] = parse[i] - '0';
            }
            answer = solve(n);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int[] n) {
        int ans = 0;
        int len = n.length;
        int tmp;
        int p = n[0];
        for(int i = 1; i < len; i++) {
            if(n[i] == 0) continue;
            if(i > p) {
                tmp = i-p;
                ans += tmp;
                p += tmp;
            }
            p += n[i];
        }
        return ans;
    }
}