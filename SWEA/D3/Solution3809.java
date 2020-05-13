package SWEA.D3;

import java.io.*;

public class Solution3809 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n;
        int tmp;
        int[] num;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            tmp = 0;
            n = Integer.parseInt(br.readLine().trim());
            num = new int[n];
            while(tmp < n) {
                String[] parse = br.readLine().trim().split(" ");
                for(int i = tmp ; i < tmp + parse.length; i++) {
                    num[i] = Integer.parseInt(parse[i-tmp]);
                }
                tmp += parse.length;
            }
            answer = solve(n, num);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int[] num) {
        int ans = 0;
        int tmp = 0;
        boolean[] nums = new boolean[1001];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n-i; j++) {
                tmp = num[j];
                for(int k = 1; k <= i; k++) {
                    tmp *= 10;
                    tmp += num[j+k];
                }
                nums[tmp] = true;
            }
        }
        for(int i = 0; i < 1001; i++) {
            if(!nums[i]){
                ans = i;
                break;
            }
        }
        return ans;
    }
    
}