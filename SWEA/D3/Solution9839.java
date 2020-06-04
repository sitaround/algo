package SWEA.D3;

import java.io.*;

public class Solution9839 {
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
        int tmp;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                tmp = num[i] * num[j];
                if(tmp < ans) continue;
                if(tmp < 10) {
                    ans = tmp;
                    continue;
                }
                if(isFloorNum(tmp)) ans = tmp;
            }
        }
        return ans;
    }

    static boolean isFloorNum(int n) {
        int tmp;
        while(n > 9) {
            tmp = n % 10;
            n /= 10;
            if(tmp - 1 == n%10) continue;
            else return false;
        }
        return true;
    }
}