package SWEA.D3;

import java.io.*;

public class Solution3260 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        String answer;
        int[] num1, num2;
        int len1, len2;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            len1 = parse[0].length() - 1;
            len2 = parse[1].length() - 1;
            num1 = new int[102];
            num2 = new int[102];
            for(int i = 101; len1 > -1; i--){
                num1[i] = parse[0].charAt(len1--) - '0';
            }
            for(int i = 101; len2 > -1; i--){
                num2[i] = parse[1].charAt(len2--) - '0';
            }
            answer = solve(num1, num2);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve( int[] num1, int[] num2) {
        StringBuilder sb = new StringBuilder();
        int[] num = new int[102];
        int tmp;
        boolean chk = false;
        for(int i = 101; i > 0; i--) {
            tmp = num1[i] + num2[i];
            if(tmp > 9) {
                num[i] += tmp - 10;
                num[i-1]++;
            } else {
                num[i] += tmp;
                if(num[i] > 9) {
                   num[i] -= 10;
                   num[i-1]++; 
                }
            }
        }
        for(int i = 0; i < 102; i++) {
            if(!chk && num[i] != 0) {
                chk = true;
            }
            if(chk) sb.append(num[i]);
        }
        return sb.toString();
    }
}