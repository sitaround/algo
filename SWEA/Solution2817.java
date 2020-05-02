package SWEA;

import java.io.*;

public class Solution2817 {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n, k;
        int[] num;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            k = Integer.parseInt(parse[1]);
            num = new int[n];
            parse = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                num[i] = Integer.parseInt(parse[i]);
            }
            answer = 0;
            solve(n, k, num, 0, 0, 0);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void solve(int n, int k, int[] num, int start, int flag, int sum){
        if(k == sum) {
            answer++;
            return;
        }
        for(int i = start; i < n; i++){
            if(((flag>>i)&1) == 1)  continue;
            if(sum + num[i] > k)    continue;
            solve(n, k, num, i, flag|1<<i, sum + num[i]);
        }
    }
}