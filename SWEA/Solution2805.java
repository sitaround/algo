package SWEA;

import java.io.*;

public class Solution2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int N;
        int[][] map;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            for(int i = 0; i < N; i++){
                char[] parse = br.readLine().trim().toCharArray();
                for(int j = 0; j < N; j++){
                    map[i][j] = parse[j] - '0';
                }
            }
            answer = solve(N, map);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int N, int[][] map){
        int ans = 0;
        final int chk = N/2;
        int cnt = -1;
        int start = chk+1;
        for(int i = 0; i < N; i++){
            if(i > chk) {
                cnt -= 2;
                start++;
            }
            else {
                cnt += 2;
                start--;
            }
            for(int j = start; j < start+cnt; j++){
                ans += map[i][j];
                
            }
        }
        return ans;
    }
}