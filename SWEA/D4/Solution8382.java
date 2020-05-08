package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution8382{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T;
        int x1, y1, x2, y2;
        int subX, subY, subXY;
        int answer;
        T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            x1 = Integer.parseInt(parse[0]); y1 = Integer.parseInt(parse[1]);
            x2 = Integer.parseInt(parse[2]); y2 = Integer.parseInt(parse[3]);
            subX = (x2 - x1 < 0 ? x1 - x2 : x2 - x1);
            subY = (y2 - y1 < 0 ? y1 - y2 : y2 - y1);
            subXY = (subX - subY < 0 ? subY - subX : subX - subY);
            answer = (subX > subY ? subY * 2 : subX * 2);
            if(subXY % 2 == 0){
                answer += subXY * 2;
            }else{
                answer += (subXY - 1) * 2 + 1;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}