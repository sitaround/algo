package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
//좀 더 최적화를 해서 올릴 계획
class Solution7733{
    static final int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
    static final int[] dy = {0, 0, -1, 1};
    static int[][] cheese;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int tmp;
        int max;
        int answer;

        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0; max = 0;
            N = Integer.parseInt(br.readLine());
            cheese = new int[N+2][N+2];
            for(int i = 1; i <= N; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 1; j <= N; j++){
                    tmp = Integer.parseInt(parse[j-1]);
                    cheese[i][j] = tmp;
                    if(tmp > max)
                        max = tmp;
                }
            }
            for(int days = 1; days < max; days++){
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= N; j++){
                        cheese[i][j]--;
                    }
                }
                tmp = bfs();
                if(tmp > answer) answer = tmp;
            }
            if(answer == 0) answer++;
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        int cnt = 1;
        int[][] arr = new int[N+2][N+2];
        boolean[][] visit = new boolean[N][N];
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        int tmpX, tmpY;
        int idxX, idxY;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(cheese[i][j] > 0 && arr[i][j] == 0){
                    x.add(i); y.add(j);
                    arr[i][j] = cnt;
                    while(!x.isEmpty()){
                        tmpX = x.poll(); tmpY = y.poll();
                        for(int k = 0; k < 4; k++){
                            idxX = tmpX + dx[k];
                            idxY = tmpY + dy[k];
                            if(cheese[idxX][idxY] > 0 && !visit[idxX-1][idxY-1]){
                                x.add(idxX); y.add(idxY);
                                arr[idxX][idxY] = cnt;
                                visit[idxX-1][idxY-1] = true;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt-1;
    }
}