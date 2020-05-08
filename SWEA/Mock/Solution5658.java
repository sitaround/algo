package SWEA.Mock;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution5658 {
    static int answer;
    static int N, K;
    static char[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            K = Integer.parseInt(parse[1]);
            arr = br.readLine().trim().toCharArray();
            solve();
            bw.write(answer+"\n");
        }
        solve();
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int n = N/4;
        ArrayList<String> num = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char tmp = arr[N-1];
            for(int j = N-1; j > 0; j--){
                arr[j] = arr[j-1];
            }
            arr[0] = tmp;
            for(int j = 0; j < 4; j++){
                String input = new String(arr, j*n, n);
                if(num.contains(input)) continue;
                num.add(input);
            }
        }
        String[] sort = new String[num.size()];
        sort = num.toArray(sort);
        Arrays.sort(sort);
        answer = Integer.parseInt(sort[sort.length-K], 16);
    }
}