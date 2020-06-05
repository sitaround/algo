package SWEA.D3;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution9280 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int answer;
        int n, m;
        int[] r, w;
        Queue<Integer> car;
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            String[] parse = br.readLine().trim().split(" ");
            n = Integer.parseInt(parse[0]);
            m = Integer.parseInt(parse[1]);
            r = new int[n];
            w = new int[m+1];
            car = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(br.readLine().trim());
            }
            for(int i = 1; i <= m; i++) {
                w[i] = Integer.parseInt(br.readLine().trim());
            }
            for(int i = 0; i < 2*m; i++) {
                car.add(Integer.parseInt(br.readLine().trim()));
            }
            answer = solve(n, r, m, w, car);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int n, int[] r, int m, int[] w, Queue<Integer> c) {
        int ans = 0;
        int tmp;
        PriorityQueue<Integer> parking = new PriorityQueue<>();
        Queue<Integer> wait = new LinkedList<>();
        int[] no = new int[m+1];
        for(int i = 0; i < n; i++) {
            parking.add(i);
        }
        while(!c.isEmpty()) {
            if(parking.isEmpty()) {
                while(true) {
                    tmp = c.poll();
                    if(tmp > 0) wait.add(tmp);
                    else {
                        parking.add(no[-tmp]);
                        break;
                    }
                }
            }
            if(!wait.isEmpty()) tmp = wait.poll();
            else                tmp = c.poll();
            if(tmp < 0) {
                parking.add(no[-tmp]);
                continue;
            }
            if(!parking.isEmpty()) {
                no[tmp] = parking.poll();
                ans += w[tmp] * r[no[tmp]];
            }
        }
        return ans;
    }
}