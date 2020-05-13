package SWEA.D3;

import java.io.*;

public class Solution4047 {
    static final char[] shape = {'S', 'D', 'H', 'C'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        String answer;
        char[] card;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            card = br.readLine().trim().toCharArray();
            answer = solve(card);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(char[] n) {
        StringBuilder sb = new StringBuilder();
        int len = n.length/3;
        int tmp;
        int[] cnt = new int[4];
        int[] chk = new int[4];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 4; j++) {
                if(shape[j] == n[i*3]) {
                    String parse = "";
                    parse += n[i*3+1];
                    parse += n[i*3+2];
                    tmp = Integer.parseInt(parse) - 1;
                    if((chk[j] >> tmp & 1) == 1) return "ERROR";
                    chk[j] |= 1<<tmp;
                    cnt[j]++;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            sb.append(13-cnt[i] + " ");
        }
        return sb.toString();
    }

}