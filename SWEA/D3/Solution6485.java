package SWEA.D3;

import java.io.*;

public class Solution6485 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n, p;
        int[] a, b, c;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            a = new int[n];
            b = new int[n];
            for(int i = 0; i < n; i++) {
                String[] parse = br.readLine().trim().split(" ");
                a[i] = Integer.parseInt(parse[0]);
                b[i] = Integer.parseInt(parse[1]);
            }
            p = Integer.parseInt(br.readLine().trim());
            c = new int[p];
            for(int i = 0; i < p; i++) {
                c[i] = Integer.parseInt(br.readLine().trim());
            }
            bw.write(solve(n, a, b, p, c)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(int n, int[] a, int[] b, int p, int[] c) {
        StringBuilder sb = new StringBuilder();
        int tmp;
        for(int i = 0; i < p; i++) {
            tmp = 0;
            for(int j = 0; j < n; j++) {
                if(c[i] >= a[j] && c[i] <= b[j]) tmp++;
            }
            sb.append(tmp + " ");
        }
        return sb.toString();
    }
}