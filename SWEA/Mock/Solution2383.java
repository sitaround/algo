package SWEA;

import java.io.*;
import java.util.Arrays;

public class Solution2383 {
    static int answer;
    static int nop;
    static int N;
    static int[][] map;
    static stair[] s;
    static person[] p;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int idx;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = Integer.MAX_VALUE; nop = 0; idx = 0;
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            s = new stair[2];
            for(int i = 0; i < N; i++){
                String[] parse = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(parse[j]);
                    if(map[i][j] > 1){
                        s[idx++] = new stair(i,j,map[i][j]);
                    }else if(map[i][j] == 1) nop++;
                }
            }
            solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int cases = 0;
        p = new person[nop];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    p[cases++] = new person(i, j);
                }
            }
        }
        cases = 1 << nop;
        for(int i = 0; i < cases; i++){
            for(int j = 0; j < nop; j++){
                if((i >> j & 1) == 1){
                    p[j].sel = 1;
                    p[j].setLen(s[1]);
                }else{
                    p[j].sel = 0;
                    p[j].setLen(s[0]);
                }
            }
            findTime();
        }
    }
    static void findTime(){
        int p1 = 0, cnt = 0;
        int[] s1 = new int[3];
        int[] s2 = new int[3];
        person[] tmp = new person[nop];
        for(int i = 0; i < nop; i++){
            tmp[i] = p[i];
        }
        Arrays.sort(tmp);
        int time = tmp[0].len;
        while(cnt != nop){
            for(int i = 0; i < 3; i++){
                if(nop > p1 && s1[i] == 0){
                   if(tmp[p1].sel == 0 && time >= tmp[p1].len){
                        s1[i] = s[0].len;
                        p1++;
                   }
                }
                if(nop > p1 && s2[i] == 0){
                    if(tmp[p1].sel == 1 && time >= tmp[p1].len){
                        s2[i] = s[1].len;
                        p1++;
                    }
                }
                if(s1[i] > 0){
                    s1[i]--;
                    if(s1[i] == 0){
                        cnt++;
                    }
                }
                if(s2[i] > 0){
                    s2[i]--;
                    if(s2[i] == 0){
                        cnt++;
                    }
                }
            }
            time++;
        }
        answer = answer > time ? time : answer;
    }
    static class stair{
        int x, y, len;
        stair(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    static class person implements Comparable<person>{
        int x, y, len, sel;
        person(int x, int y){
            this.x = x;
            this.y = y;
        }
        void setLen(stair s){
            this.len = abs(this.x - s.x) + abs(this.y - s.y) + 1;
        }
		@Override
		public int compareTo(person o) {
			return this.len > o.len ? 1 : -1;
		}
    }
    static int abs(int num){
        return num > 0 ? num : -num;
    }
}