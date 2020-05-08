package SWEA.Mock;

import java.io.*;

public class Solution4013 {
    static int answer;
    static int K;
    static int[][] map;
    static int[][] inst;
    static final int[] score = {1, 2, 4, 8};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            K = Integer.parseInt(br.readLine().trim());
            map = new int[5][8];
            for(int i = 0; i < 4; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < 8; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                }
            }
            inst = new int[K][2];
            for(int i = 0; i < K; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    inst[i][j] = Integer.parseInt(parse[j]);
                }
                inst[i][0]--;
            }
            solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int d;
        for(int i = 0; i < K; i++){
            int[] dir = new int[4];
            d = inst[i][1];
            dir[inst[i][0]] = d;
            for(int j = inst[i][0]+1; j < 4; j++){
                if(map[j-1][2] == map[j][6]){
                    dir[j] = 0;
                    break;
                }
                else{
                    dir[j] = d = -d;
                }
            }
            d = inst[i][1];
            for(int j = inst[i][0]-1; j > -1; j--){
                if(map[j+1][6] == map[j][2]){
                    dir[j] = 0;
                    break;
                }
                else{
                    dir[j] = d = -d;
                }
            }
            for(int j = 0; j < 4; j++){
                run(j, dir[j]);
            }
        }
        for(int i = 0; i < 4; i++){
            answer += map[i][0]*score[i];
        }
    }
    static void run(int a, int dir){
        int[] tmp = new int[8];
        for(int i = 0; i < 8; i++){
            tmp[i] = map[a][i];
        }
        if(dir == 1) {
            for(int i = 1; i < 8; i++){
                map[a][i] = tmp[i-1];
            }
            map[a][0] = tmp[7];
        }else if(dir == -1){
            for(int i = 0; i < 7; i++){
                map[a][i] = tmp[i+1];
            }
            map[a][7] = tmp[0];
        }else{
            return;
        }
    }
}