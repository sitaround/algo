package SWEA.D3;

import java.io.*;

public class Solution5986 {
     
    static boolean[] primeNumber = new boolean[1000];
    static int[] findThreeNumber = new int[1000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int answer, odd;
        findPrimeNumber();
        findThreeNumbers();
 
        for(int test_case = 1; test_case <= T; test_case++) {
            bw.write("#"+test_case+" ");
            odd = Integer.parseInt(br.readLine());
            answer = findThreeNumber[odd];
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
     
    static void findPrimeNumber() {
        for(int i = 2; i*i < 1000; i++) {
            for(int j = i*2; j < 1000; j+=i) {
                primeNumber[j] = true;
            }
        }
    }
     
    static void findThreeNumbers() {
        for(int i = 2; i < 1000; i++) {
            if(primeNumber[i])  continue;
            for(int j = i; i+j < 1000; j++) {
                if(primeNumber[j])  continue;
                for(int k = j; i+j+k < 1000; k++) {
                    if(primeNumber[k])  continue;
                    findThreeNumber[i+j+k]++;
                }
            }
        }
    }
}