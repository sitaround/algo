package SWEA.D3;

import java.io.*;

public class Solution3499 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        // int answer;
        int n;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            String[] card = br.readLine().trim().split(" ");
            bw.write(solve(n, card)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(int n, String[] card) {
        StringBuilder sb = new StringBuilder();
        int idx;
        int end;
        end = idx = n/2;
        if(n % 2 == 1) {
            idx++;
            for(int i = 0; i < end; i++) {
                sb.append(card[i] + " ");
                sb.append(card[idx + i] + " ");
            }
            sb.append(card[end]);
        } else {
            for(int i = 0; i < end; i++) {
                sb.append(card[i] + " ");
                sb.append(card[idx + i] + " ");
            }
        }
        return sb.toString();
    }
}