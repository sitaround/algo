package SWEA;

import java.io.*;

public class Solution1225 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // int T = Integer.parseInt(br.readLine().trim());
        int[] data;
        String answer;
        for(int test_case = 1; test_case <= 10; test_case++){
            bw.write("#"+test_case+" ");
            br.readLine();
            data = new int[8];
            String[] parse = br.readLine().trim().split(" ");
            for(int i = 0; i < 8; i++){
                data[i] = Integer.parseInt(parse[i]);
            }
            answer = solve(data);
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static String solve(int[] data){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int i = 1;
        while(true){
            data[idx] -= i;
            if(data[idx] <= 0) break;
            idx++; i++;
            if(idx > 7) idx = 0;
            if(i > 5) i = 1;
        }
        data[idx] = 0;
        for(int j = (idx+1)%8, cnt = 0; cnt < 8; j = (j+1)%8){
            sb.append(data[j] + " ");
            cnt++;
        }
        return sb.toString();
    }
}