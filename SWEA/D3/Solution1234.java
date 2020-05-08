package SWEA.D3;


import java.io.*;
import java.util.ArrayList;

public class Solution1234 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // int T = Integer.parseInt(br.readLine().trim());
        String answer;
        for(int test_case = 1; test_case <= 10; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            answer = solve(Integer.parseInt(parse[0]), parse[1]);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(int n, String pwd) {
        String ans = "";
        int cnt = 0;
        int tmp = n;
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(pwd.charAt(i));
        }
        while(cnt < n/2) {
            for(int i = 1; i < tmp; i++){
                if(list.get(i-1) == list.get(i)){
                    list.remove(i);
                    list.remove(i-1);
                    tmp -= 2;
                }
            }
            cnt++;
        }
        for(char c : list){
            ans += c;
        }
        return ans;
    }
}