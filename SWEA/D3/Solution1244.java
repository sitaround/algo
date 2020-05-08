package SWEA.D3;


import java.io.*;

public class Solution1244 {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int k, len;
        int[] num;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            len = parse[0].length();
            num = new int[len];
            for(int i = 0; i < len; i++){
                num[i] = parse[0].charAt(i) - '0';
            }
            k = Integer.parseInt(parse[1]);
            answer = 0;
            solve(num, k, 0, 0);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve(int[] num, int k, int cnt, int flag){
        int len = num.length;
        int max = -1;
        int idx = -1;
        if(k == cnt){
            int tmp = getPrize(num);
            answer = tmp > answer ? tmp : answer;
            return;
        }
        if(flag == (1<<len)-1){
            int tmp;
            for(int i = 1; i < len; i++){
                if(num[i] == num[i-1]){
                    tmp = getPrize(num);
                    answer = tmp > answer ? tmp : answer;
                    return;
                }
            }
            if((k - cnt)%2 == 1){
                swap(num, len-2, len-1);
            }
            tmp = getPrize(num);
            if(tmp == 987654) System.out.println(3);
            answer = tmp > answer ? tmp : answer;
            return;
        }
        for(int i = len-1; i > -1; i--){
            if(max < num[i] && (flag>>i&1) != 1){
                max = num[i];
                idx = i;
            }
        }
        if(idx == 0){
            solve(num, k, cnt, 1<<0);
            return;
        }
        if((1<<idx)-1 == flag){
            solve(num, k, cnt, flag|1<<idx);
            return;
        }
        for(int i = 0; i < len; i++){
            if(max != num[i] && (flag>>i&1) != 1){
                swap(num, idx, i);
                solve(num, k, cnt+1, flag|1<<i);
                swap(num, idx, i);
            }else if(max == num[i] && (flag>>i&1) != 1){
                solve(num, k, cnt, flag|1<<i);
                break;
            }
        }
    }

    static void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    static int getPrize(int[] num){
        int prize = 0;
        for(int i = 0; i < num.length - 1; i++){
            prize += num[i];
            prize *= 10;
        }
        prize += num[num.length-1];
        return prize;
    }
}