package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution7965{
    static final int p = 1000000007;
    static long[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int N;
        answer = new long[1000001];
        for(int i = 1; i < 1000001; i++){
            answer[i] = (answer[i-1] + pow(i)) % p;
        }

        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            N = Integer.parseInt(br.readLine());
            bw.write(answer[N]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long pow(long k){
        long temp = 1;
        long k2 = k;
        while(k2 > 0){
            if(k2 % 2 == 1) temp *= k;
            k *= k;
            k %= p;
            k2 /= 2;
            temp %= p;
        }
        return temp;
    }
}