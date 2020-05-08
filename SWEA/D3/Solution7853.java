package SWEA.D3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution7853{
    static final int p = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        char[] c;
        int[] cnt;
        long answer;
        
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 1;
            c = br.readLine().toCharArray();
            cnt = new int[c.length];
            cnt[0] = (c[0] != c[1] ? 2 : 1);
            cnt[c.length-1] = (c[c.length-1] != c[c.length-2] ? 2 : 1);
            for(int i = 1; i < c.length-1; i++){
                cnt[i]++;
                if(c[i] != c[i-1])
                    cnt[i]++;
                if(c[i] != c[i+1])
                    cnt[i]++;
                if(c[i-1] == c[i+1] && c[i] != c[i-1])
                    cnt[i]--;
            }
            for(int i = 0; i < c.length; i++){
                answer *= cnt[i];
                answer %= p;
            }

            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}