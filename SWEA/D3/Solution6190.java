package SWEA.D3;

import java.io.*;

public class Solution6190 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n;
        int[] num;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            num = new int[n];
            String[] parse = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(parse[i]);
            }
            answer = solve(n, num);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int[] num) {
        int ans = -1;
        int mul;
        char[] tmp;
        boolean chk;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                mul = num[i] * num[j];
                if(mul < ans) continue;
                tmp = String.valueOf(mul).toCharArray();
                chk = true;
                for(int k = 1; k < tmp.length; k++) {
                    if(tmp[k-1] <= tmp[k]) continue;
                    chk = false;
                    break;
                }
                if(chk) ans = mul > ans ? mul : ans;
            }
        }
        return ans;
    }
}