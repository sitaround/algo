package SWEA.D3;


import java.io.*;

public class Solution3233 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        long answer;
        long A, B;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            A = Integer.parseInt(parse[0]);
            B = Integer.parseInt(parse[1]);
            answer = solve(A, B);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static long solve(long a, long b){
        return (a*a)/(b*b);
    }
}