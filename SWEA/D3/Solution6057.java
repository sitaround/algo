package SWEA.D3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
 
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
        boolean[][] visit = new boolean[n+1][n+1];
        Queue<Vertex> q = new LinkedList<>();
        Vertex v;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(visit[i][j] || !vertex[i][j]) continue;
                q.add(new Vertex(i, j, 1));
                visit[i][j] = true;
                visit[j][i] = true;
                while(!q.isEmpty()) {
                    v = q.poll();
                    if(v.cnt == 3 && i == v.y) {
                        ans++;
                        continue;
                    }
                    if(v.cnt == 3) continue;
                    for(int k = 1; k <= n; k++) {
                        if(visit[v.y][k] || !vertex[v.y][k]) continue;
                        q.add(new Vertex(v.y, k, v.cnt+1));
                    }
                }
            }
        }
        return ans;
    }
 
    static class Vertex {
        int x, y, cnt;
        Vertex(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}