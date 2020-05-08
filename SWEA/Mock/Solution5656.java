package SWEA;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution5656 {
    static int answer;
    static int N, W, H;
    static int[][] brick;
    static final int[] dx = {-1, 1, 0, 0}; //상하좌우
    static final int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = Integer.MAX_VALUE;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            W = Integer.parseInt(parse[1]);
            H = Integer.parseInt(parse[2]);
            brick = new int[H][W];
            for(int i = 0; i < H; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < W; j++){
                    brick[i][j] = Integer.parseInt(parse[j]);
                }
            }
            for(int i = 0; i < W; i++){
                for(int j = 0; j < H; j++){
                    if(brick[j][i] != 0) {
                        dfs(j, i, copy(brick), 0);
                        break;
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int x, int y, int[][] map, int cnt){
        Queue<point> q = new LinkedList<>();
        point p;
        int nx, ny;
        q.add(new point(x, y, map[x][y]));
        map[x][y] = 0;
        while(!q.isEmpty()){
            p = q.poll();
            if(p.no == 1){
                map[p.x][p.y] = 0;
                break;
            }
            for(int i = 0; i < 4; i++){
                nx = p.x; ny = p.y;
                for(int j = 1; j < p.no; j++){
                    nx += dx[i];
                    ny += dy[i];
                    if(isValid(nx, ny)) break;
                    if(map[nx][ny] > 1)
                    q.add(new point(nx, ny, map[nx][ny]));
                    map[nx][ny] = 0;
                }
            }
        }
        int min = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(map[i][j] != 0) min++;
            }
        }
        if(cnt == N-1 || min == 0){
            answer = min < answer ? min : answer;
            return;
        }
        map = rebuild(map);
        for(int i = 0; i < W; i++){
            for(int j = 0; j < H; j++){
                if(map[j][i] != 0) {
                    dfs(j, i, copy(map), cnt+1);
                    break;
                }
            }
        }
    }
    static boolean isValid(int x, int y){
        return (x < 0 || y < 0 || x > H-1 || y > W-1) ? true : false;
    }
    static int[][] rebuild(int[][] map){
        int[][] tmp = new int[H][W];
        int h;
        for(int i = 0; i < W; i++){
            h = H-1;
            for(int j = H-1; j > -1; j--){
                if(map[j][i] == 0) continue;
                tmp[h--][i] = map[j][i];
            }
        }
        return tmp;
    }
    static int[][] copy(int[][] map){
        int[][] tmp = new int[H][W];
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
    static class point{
        int x, y, no;
        point(int x, int y, int no){
            this.x = x;
            this.y = y;
            this.no = no;
        }
    }
}