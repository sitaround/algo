package SWEA;
import java.io.*;

public class Solution5650 {
    static int answer;
    static int N;
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static wormhole[] hole;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            hole = new wormhole[5];
            for(int i = 0; i < 5; i++){
                hole[i] = new wormhole();
            }
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                    if(map[i][j] > 5){
                        if(hole[map[i][j]-6].x == -1){
                            hole[map[i][j]-6].x = i;
                            hole[map[i][j]-6].y = j;
                        }
                        else{
                            hole[map[i][j]-6].x1 = i;
                            hole[map[i][j]-6].y1 = j;
                        }
                    }
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 0){
                        for(int k = 0; k < 4; k++){
                            solve(i, j, k);
                        }
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(int x, int y, int dir){
        int cnt = 0;
        int nx = x, ny = y;
        while(true){
            nx += dx[dir];
            ny += dy[dir];
            int tmp = turn(nx, ny, dir);
            if(tmp == -1) break;
            if(x == nx && y == ny) break;
            if(tmp != dir){
                cnt++;
                dir = tmp;
            }
            if(nx > -1 && ny > -1 && nx < N && ny < N){
                if(map[nx][ny] > 5) {
                    wormhole teleport = teleport(nx, ny);
                    // if(dir == 0 && nx == 0) dir ^= 1;
                    // else if(dir == 1 && nx == N-1) dir ^= 1;
                    // else if(dir == 2 && ny == 0) dir ^= 1;
                    // else if(dir == 3 && ny == N-1) dir ^= 1;
                    nx = teleport.x;
                    ny = teleport.y;
                }
            }
        }
        answer = cnt > answer ? cnt : answer;
    }
    static int turn(int x, int y, int dir){
        if(x < 0 || y < 0 || x > N-1 || y > N-1) return dir^1;
        if(map[x][y] == 0 || map[x][y] > 5) return dir;
        else if(map[x][y] == -1) return -1;
        else if(map[x][y] == 1 && ((dir>>1)^(dir&1)) == 1) return dir^2;
        else if(map[x][y] == 2 && (dir & 1) == 0) return dir^3;
        else if(map[x][y] == 3 && ((dir>>1)^(dir&1)) == 0) return dir^2;
        else if(map[x][y] == 4 && (dir & 1) == 1) return dir^3;
        return dir^1;
    }
    static wormhole teleport(int x, int y){
        if(hole[map[x][y]-6].x == x && hole[map[x][y]-6].y == y){
            return new wormhole(hole[map[x][y]-6].x1, hole[map[x][y]-6].y1);
        }else{
            return new wormhole(hole[map[x][y]-6].x, hole[map[x][y]-6].y);
        }
    }
    static class wormhole{
        int x, y, x1, y1;
        wormhole(){
            this.x = -1;
            this.y = -1;
            this.x1 = -1;
            this.y1 = -1;
        }
        wormhole(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}