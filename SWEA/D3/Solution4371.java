package SWEA.D3;

import java.io.*;

public class Solution4371 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n;
        int[] day;
        int answer;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            day = new int[n];
            for(int i = 0; i < n; i++) {
                day[i] = Integer.parseInt(br.readLine().trim());
            }
            answer = solve(n, day);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int[] day) {
        int ans = 0;
        int[] sub = new int[n-1];
        for(int i = 1; i < n; i++) {
            if(day[i] < 0) continue;
            sub[i-1] = day[i] - day[0];
            for(int j = i+1; j < n; j++) {
                if(day[j] % sub[i-1] == 1) day[j] = -1;
            }
        }
        for(int i = 0; i < n-1; i++) {
            if(sub[i] > 0) ans++;
        }
        return ans;
    }
}