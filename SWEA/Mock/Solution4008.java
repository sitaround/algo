package SWEA.Mock;

import java.io.*;

public class Solution4008 {
    static int answer;
    static int N;
    static int[] operator;
    static int[] operand;
    static int max, min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine().trim());
            operator = new int[4];
            String[] parse = br.readLine().trim().split(" ");
            for(int i = 0; i < 4; i++){
                operator[i] = Integer.parseInt(parse[i]);
            }
            operand = new int[N];
            parse = br.readLine().trim().split(" ");
            for(int i = 0; i < N; i++){
                operand[i] = Integer.parseInt(parse[i]);
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfs(operand[0], 1);
            answer = max - min;
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int value, int idx){
        if(idx == N){
            max = value > max ? value : max;
            min = value < min ? value : min;
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--;
                dfs(compute(value, operand[idx], i), idx+1);
                operator[i]++;
            }
        }
    }
    static int compute(int a, int b, int o){
        switch(o){
            case 0:
                return a+b;
            case 1:
                return a-b;
            case 2:
                return a*b;
            default:
                return a/b;
        }
    }
}