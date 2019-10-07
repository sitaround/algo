package SWEA;
import java.io.*;

public class Solution5678 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        char[] input;
        char[] str;
        int[] manacher;
        int len;
        int answer;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            input = br.readLine().trim().toCharArray();
            len = input.length * 2 + 1;
            str = new char[len];
            for(int i = 0; i < len-1; i+=2){
                str[i] = '#';
                str[i+1] = input[i/2];
            }
            str[len-1] = '#';
            manacher = new int[len];
            manachers(str, manacher);
            for(int i = 0; i < len; i++){
                answer = manacher[i] > answer ? manacher[i] : answer;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void manachers(char[] str, int[] A){  //이해 안감. 다시 보기
        int N = str.length;
        int r = 0, p = 0;
        for(int i = 0; i < N; i++){
            if(i <= r) A[i] = A[2*p-i] > r-i ? r-i : A[2*p-i];
            else A[i] = 0;
            while(i - A[i] - 1 >= 0 && i + A[i] + 1 < N && str[i-A[i]-1] == str[i+A[i]+1]){
                A[i]++;
            }
            if(r < i + A[i]){
                r = i + A[i];
                p = i;
            }
        }
    }
}