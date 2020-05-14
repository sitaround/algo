package SWEA.D3;

import java.io.*;

public class Solution4579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        char[] find;
        // int answer;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            find = br.readLine().trim().toCharArray();
            bw.write(solve(find)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(char[] f) {
        int len = f.length/2;
        int tmp = len*2;
        if(f.length % 2 == 0)   tmp--;
        for(int i = 0; i < len; i++) {
            if(f[i] == '*' || f[tmp-i] == '*') return "Exist";
            if(f[i] != f[tmp-i]) return "Not exist";
        }
        return "Exist";
    }
}