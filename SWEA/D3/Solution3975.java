package SWEA.D3;

import java.io.*;

public class Solution3975 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        // int answer;
        double a, b, c, d;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            a = Integer.parseInt(parse[0]);
            b = Integer.parseInt(parse[1]);
            c = Integer.parseInt(parse[2]);
            d = Integer.parseInt(parse[3]);
            if(a/b > c/d) {
                bw.write("ALICE\n");
            } else if(a/b < c/d) {
                bw.write("BOB\n");
            } else {
                bw.write("DRAW\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}