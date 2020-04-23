package SWEA;

import java.io.*;

public class Solution1289 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        char[] memory;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            memory = br.readLine().trim().toCharArray();
            answer = solve(memory);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(char[] memory){
        int len = memory.length;
        int cnt = 0;
        char[] tmp = new char[len];
        for(int i = 0; i < len; i++){
            tmp[i] = '0';
        }
        for(int i = 0; i < len; i++){
            if(memory[i] != tmp[i]){
                for(int j = i; j < len; j++){
                    tmp[j] = memory[i];
                }
                cnt++;
            }
        }
        return cnt;
    }
}