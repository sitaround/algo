package SWEA;
import java.io.*;
import java.util.*;
public class Solution2382 {
    static int N, M, K;
    static int[][] map;
    static int[][][] tmp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            M = Integer.parseInt(parse[1]);
            K = Integer.parseInt(parse[2]);
            map = new int[N][N];
            tmp = new int[N][N][3];
            for(int i = 0; i < K; i++){
                parse = br.readLine().trim().split(" ");
                int tmp = Integer.parseInt(parse[2]) * 10;
                tmp += Integer.parseInt(parse[3]);
                map[Integer.parseInt(parse[0])][Integer.parseInt(parse[1])] = tmp;
            }
            answer = solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static int solve(){
        int answer = 0;
        int cnt = 0;
        int cur_x, cur_y, cur_value;
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        Queue<Integer> value = new LinkedList<>();
        while(cnt != M){
            cnt++;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 0) continue;
                    x.add(i); y.add(j); value.add(map[i][j]);
                    map[i][j] = 0;
                }
            }
            while(!value.isEmpty()){
                cur_x = x.poll(); cur_y = y.poll();
                cur_value = value.poll();
                go(cur_x, cur_y, cur_value);
            }
            sum();
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0) continue;
                answer += (map[i][j]/10);
            }
        }
        return answer;
    }
    static void go(int x, int y, int value){
        int dir = value % 10;
        if(dir == 1){
            if(map[x-1][y] > 0){
                for(int i = 0; i < 3; i++){
                    if(tmp[x-1][y][i] == 0) {
                        tmp[x-1][y][i] = value;
                        break;
                    }
                }
            }else{ 
                convert(x-1, y, value);
            }
        }else if(dir == 2){
            if(map[x+1][y] > 0){
                for(int i = 0; i < 3; i++){
                    if(tmp[x+1][y][i] == 0) {
                        tmp[x+1][y][i] = value;
                        break;
                    }
                }
            }else{
                convert(x+1, y, value);
            }
        }else if(dir == 3){
            if(map[x][y-1] > 0){
                for(int i = 0; i < 3; i++){
                    if(tmp[x][y-1][i] == 0) {
                        tmp[x][y-1][i] = value;
                        break;
                    }
                }
            }else{
                convert(x, y-1, value);
            }
        }else{
            if(map[x][y+1] > 0){
                for(int i = 0; i < 3; i++){
                    if(tmp[x][y+1][i] == 0) {
                        tmp[x][y+1][i] = value;
                        break;
                    }
                }
            }else{
                convert(x, y+1, value);
            }
        }
    }
    static void sum(){
        int max;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(tmp[i][j][0] == 0) continue;
                else{
                    max = map[i][j];
                    map[i][j] /= 10;
                    for(int k = 0; k < 3; k++){
                        if(tmp[i][j][k] != 0){
                            max = tmp[i][j][k] > max ? tmp[i][j][k] : max;
                            map[i][j] += tmp[i][j][k]/10;
                            tmp[i][j][k] = 0;
                        }
                    }
                    map[i][j] *= 10;
                    map[i][j] += (max%10);
                }
            }
        }
    }
    static void convert(int x, int y, int value){
        if(x == 0 || x == N-1 || y == 0 || y == N-1){
            int dir = value % 10;
            int num = value / 10 / 2;
            if(num == 0){
                return;
            }
            if(dir == 1){
                map[x][y] = num * 10 + 2;
            }else if(dir == 2){
                map[x][y] = num * 10 + 1;
            }else if(dir == 3){
                map[x][y] = num * 10 + 4;
            }else{
                map[x][y] = num * 10 + 3;
            }
        }else{
            map[x][y] = value;
        }
    }
}