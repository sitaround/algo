package SWEA.D4;

import java.io.*;

public class Solution9088 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer, N, K;
        int[] dia;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            K = Integer.parseInt(parse[1]);
            dia = new int[10001];
            for(int i = 0; i < N; i++){
                dia[Integer.parseInt(br.readLine().trim())]++;
            }
            if(K == 0){
                for(int i = 1; i < 10001; i++){
                    answer = answer < dia[i] ? dia[i] : answer;
                }
            }else{
                for(int i = 1; i+K < 10001; i++){
                    int tmp = 0;
                    for(int j = i; j <= i+K; j++){
                        tmp += dia[j];
                    }
                    answer = tmp > answer ? tmp : answer;
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}