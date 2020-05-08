package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

class Solution7701{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int N, size;
        String tmp;
        ArrayList<String>[] name;
        
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+"\n");
            N = Integer.parseInt(br.readLine());
            name = new ArrayList[50];
            for(int i = 0; i < 50; i++)
                name[i] = new ArrayList<String>();
            for(int i = 0; i < N; i++){
                String input = br.readLine();
                name[input.length()-1].add(input);
            }
            for(int i = 0; i < 50; i++){
                Collections.sort(name[i]);
                size = name[i].size();
                if(size != 0){
                    bw.write(name[i].get(0) + "\n");
                    for(int j = 1; j < size; j++){
                        tmp = name[i].get(j);
                        if(!tmp.equals(name[i].get(j-1)))
                            bw.write(tmp+"\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}