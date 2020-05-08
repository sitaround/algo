package SWEA;
import java.io.*;

public class Solution1218 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len;
        char[] bracket;
        for(int test_case = 1; test_case <= 10; test_case++){
            bw.write("#"+test_case+" ");
            len = Integer.parseInt(br.readLine().trim());
            bracket = br.readLine().trim().toCharArray();
            bw.write(isValid(len, bracket)+"\n");
        }
        bw.flush();
    }
    static int isValid(int len, char[] bracket){
        int answer = 0;
        if(len % 2 != 0)    return 0;
        int a = 0, b = 0, c = 0, d = 0;
        for(char ch : bracket){
            switch(ch){
                case '(': a++; break;
                case ')': a--; break;
                case '[': b++; break;
                case ']': b--; break;
                case '{': c++; break;
                case '}': c--; break;
                case '<': d++; break;
                case '>': d--; break;
            }
            if(a < 0 || b < 0 || c < 0 || d < 0) return 0;
        }
        if(a == 0 && b == 0 && c == 0 && d == 0) answer = 1;
        return answer;
    }
}