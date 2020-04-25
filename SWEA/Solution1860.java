package SWEA;

import java.io.*;
import java.util.Arrays;

public class Solution1860 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        String answer;
        int[] arr;
        int n, m, k;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            k = Integer.parseInt(parse[2]);
            parse = br.readLine().trim().split(" ");
            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(parse[i]);
            }
            answer = solve(n, m, k, arr);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(int n, int m, int k, int[] arr){
        int max;
        Arrays.sort(arr);
        max = arr[n-1];
        int[] num = new int[max+1];
        for(int i = 1; i < max+1; i++){
            num[i] = (i/m)*k;
        }
        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j < max+1; j++){
                num[j]--;
                if(num[j] < 0) return "Impossible";
            }
        }
        return "Possible";
    }
}