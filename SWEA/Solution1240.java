package SWEA;

import java.io.*;

public class Solution1240 {
    static final String[] num = {"0001101", "0011001", "0010011", "0111101", "0100011", 
    "0110001", "0101111", "0111011", "0110111", "0001011"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n, m;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            for(int i = 0; i < n; i++){
                String tmp = br.readLine().trim();
                if(tmp.contains("1")){
                    answer = solve(tmp, m);
                    for(int j = i+1; j < n; j++){
                        br.readLine();
                    }
                    break;
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(String tmp, int m){
        int ans = 0;
        int[] pwd = new int[8];
        String code = "";
        for(int i = m-1; i > -1; i--){
            if(tmp.charAt(i) == '1') {
                code = tmp.substring(i - 56 + 1, i+1);
                break;
            }
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(code.substring(i*7, (i+1)*7).equals(num[j])){
                    pwd[i] = j;
                }
            }
        }
        for(int i = 0; i < 8; i+=2){
            ans += pwd[i];
        }
        ans *= 3;
        for(int i = 1; i < 8; i+=2){
            ans += pwd[i];
        }
        if(ans % 10 != 0){
            ans = 0;
        }else{
            ans = 0;
            for(int i : pwd){
                ans += i;
            }
        }
        return ans;
    }
}