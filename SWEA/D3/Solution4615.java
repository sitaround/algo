package SWEA.D3;

import java.io.*;

public class Solution4615 {
    static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};//상하좌우대각선
    static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n, m;
        int x, y, c, nx, ny, tmp;
        int[][] map;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            map = new int[n+1][n+1];
            tmp = n/2;
            map[tmp][tmp] = map[tmp+1][tmp+1] = 2;//백
            map[tmp+1][tmp] = map[tmp][tmp+1] = 1;//흑
            for(int i = 0; i < m; i++) {
                parse = br.readLine().trim().split(" ");
                x = Integer.parseInt(parse[0]);
                y = Integer.parseInt(parse[1]);
                c = Integer.parseInt(parse[2]);
                map[x][y] = c;
                for(int j = 0; j < 8; j++) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                    if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
                    if(map[nx][ny] == c) continue;
                    if(map[nx][ny] == 0) continue;
                    tmp = 1;
                    while(true) {
                        nx += dx[j];
                        ny += dy[j];
                        if(nx < 1 || ny < 1 || nx > n || ny > n) break;
                        if(map[nx][ny] == 0) break;
                        if(map[nx][ny] == c) {
                            for(int k = 1; k <= tmp; k++) {
                                map[x+k*dx[j]][y+k*dy[j]] = c;
                            }
                            break;
                        }
                        tmp++;
                    }
                }
            }
            bw.write(cnt(n, map)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String cnt(int n, int[][] map) {
        int w, b;
        w = 0;
        b = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(map[i][j] == 1) b++;
                else if(map[i][j] == 2) w++;
            }
        }
        return b + " " + w;
    }

}