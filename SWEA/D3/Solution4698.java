package SWEA.D3;

import java.io.*;

public class Solution4698 {
    static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int d, a, b;
        solve();
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            d = Integer.parseInt(parse[0]);
            a = Integer.parseInt(parse[1]);
            b = Integer.parseInt(parse[2]);
            answer = cnt(d, a, b);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve() {
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i*i < 1000001; i++) {
            if(prime[i]) continue;
            for(int j = i*2; j < 1000001; j+=i) {
               prime[j] = true;
            }
        }
    }
    
    static int cnt(int d, int a, int b) {
        int cnt = 0;
        int tmp;
        for(int i = a; i <= b; i++) {
            if(prime[i]) continue;
            tmp = i;
            while(tmp > 0) {
                if(tmp % 10 == d) {
                    cnt++;
                    break;
                }
                tmp /= 10;
            }
        }
        return cnt;
    }
}