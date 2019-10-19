package SWEA;
import java.io.*;
import java.util.Arrays;

public class Solution1952 {
    static StringBuilder sb = new StringBuilder();
    static int answer;
    static int[] pee;
    static int[] month;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            pee = new int[4];
            month = new int[14];
            String[] parse = br.readLine().trim().split(" ");
            for(int i = 0; i < 4; i++){
                pee[i] = Integer.parseInt(parse[i]);
            }
            parse = br.readLine().trim().split(" ");
            for(int i = 0; i < 12; i++){
                month[i] = Integer.parseInt(parse[i]);
            }
            solve();
            bw.write(answer+"\n");
        }
        System.out.println();
        System.out.println(sb);
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int[] dp = new int[14];
        int p = 0;
        for(int i = 0; i < 12; i++){
            dp[i] = Integer.MAX_VALUE;
            p = month[i]*pee[0];
            dp[i] = min(p, pee[1]);
        }
        sb.append(Arrays.toString(dp)+'\n');
        for(int i = 10; i > -1; i--){
            dp[i] = min(dp[i] + dp[i+1], pee[2]+dp[i+3]);
        }
        if(dp[0] > pee[3]) dp[0] = pee[3];
        answer = dp[0];
    }
    static int min(int x, int y){
        return x < y ? x : y;
    }
}