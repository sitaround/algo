package SWEA.D3;

import java.io.*;

public class Solution3456 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int a, b, c;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            a = Integer.parseInt(parse[0]);
            b = Integer.parseInt(parse[1]);
            c = Integer.parseInt(parse[2]);
            answer = solve(a, b, c);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int a, int b, int c) {
        if(a != b && a == c) {
            return b;
        } else if(a == b && a != c) {
            return c;
        } else {
            return a;
        }
    }
}