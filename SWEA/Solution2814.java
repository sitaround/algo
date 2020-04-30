package SWEA;

import java.io.*;

public class Solution2814 {
    static int n, m;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        boolean[][] map;
        int x, y;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            map = new boolean[n][n];
            for(int i = 0; i < m; i++){
                parse = br.readLine().trim().split(" ");
                x = Integer.parseInt(parse[0]) - 1;
                y = Integer.parseInt(parse[1]) - 1;
                map[x][y] = true;
                map[y][x] = true;
            }
            for(int i = 0; i < n; i++){
                solve(map, 1<<i, i, 1);
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void solve(boolean[][] map, int visit, int start, int cnt){
        for(int i = 0; i < n; i++){
            if(map[start][i] && ((visit>>i)&1) == 0){
                solve(map, visit|1<<i, i, cnt+1);
            }
        }
        answer = cnt > answer ? cnt : answer;
    }
}