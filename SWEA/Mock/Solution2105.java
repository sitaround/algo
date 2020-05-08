package SWEA;
import java.io.*;

public class Solution2105 {
    static int[][] map;
    static int N;
    static int answer;
    static boolean[] visit;
    static final int[] dx = {-1, 1, 1, -1};//오른위, 오른아래, 왼아래, 왼위
    static final int[] dy = {1, 1, -1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                }
            }
            visit = new boolean[101];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    dfs(i,j,i,j,0,0,0);
                }
            }
            answer = answer == 0 ? -1 : answer;
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int sx, int sy, int x, int y, int dir, int k, int len){
        if(dir == 3 && len != 0 && sx == x && sy == y){
            answer = len > answer ? len : answer;
        }
        if(dir > 3) return;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(nx, ny) && !visit[map[nx][ny]]){
                visit[map[nx][ny]] = true;
                if(i == k){
                    dfs(sx, sy, nx, ny, dir, k, len+1);
                }else{
                    dfs(sx, sy, nx, ny, dir+1, i, len+1);
                }
                visit[map[nx][ny]] = false;
            }
        }
    }
    static boolean isValid(int x, int y){
        return (x < 0 || x > N-1 || y < 0 || y > N-1) ? false : true;
    }
}