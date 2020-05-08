package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution7854{
    static int[] arr = new int[43];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int N;
        int answer;
        solve();
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 1;
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < 43; i++)
                if(arr[i] > N){
                    answer = i;
                    break;
                }
            if(N == 1000000000)
                answer = 43;
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve(){
        arr[0] = 1; arr[1] = 2; arr[2] = 5; arr[3] = 10;
        arr[4] = 20; arr[5] = 25; arr[6] = 50; arr[7] = 100;
        arr[8] = 125;
        for(int i = 9; i < 43; i++)
            arr[i] = arr[i-5]*10;
    }

}