package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Solution1227{
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // int T;
        int answer;

        for(int test_case = 1; test_case <= 10; test_case++){
            br.readLine();
            bw.write("#"+test_case+" ");
            map = new int[100][100];
            for(int i = 0; i < 100; i++){
                String input = br.readLine();
                for(int j = 0; j < 100; j++){
                    map[i][j] = input.charAt(j) - '0';
                }
            }
            answer = bfs();
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int bfs(){
        int cur_x, cur_y;
        int tmp_x, tmp_y;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean[][] visit = new boolean[100][100];
        qx.add(1); qy.add(1);
        visit[1][1] = true;
        while(!qx.isEmpty()){
            cur_x = qx.poll();  cur_y = qy.poll();
            for(int i = 0; i < 4; i++){
                tmp_x = cur_x+dx[i];    tmp_y = cur_y+dy[i];
                if(map[tmp_x][tmp_y] == 3) return 1;
                if(map[tmp_x][tmp_y] == 0 && !visit[tmp_x][tmp_y]){
                    qx.add(tmp_x);
                    qy.add(tmp_y);
                    visit[tmp_x][tmp_y] = true;
                }
            }
        }
        return 0;
    }
}