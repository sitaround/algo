package SWEA.D4;

import java.io.*;
import java.util.Stack;

class Solution8424{
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine().trim());
        int answer;

        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N+1][N+1];
            for(int i = 0; i < N; i++){
                String[] parse = br.readLine().trim().split(" ");
                map[Integer.parseInt(parse[0])][Integer.parseInt(parse[1])] = 1;
                map[Integer.parseInt(parse[1])][Integer.parseInt(parse[0])] = 1;
            }
            answer = solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(){
        int answer = 0;
        int station = 1;
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[N+1];
        boolean chk = true, flag = false;
        stack.push(station);
        visit[station] = true;
        while(true){
            chk = true;
            for(int i = 1; i <= N; i++){
                if(map[station][i] == 0) continue;
                if(visit[i]) {station = i; flag = true; break;}
                map[station][i] = map[i][station] = 0;
                station = i; stack.push(station);
                chk = false; visit[station] = true;
                break;
            }
            if(flag){
                while(!stack.isEmpty()){
                    answer++;
                    if(stack.pop() == station) break;
                }
                break;
            }
            if(chk){
                stack.pop();
                station = stack.peek();
            }
        }
        return answer;
    }
}