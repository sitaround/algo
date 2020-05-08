package SWEA.D3;

import java.io.*;

public class Solution1221 {
    static final String[] word = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] input = br.readLine().trim().split(" ");
            int len = Integer.parseInt(input[1]);
            String[] num = br.readLine().trim().split(" ");
            String answer = solve(num, len);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static String solve(String[] num, int len){
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[10];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 10; j++){
                if(word[j].equals(num[i])) cnt[j]++;
            }
        }
        for(int i = 0; i < 10; i++){
            while(cnt[i] > 0){
                sb.append(word[i] + " ");
                cnt[i]--;
            }
        }
        return sb.toString();
    }
}