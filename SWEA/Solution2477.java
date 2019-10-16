package SWEA;
import java.io.*;

public class Solution2477 {
    static int answer;
    static int N, M, K, A, B;//N : 접수 창구, M : 정비 창구, K : 손님 수, A : 이용한 접수 창구, B : 이용한 정비 창구
    static int[] a;//접수 창구 처리 시간
    static int[] b;//정비 창구 처리 시간
    static int[] t;//도착한 시간
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]); M = Integer.parseInt(parse[1]);
            K = Integer.parseInt(parse[2]);
            A = Integer.parseInt(parse[3]); B = Integer.parseInt(parse[4]);
            a = new int[N+1]; b = new int[M+1]; t = new int[K+1];
            parse = br.readLine().trim().split(" ");
            for(int i = 1; i <= N; i++){
                a[i] = Integer.parseInt(parse[i-1]);
            }
            parse = br.readLine().trim().split(" ");
            for(int i = 1; i <= M; i++){
                b[i] = Integer.parseInt(parse[i-1]);
            }
            parse = br.readLine().trim().split(" ");
            for(int i = 1; i <= K; i++){
                t[i] = Integer.parseInt(parse[i-1]);
            }
            solve();
            answer = answer == 0 ? -1 : answer;
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int time = t[1];
        int cnt = 0;
        int w1 = 1;
        int w2 = 1;
        int w3 = 1;
        int[] rec_time = new int[N+1];
        int[] rec_cus = new int[N+1];
        int[] cus_rec = new int[K+1];
        int[] cus_num = new int[K+1];
        int[] rep_time = new int[M+1];
        while(cnt != K){
            if(w2 <= K){
                for(int i = 1; i <= N; i++){
                    if(rec_time[i] == 0){
                        if(w1 <= K && t[w1] <= time){
                            rec_time[i] = a[i];
                            rec_cus[i] = w1;
                            w1++;
                        }
                    }
                    if(rec_time[i] > 0){
                        rec_time[i]--;
                        if(rec_time[i] == 0){
                            cus_num[w2] = rec_cus[i];
                            cus_rec[w2] = i;
                            w2++;
                        }
                    }
                }
            }
            for(int i = 1; i <= M; i++){
                if(w2 > w3){
                    if(rep_time[i] == 0){
                        if(w3 <= K){
                            rep_time[i] = b[i];
                            if(cus_rec[w3] == A && i == B){
                                answer += cus_num[w3];
                            }
                            w3++;
                        }
                    }
                }
                if(rep_time[i] > 0){
                    rep_time[i]--;
                    if(rep_time[i] == 0) cnt++;
                }
            }
            time++;
        }
    }
}