package SWEA.D3;


import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution2930 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int n, cnt;
        PriorityQueue<Integer> heap;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            n = Integer.parseInt(br.readLine().trim());
            heap = new PriorityQueue<>(Collections.reverseOrder());
            cnt = 0;
            //우선순위 큐에서 원래 우선순위는 오름차순으로 되어있으나, 
            //Collections.reverseOrder를 사용하면 내림차순으로 우선순위가 변함.
            for(int i = 0; i < n; i++){
                String[] parse = br.readLine().trim().split(" ");
                if(Integer.parseInt(parse[0]) == 1){
                    heap.add(Integer.parseInt(parse[1]));
                    cnt++;
                } else {
                    if(cnt > 0){
                        bw.write(heap.poll() + " ");
                        cnt--;
                    }else{
                        bw.write(-1 + " ");
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}