package SWEA.Mock;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// bfs로 풀기 dfs x
public class Solution1953 {
    static int answer;
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visit;
    static final int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
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
            M = Integer.parseInt(parse[1]);
            R = Integer.parseInt(parse[2]);
            C = Integer.parseInt(parse[3]);
            L = Integer.parseInt(parse[4]);
            map = new int[N][M];
            visit = new boolean[N][M];
            for(int i = 0; i < N; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < M; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                }
            }
            solve();
            answer++;
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        point p, tmp;
        Queue<point> q = new LinkedList<>();
        q.add(new point(R, C, L));
        visit[R][C] = true;
        while(!q.isEmpty()){
            p = q.poll();
            switch(map[p.x][p.y]){
                case 1:
                    for(int i = 0; i < 4; i++){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
                break;
                case 2:
                    for(int i = 0; i < 2; i++){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
                break;
                case 3:
                    for(int i = 2; i < 4; i++){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
                break;
                case 4:
                    for(int i = 0; i < 4; i+=3){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
                break;
                case 5:
                    for(int i = 1; i < 4; i+=2){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
                break;
                case 6:
                    for(int i = 1; i < 3; i++){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
                break;
                default:
                    for(int i = 0; i < 4; i+=2){
                        tmp = next(p, i);
                        if(tmp == null) continue;
                        q.add(tmp);
                    }
            }
        }
    }
    static point next(point p, int dir){
        int nx = p.x + dx[dir];
        int ny = p.y + dy[dir];
        int time = p.time;
        if(time == 1 || !isValid(nx, ny) || !isConnect(dir, map[nx][ny])) return null;
        visit[nx][ny] = true;
        answer++;
        return new point(nx, ny, time-1);
    }
    static boolean isValid(int x, int y){
        return (x < 0 || y < 0 || x > N-1 || y > M-1 || map[x][y] == 0 || visit[x][y]) ? false : true;
    }
    static boolean isConnect(int dir, int type){
        if(type == 1) return true;
        switch(dir){
            case 0:
                if(type == 2 || type == 5 || type == 6) return true;
            break;
            case 1:
                if(type == 2 || type == 4 || type == 7) return true;
            break;
            case 2:
                if(type == 3 || type == 4 || type == 5) return true;
            break;
            default:
                if(type == 3 || type == 6 || type == 7) return true;
        }
        return false;
    }
    static class point{
        int x, y, time;
        point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}