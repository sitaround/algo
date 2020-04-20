package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1216 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T;
        // T = Integer.parseInt(br.readLine());
        int answer;
        char[][] arr;

        for(int test_case = 1; test_case < 11; test_case++){
            T = Integer.parseInt(br.readLine().trim());
            bw.write("#"+T+" ");
            arr = new char[100][100];
            for(int i = 0; i < 100; i++){
                String input = br.readLine().trim();
                arr[i] = input.toCharArray();
            }
            answer = solve(arr);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(char[][] arr){
        int cnt = Integer.MIN_VALUE;
        for(int i = 0; i < 100; i++){
            for(int len = 100; len > 0; len--){
                if(len < cnt) break;
                for(int j = 0; j <= 100-len; j++){
                    int start = j;
                    int end = start + len - 1;
                    boolean chk = true;
                    while(start < end){
                        if(arr[i][start] != arr[i][end]){
                            chk = false;
                            break;
                        }
                        start++;
                        end--;
                    }
                    if(chk) cnt = cnt > len ? cnt : len;
                }
            }
        }
        for(int i = 0; i < 100; i++){
            for(int len = 100; len > 0; len--){
                if(len < cnt) break;
                for(int j = 0; j <= 100-len; j++){
                    int start = j;
                    int end = start + len - 1;
                    boolean chk = true;
                    while(start < end){
                        if(arr[start][i] != arr[end][i]){
                            chk = false;
                            break;
                        }
                        start++;
                        end--;
                    }
                    if(chk) cnt = cnt > len ? cnt : len;
                }
            }
        }
        return cnt;
    }
}