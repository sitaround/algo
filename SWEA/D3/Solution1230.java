package SWEA.D3;


import java.io.*;
import java.util.ArrayList;

public class Solution1230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // int T = Integer.parseInt(br.readLine().trim());
        int k;
        String answer;
        for(int test_case = 1; test_case <= 10; test_case++) {
            bw.write("#"+test_case+" ");
            br.readLine();
            String[] init = br.readLine().trim().split(" ");
            k = Integer.parseInt(br.readLine().trim());
            String[] command = br.readLine().trim().split(" ");
            answer = solve(init, k, command);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(String[] init, int k, String[] command) {
        int idx = 0;
        int x, y;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < init.length; i++) {
            list.add(init[i]);
        }
        for(int i = 0; i < k; i++) {
            x = Integer.parseInt(command[idx+1]);
            if(command[idx].equals("I")) {
                y = Integer.parseInt(command[idx+2]);
                idx += 3;
                for(int j = 0; j < y; j++){
                    list.add(x++, command[idx+j]);
                }
                idx += y;
            } else if(command[idx].equals("D")) {
                y = Integer.parseInt(command[idx+2]);
                for(int j = 0; j < y; j++){
                    list.remove(x);
                }
                idx += 3;
            } else if(command[idx].equals("A")) {
                idx += 2;
                for(int j = 0; j < x; j++){
                    list.add(command[idx+j]);
                }
                idx += x;
            }
        }
        for(int i = 0; i < 9; i++){
            sb.append(list.get(i) + " ");
        }
        sb.append(list.get(9));
        return sb.toString();
    }
}