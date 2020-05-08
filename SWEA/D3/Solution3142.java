package SWEA.D3;


import java.io.*;

public class Solution3142 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n, m;
        int a, b;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            b = n - m;
            a = 2*m - n;
            bw.write(a + " " + b + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}