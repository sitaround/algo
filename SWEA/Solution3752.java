import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution3752{
    static boolean[] isExist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] score;
        int answer, N, sum, idx;
        for (int test_case = 1; test_case <= T; test_case++) {
            bw.write("#" + test_case + " ");
            answer = 0; sum = 0;
            N = Integer.parseInt(br.readLine());
            score = new int[N];
            String[] parse = br.readLine().trim().split(" ");
            for(int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(parse[i]);
                sum += score[i];
            }
            isExist = new boolean[sum+1];
            isExist[0] = true;
            idx = 0;
            while(idx < N) {
                for (int i = sum; i >= 0; i--) {
                    if(isExist[i])
                        isExist[i+score[idx]] = true;
                }
                idx++;
            }
            for(int i = 0; i < isExist.length; i++)
                if(isExist[i])
                    answer++;
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
