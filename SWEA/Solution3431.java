package SWEA;

import java.io.*;

public class Solution3431 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int L, U, X;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            L = Integer.parseInt(parse[0]);
            U = Integer.parseInt(parse[1]);
            X = Integer.parseInt(parse[2]);
            answer = solve(L, U, X);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int l, int u, int x){
        if(x < l){
            return l - x;
        }else if(x > u){
            return -1;
        }else{
            return 0;
        }
    }
}