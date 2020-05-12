package SWEA.D3;

import java.io.*;

public class Solution3376 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        long[] answer = solve();
        int n;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            bw.write(answer[n-1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long[] solve(){ //Fibonacci
        long[] ans = new long[100];
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 1;
        for(int i = 3; i < 100; i++){
            ans[i] = ans[i-3] + ans[i-2];
        }
        return ans;
    }
}