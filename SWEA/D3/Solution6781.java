package SWEA.D3;

import java.io.*;

public class Solution6781 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        char[] num;
        char[] color;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            num = br.readLine().trim().toCharArray();
            color = br.readLine().trim().toCharArray();
            bw.write(solve(num, color)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(char[] n, char[] c) {
        int[] r = new int[10];
        int[] g = new int[10];
        int[] b = new int[10];
        int con = 0, same = 0;
        for(int i = 0; i < 9; i++) {
            switch(c[i]) {
                case 'R':
                r[n[i]-'0']++;
                break;
                case 'G':
                g[n[i]-'0']++;
                break;
                case 'B':
                b[n[i]-'0']++;
                break;
            }
        }
        same = findSame(r, g, b);
        if(same > 2) return "Win";
        con += findContinuos(r);
        con += findContinuos(g);
        con += findContinuos(b);
        if(same + con > 2) return "Win";
        return "Continue";
    }

    static int findSame(int[] r, int[] g, int[] b) {
        int same = 0;
        for(int i = 1; i < 10; i++) {
            if(r[i] > 2) {
                same++;
                r[i] -= 3;
                i--;
            }
            if(g[i] > 2) {
                same++;
                g[i] -= 3;
                i--;
            }
            if(b[i] > 2) {
                same++;
                b[i] -= 3;
                i--;
            }
        }
        return same;
    }
    
    static int findContinuos(int[] c) {
        int con = 0;
        int tmp = 0;
        for(int i = 1; i < 8; i++) {
            if(c[i] > 0) {
                tmp = i;
                i = find(c, i);
                if(i > -1)  con++;
                if(i < 0) i = tmp + 1;
            }
        }
        return con;
    }

    static int find(int[] c, int idx) {
        if(c[idx] > 0 && c[idx+1] > 0 && c[idx+2] > 0) {
            c[idx]--;
            c[idx+1]--;
            c[idx+2]--;
        } else {
            return -1;
        }
        return idx-1;
    }
}