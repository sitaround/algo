package SWEA;
import java.io.*;

public class Solution2115 {
    static int N, M, C;
    static int answer;
    static int[][] map;
    static int visitX, visitY;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            M = Integer.parseInt(parse[1]);
            C = Integer.parseInt(parse[2]);
            map = new int[N][N];
            for(int i = 0; i < N; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
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
        int[] arr = new int[M];
        int max1 = 0, max2 = 0, tmp;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-M+1; j++){
                for(int k = 0; k < M; k++){
                    arr[k] = map[i][j+k];
                }
                tmp = max(arr);
                if(tmp > max1){
                    max1 = tmp;
                    visitX = i;
                    visitY = j;
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-M+1; j++){
                if(i == visitX && j >= visitY && j < visitY + M) continue;
                if(i == visitX && j+M-1 >= visitY) continue;
                for(int k = 0; k < M; k++){
                    arr[k] = map[i][j+k];
                }
                tmp = max(arr);
                if(tmp > max2)  max2 = tmp;
            }
        }
        answer = max1 + max2;
        if(2*M > N) return;
        max1 = 0; max2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-2*M+1; j++){
                for(int k = 0; k < M; k++){
                    arr[k] = map[i][j+k];
                }
                max1 = max(arr);
                for(int k = M; k < 2*M; k++){
                    arr[k-M] = map[i][j+k];
                }
                max2 = max(arr);
                if(max1 + max2 > answer)    answer = max1 + max2;
            }
        }
    }
    static int max(int[] m){
        int max = 0;
        int n = 1<<M;
        int tmp = 0;
        int tmp1 = 0;
        boolean chk = true;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < M; j++){
                if(( i >> j ) % 2 == 1){
                    tmp += m[j];
                    tmp1 += m[j] * m[j];
                }
                if(tmp > C){
                    chk = false;
                    break;
                }
            }
            if(chk && max < tmp1) max = tmp1;
            chk = true; tmp = 0; tmp1 = 0;
        }
        return max;
    }

}