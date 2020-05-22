package SWEA.D3;

import java.io.*;
 
public class Solution6057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        boolean[][] v;
        int n, m;
        int x, y;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            v = new boolean[n+1][n+1];
            for(int i = 0; i < m; i++) {
                parse = br.readLine().trim().split(" ");
                x = Integer.parseInt(parse[0]);
                y = Integer.parseInt(parse[1]);
                v[x][y] = true;
                v[y][x] = true;
            }
            answer = solve(n, v);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    static int solve(int n, boolean[][] vertex) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(vertex[i][j]) {
                    for(int k = j+1; k <= n; k++) {
                        if(vertex[j][k] && vertex[k][i]) ans++;
                    }
                }
            }
        }
        return ans;
    }
}