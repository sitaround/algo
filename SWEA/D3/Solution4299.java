package SWEA.D3;

import java.io.*;

public class Solution4299 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int d, h, m;
        int answer;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            d = Integer.parseInt(parse[0]);
            h = Integer.parseInt(parse[1]);
            m = Integer.parseInt(parse[2]);
            answer = solve(d, h, m);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int d, int h, int m) {
        int minute = 11 * 24 * 60 + 11 * 60 + 11;
        int now = d * 24 * 60 + h * 60 + m;
        return minute > now ? -1 : now - minute;
    }
}