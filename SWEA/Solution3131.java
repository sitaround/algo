package SWEA;

import java.io.*;

public class Solution3131 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] answer = new boolean[1000001];
        answer[0] = true;
        answer[1] = true;
        for(int i = 2; i*i < 1000001; i++){
            if(!answer[i]){
                for(int j = i*i; j < 1000001; j += i) answer[j] = true;
            }
        }
        for(int i = 0; i < 1000001; i++){
            if(!answer[i]) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

}