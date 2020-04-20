package SWEA;

import java.io.*;

public class Solution1220 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer;
        int[][] map;

        for(int test_case = 1; test_case <= 1; test_case++){
            bw.write("#"+test_case+" ");
            int len = Integer.parseInt(br.readLine().trim());
            map = new int[len][len];
            for(int i = 0; i < len; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < len; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                }
            }
            answer = solve(map, len);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    //1은 아래로. 2는 위로
    static int solve(int[][] map, int len){
        int cnt = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(map[j][i] == 1){
                    for(int k = j+1; k < len; k++){
                        if(map[k][i] == 2) {
                            cnt++;
                            j = k;
                            break;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}