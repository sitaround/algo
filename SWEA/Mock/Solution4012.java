package SWEA.Mock;

import java.io.*;

public class Solution4012 {
    static int answer;
    static int N;
    static int[][] S;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    S[i][j] = Integer.parseInt(parse[j]);
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
        int cases = (1 << N) - (1 << N/2) - 1;
        int cnt;
        int tmp;
        for(int i = (1<<N/2)-1; i < cases; i++){
            cnt = 0;
            for(int j = 0; j < N; j++){
                if((i >> j & 1) == 1) cnt++;
            }
            if(cnt == N/2) {
                tmp = synergy(i);
                answer = tmp < answer ? tmp : answer;
            }
        }
    }
    static int synergy(int cases){
        int[] f1 = new int[N/2];
        int[] f2 = new int[N/2];
        int tmp1 = 0, tmp2 = 0;
        for(int i = 0; i < N; i++){
            if((cases >> i & 1) == 1){
                f1[tmp1++] = i;
            }else{
                f2[tmp2++] = i;
            }
        }
        tmp1 = 0; tmp2 = 0;
        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < N/2; j++){
                tmp1 += S[f1[i]][f1[j]];
                tmp2 += S[f2[i]][f2[j]];
            }
        }
        return abs(tmp1-tmp2);
    }
    static int abs(int x){
        return x < 0 ? -x : x;
    }
}