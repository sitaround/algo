package SWEA.D4;

import java.io.*;

public class Solution8659 {
    static long[] arr1 = new long[91];
    static long[] arr2 = new long[91];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int K;
        solve();
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            K = Integer.parseInt(br.readLine());
            bw.write(arr1[K]+" "+arr2[K]+"\n");
        }
        bw.flush();
    }
    static void solve(){
        arr1[1] = 2; arr2[1] = 1;
        for(int i = 2; i < 91; i++){
            arr1[i] = arr1[i-1] + arr2[i-1];
            arr2[i] = arr1[i-1];
        }
    }
}