package SWEA;
import java.io.*;

public class Solution2112 {
    static int answer;
    static int D, W, K;
    static int[][] film;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            D = Integer.parseInt(parse[0]);
            W = Integer.parseInt(parse[1]);
            K = Integer.parseInt(parse[2]);
            film = new int[D][W];
            for(int i = 0; i < D; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < W; j++){
                    film[i][j] = Integer.parseInt(parse[j]);
                }
            }
            solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        if(check(film)) return;
        int cnt;
        int cases = 1 << D;
        for(int i = 1; i <= K; i++){
            for(int j = 3; j < cases; j++){
                cnt = 0;
                for(int d = 0; d < D; d++){
                    if((j >> d & 1) == 1) cnt++;
                }
                if(cnt == i){
                    if(run(copy(), j, 0) || run(copy(), j, 1)){
                        answer = i;
                        return;
                    }
                }
            }
        }
    }
    static boolean run(int[][] map, int work, int ab){
        for(int i = 0; i < D; i++){
            if((work >> i & 1) == 1){
                for(int j = 0; j < W; j++){
                    map[i][j] = ab;
                }
            }
        }
        return check(map);
    }
    static boolean check(int[][] map){
        int k;
        for(int i = 0; i < W; i++){
            k = 1;
            for(int j = 1; j < D; j++){
                if(map[j][i] == map[j-1][i]) k++;
                else{
                    if(k >= K) break;
                    else k = 1;
                }
                if(j == D-1 && k < K) return false;
            }
        }
        return true;
    }
    static int[][] copy(){
        int[][] map = new int[D][W];
        for(int i = 0; i < D; i++){
            for(int j = 0; j < W; j++){
                map[i][j] = film[i][j];
            }
        }
        return map;
    }
}