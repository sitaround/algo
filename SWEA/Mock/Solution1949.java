package SWEA;
import java.io.*;

public class Solution1949 {
    static int answer;
    static int N, K;
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            K = Integer.parseInt(parse[1]);
            map = new int[N][N];
            int max = 0;
            for(int i = 0; i < N; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                    max = map[i][j] > max ? map[i][j] : max;
                }
            }
            boolean[][] visit = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(max == map[i][j]) {
                        visit[i][j] = true;
                        for(int k = 1; k <= K; k++){
                            dfs(i, j, map[i][j]-k, 1, visit, true);
                        }
                        dfs(i, j, map[i][j], 1, visit, false);
                        visit[i][j] = false;
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int x, int y, int cur, int cnt, boolean[][] visit, boolean isCut){
        int nx, ny;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(isValid(nx,ny) || visit[nx][ny]) {
                answer = cnt > answer ? cnt : answer;
                continue;
            }
            if(cur > map[nx][ny]){
                visit[nx][ny] = true;
                dfs(nx, ny, map[nx][ny], cnt+1, visit, isCut);
                visit[nx][ny] = false;
            }else{
                if(!isCut){
                    for(int j = 1; j <= K; j++){
                        if(map[nx][ny] - j >= cur) continue;
                        visit[nx][ny] = true;
                        dfs(nx, ny, map[nx][ny]-j, cnt+1, visit, true);
                        visit[nx][ny] = false;
                    }
                }else{
                    answer = cnt > answer ? cnt : answer;
                }
            }
        }
    }
    static boolean isValid(int x, int y){
        return (x < 0 || x > N-1 || y < 0 || y > N-1) ? true : false;
    }
}