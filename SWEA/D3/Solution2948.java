package SWEA;

import java.io.*;
import java.util.Arrays;

public class Solution2948 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n, m;
        String[] str1, str2;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            str1 = br.readLine().trim().split(" ");
            str2 = br.readLine().trim().split(" ");
            answer = solve(n, str1, m, str2);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(int n, String[] str1, int m, String[] str2){
        int ans = 0;
        int idx1 = 0;
        int idx2 = 0;
        Arrays.sort(str1);
        Arrays.sort(str2);
        while(idx1 < n && idx2 < m){
            if(str1[idx1].compareTo(str2[idx2]) > 0){
                idx2++;
            }else if(str1[idx1].compareTo(str2[idx2]) < 0){
                idx1++;
            }else{
                ans++;
                idx1++;
                idx2++;
            }
        }
        return ans;
    }
}