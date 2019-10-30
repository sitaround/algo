package SWEA;
import java.io.*;

public class Solution5644 {
    static int answer;
    static int N;
    static atom[] atoms;
    static boolean[] complete;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int[][] map = new int[4001][4001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int x, y;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            N = Integer.parseInt(br.readLine().trim());
            atoms = new atom[N];
            complete = new boolean[N];
            for(int i = 0; i < N; i++){
                String[] parse = br.readLine().trim().split(" ");
                x = Integer.parseInt(parse[0])*2 + 2000;
                y = Integer.parseInt(parse[1])*2 + 2000;
                atoms[i] = new atom(x, y, Integer.parseInt(parse[2]), Integer.parseInt(parse[3]));
                map[x][y]++;
            }
            solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int cnt = 0;
        while(cnt != N){
            for(int i = 0; i < N; i++){
                if(complete[i]) continue;
                map[atoms[i].x][atoms[i].y]--;
                atoms[i].x += dx[atoms[i].dir];
                atoms[i].y += dy[atoms[i].dir];
                if(isValid(atoms[i].x, atoms[i].y)){
                    complete[i] = true;
                    cnt++;
                    continue;
                }
                map[atoms[i].x][atoms[i].y]++;
            }
            for(int i = 0; i < N; i++){
                if(complete[i]) continue;
                if(map[atoms[i].x][atoms[i].y] > 1){
                    for(int j = 0; j < N; j++){
                        if(complete[j]) continue;
                        if(atoms[i].x == atoms[j].x && atoms[i].y == atoms[j].y){
                            complete[j] = true;
                            cnt++;
                            answer += atoms[j].energy;
                        }
                    }
                    map[atoms[i].x][atoms[i].y] = 0;
                }
            }
        }
    }
    static boolean isValid(int x, int y){
        return (x < 0 || y < 0 || x > 4000 || y > 4000) ? true : false;
    }
    static class atom{
        int x, y, dir, energy;
        atom(int x, int y, int dir, int energy){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }
}