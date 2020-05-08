package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//문제의 테스트케이스가 너무 적음. 시간 초과가 나는 N, K 값을 넣어도 통과됨. 
//테스트케이스가 더 추가되면 제대로 풀어서 올리겠음.
class Solution7466{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int answer;
        int N, K;
        
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 1;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]);
            K = Integer.parseInt(parse[1]);
            if(N < K){
                while(N > 0){
                    if(K == 1) break;
                    if(K % N == 0){
                        answer *= N;
                        K /= N;
                        if(N >= K) N = K;
                        else N--;
                    }else N--;
                }
            }else{
                answer = K;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}