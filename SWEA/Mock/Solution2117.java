package SWEA;
import java.io.*;

public class Solution2117 {
    static int answer;
    static int N, M;
    static int[] costs = new int[22];
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i < 22; i++){
            costs[i] = i * i + (i - 1) * (i - 1);
        }
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = Integer.MIN_VALUE;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]); M = Integer.parseInt(parse[1]);
            map = new int[100][100];
            for(int i = 30; i < 30+N; i++){
                parse =br.readLine().trim().split(" ");
                for(int j = 30; j < 30+N; j++){
                    map[i][j] = Integer.parseInt(parse[j-30]);
                }
            }
            for(int i = 1; i < N+2; i++){
                solve(i);
            }
            if(answer < 0) answer = 1;
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(int K){
        int temp1, temp2;
        for(int i = 30; i < 30 + N; i++){
            for(int j = 30; j < 30 + N; j++){
                if(map[i][j] != 1) continue;
                temp1 = count(i,j,K);
                temp2 = temp1*M - costs[K];
                if(temp2 >= 0 && answer < temp1){
                    answer = temp1;
                }
            }
        }
    }
    static int count(int x, int y, int k){
        int pee = 0;
        for(int i = 30; i < 30 + N; i++){
            for(int j = 30; j < 30 + N; j++){
                if(abs(x-i)+abs(y-j) < k){
                    if(map[i][j] == 1){
                        pee++;
                    }
                }
            }
        }
        return pee;
    }
    static int abs(int x){
        return x < 0 ? -x : x;
    }
}