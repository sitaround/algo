import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution8016{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        long N, K;
        long input;

        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            N = 1; K = 1;
            input = Long.parseLong(br.readLine());
            K = input * input * 2 - 1;
            N = (input - 1) * (input - 1) * 2 + 1;
            bw.write(N+" "+K+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}