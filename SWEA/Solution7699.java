package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution7699{
    static final int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
    static final int[] dy = {0, 0, -1, 1};
    static int R, C, answer;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            R = Integer.parseInt(parse[0]); C = Integer.parseInt(parse[1]);
            map = new int[R+2][C+2];
            for(int i = 1; i <= R; i++){
                String input = br.readLine();
                for(int j = 1; j <= C; j++){
                    map[i][j] = input.charAt(j-1) - 64;
                }
            }
            dfs(1 << map[1][1], 1, 1, 1);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int visit, int x, int y, int cnt){
        if(answer == R*C)   return;
        answer = (answer < cnt) ? cnt : answer;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int tmp = 1 << map[nx][ny];
            if(map[nx][ny] != 0 && (visit & tmp) == 0)
                dfs(visit|tmp, nx, ny, cnt+1);
        }
    }
}