package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//disjoint-set 알고리즘.
class Solution7465{
    static int[] par;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int answer;
        int N, M;
        
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            N = Integer.parseInt(parse[0]); M = Integer.parseInt(parse[1]);
            init(N);
            for(int i = 0; i < M; i++){
                parse = br.readLine().trim().split(" ");
                if(parse.length == 1)
                    continue;
                link(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));
            }
            for(int i = 1; i <= N; i++){
                if(par[i] == i)
                    answer++;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void init(int N){
        par = new int[N+1];
        for(int i = 1; i <= N; i++){
            par[i] = i;
        }
    }

    static void link(int x, int y){
        par[find(y)] = find(x);
    }

    static int find(int x){
        if(par[x] == x) return x;
        else return par[x] = find(par[x]);
    }
}