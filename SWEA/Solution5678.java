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

    static void manachers(char[] str, int[] manacher){  //이해 안감. 다시 보기
        int N = str.length;
        int r = 0, p = 0;
        for(int i = 0; i < N; i++){
            if(i <= r) manacher[i] = manacher[2*p-i] > r-i ? r-i : manacher[2*p-i];
            else manacher[i] = 0;
            while(i - manacher[i] - 1 >= 0 && i + manacher[i] + 1 < N && str[i-manacher[i]-1] == str[i+manacher[i]+1]){
                manacher[i]++;
            }
            if(r < i + manacher[i]){
                r = i + manacher[i];
                p = i;
            }
        }
    }
}