package SWEA;
import java.io.*;

public class Solution5644 {
    static int answer;
    static final int[] dx = {0, 0, 1, 0, -1};
    static final int[] dy = {0, -1, 0, 1, 0};
    static int M, A;
    static int[][] users;
    static ap[] aps;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            answer = 0;
            String[] parse = br.readLine().trim().split(" ");
            M = Integer.parseInt(parse[0]);
            A = Integer.parseInt(parse[1]);
            users = new int[2][M+1];
            for(int i = 0; i < 2; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 1; j <= M; j++){
                    users[i][j] = Integer.parseInt(parse[j-1]);
                }
            }
            aps = new ap[A];
            int[] tmp = new int[4];
            for(int i = 0; i < A; i++){
                parse = br.readLine().trim().split(" ");
                for(int j = 0; j < 4; j++){
                    tmp[j] = Integer.parseInt(parse[j]);
                }
                aps[i] = new ap(tmp[0], tmp[1], tmp[2], tmp[3]);
            }
            solve();
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(){
        int x1, y1, x2, y2;
        x1 = 1; y1 = 1;
        x2 = 10; y2 = 10;
        for(int i = 0; i <= M; i++){
            x1 += dx[users[0][i]];
            y1 += dy[users[0][i]];
            x2 += dx[users[1][i]];
            y2 += dy[users[1][i]];
            answer += performance(x1, y1, x2, y2);
        }
    }
    static int performance(int x, int y, int x1, int y1){
        int idx1 = -1;
        int idx2 = -2;
        int max1 = 0;
        int max2 = 0;
        int ax, ay, ac, a_p;
        for(int i = 0; i < A; i++){
            ax = aps[i].x;  ay = aps[i].y;
            ac = aps[i].c;  a_p = aps[i].p;
            if(ac >= abs(x - ax) + abs(y - ay)){
                if(max1 < a_p){
                    max1 = a_p;
                    idx1 = i;
                }
            }
            if(ac >= abs(x1 - ax) + abs(y1 - ay)){
                if(max2 < a_p){
                    max2 = a_p;
                    idx2 = i;
                }
            }
        }
        if(idx1 != idx2){
            return max1 + max2;
        }else{
            int tmp1 = 0, tmp2 = 0;
            for(int i = 0; i < A; i++){
                if(idx1 == i) continue;
                ax = aps[i].x;  ay = aps[i].y;
                ac = aps[i].c;  a_p = aps[i].p;
                if(ac >= abs(x - ax) + abs(y - ay)){
                    tmp1 = tmp1 < a_p ? a_p : tmp1;
                }
            }
            for(int i = 0; i < A; i++){
                if(idx2 == i) continue;
                ax = aps[i].x;  ay = aps[i].y;
                ac = aps[i].c;  a_p = aps[i].p;
                if(ac >= abs(x1 - ax) + abs(y1 - ay)){
                    tmp2 = tmp2 < a_p ? a_p : tmp2;
                }
            }
            if(tmp1 > tmp2){
                return max2 + tmp1;
            }else{
                return max1 + tmp2;
            }
        }
    }
    static int abs(int x){
        return x < 0 ? -x : x;
    }
    static class ap{
        int x, y, c, p;
        ap(int x, int y, int c, int p){
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}