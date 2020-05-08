package SWEA.D3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution8104{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int N, K, total;
        int answer;

        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            K = Integer.parseInt(parse[1]);
            total = N * K;
            answer = (total+1)*(total/2);
            answer += (total % 2 == 1 ? total / 2 + 1 : 0);
            System.out.println(answer);
            if(K % 2 == 1){
                for(int i = 0; i < K-1; i++)
                    bw.write(answer/K+" ");
                bw.write(answer/K+"\n");
            }else{
                int tmp = 0;
                for(int i = 0; i < K; i++)
                    tmp += i;
                answer -= tmp;
                answer /= K;
                for(int i = 0; i < K-1; i++)
                    bw.write(answer+i+" ");
                bw.write(answer+K-1+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}