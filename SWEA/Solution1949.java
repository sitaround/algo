package SWEA;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1949 {
    static int N, K;
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[] startX;
    static int[] startY;
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
            K = Integer.parseInt(parse[1]);
            map = new int[N][N];
            for(int i = 0; i < N; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                }
            }
            findTall();
            answer = solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void findTall(){
        int tall = 0;
        int idx = 0;
        startX = new int[5];
        startY = new int[5];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tall = map[i][j] > tall ? map[i][j] : tall;
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != tall) continue;
                startX[idx] = i;
                startY[idx++] = j;
            }
        }
        for(int i = idx; i < 5; i++){
            startX[i] = -1; startY[i] = -1;
        }
    }
    static int solve(){
        int answer = 0;
        int tmp;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 1; k <= K; k++){
                    map[i][j]--;
                    tmp = bfs();
                    answer = tmp > answer ? tmp : answer;
                }
                map[i][j] += K;
            }
        }
        tmp = bfs();
        answer = tmp > answer ? tmp : answer;
        return answer;
    }
    static int bfs(){
        int max = 0;
        int cur_x, cur_y, cur_len, tmp_x, tmp_y;
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        Queue<Integer> len = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            if(startX[i] == -1) break;
            x.add(startX[i]); y.add(startY[i]); len.add(1);
        }
        while(!len.isEmpty()){
            cur_x = x.poll(); cur_y = y.poll(); cur_len = len.poll();
            for(int i = 0; i < 4; i++){
                tmp_x = cur_x + dx[i];
                tmp_y = cur_y + dy[i];
                if(isValid(tmp_x, tmp_y)){
                    if(map[cur_x][cur_y] > map[tmp_x][tmp_y]){
                        x.add(tmp_x); y.add(tmp_y); len.add(cur_len+1);
                    }else{
                        max = cur_len > max ? cur_len : max;
                    }
                }else{
                    max = cur_len > max ? cur_len : max;
                }
            }
        }
        return max;
    }
    static boolean isValid(int x, int y){
        if(x < 0 || x > N-1 || y < 0 || y > N-1)    return false;
        return true;
    }
}