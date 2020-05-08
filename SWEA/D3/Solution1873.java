package SWEA;

import java.io.*;

public class Solution1873 {
    static int h, w, n;
    static final char[] start = {'^', 'v', '<', '>'};
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final char[] go = {'U', 'D', 'L', 'R', 'S'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        char[][] map;
        char[] command;
        int nx = -1, ny = -1, dir = -1;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            h = Integer.parseInt(parse[0]);
            w = Integer.parseInt(parse[1]);
            map = new char[h][w];
            for(int i = 0; i < h; i++){
                map[i] = br.readLine().trim().toCharArray();
                for(int j = 0; j < w; j++){
                    for(int k = 0; k < 4; k++){
                        if(map[i][j] == start[k]){
                            nx = i;
                            ny = j;
                            dir = k;
                        }
                    }
                }
            }
            n = Integer.parseInt(br.readLine().trim());
            command = br.readLine().trim().toCharArray();
            solve(nx, ny, dir, map, command);
            for(int i = 0; i < h; i++){
                String str = "";
                for(int j = 0; j < w; j++){
                    str += map[i][j];
                }
                bw.write(str+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //0 : 위, 1: 아래, 2: 왼쪽, 3: 오른쪽
    static void solve(int nx, int ny, int dir, char[][] map, char[] command){
        int tmp_x = -1, tmp_y = -1;
        map[nx][ny] = '.';
        for(int i = 0; i < n; i++){
            if(command[i] == go[4]){
                shoot(nx, ny, dir, map);
                continue;
            }
            for(int j = 0; j < 4; j++){
                if(command[i] == go[j]){
                    dir = j;
                    tmp_x = nx + dx[dir];
                    tmp_y = ny + dy[dir];
                }
            }
            if(isGo(tmp_x, tmp_y, map)){
                nx = tmp_x;
                ny = tmp_y;
            }
        }
        map[nx][ny] = start[dir];
    }

    static boolean isGo(int x, int y, char[][] map){
        if(x < h && x > -1 && y < w && y > -1){
            if(map[x][y] == '.') return true;
            else return false;
        }else{
            return false;
        }
    }

    static void shoot(int x, int y, int dir, char[][] map){
        while(true){
            x += dx[dir];
            y += dy[dir];
            if(x < h && x > -1 && y < w && y > -1){
                if(map[x][y] == '*') {
                    map[x][y] = '.';
                    break;
                }
                if(map[x][y] == '#') break;
            }else{
                break;
            }
        }
    }
}