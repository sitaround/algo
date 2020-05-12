package SWEA.D3;

import java.io.*;

public class Solution3408 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        String answer;
        long n;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            answer = solve(n);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(long n) {
        StringBuilder sb = new StringBuilder();
        long sum;
        sum = n * (n + 1) / 2;
        sb.append(sum + " ");
        sum = n * n;
        sb.append(sum + " ");
        sum += n;
        sb.append(sum);
        return sb.toString();
    }
}