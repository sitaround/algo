package SWEA.D4;
import java.io.*;

public class Solution5672 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int N;
        String[] name;
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#"+test_case+" ");
            N = Integer.parseInt(br.readLine().trim());
            name = new String[N];
            for(int i = 0; i < N; i++){
                name[i] = br.readLine().trim();
            }
            bw.write(solve(name, N)+"\n");
        }
        bw.flush();
    }
    static String solve(String[] arr, int N){
        String answer = "";
        int front = 0, end = N-1;
        int f_tmp, e_tmp;
        boolean same;
        while(front <= end){
            if(arr[front].compareTo(arr[end]) < 0){
                answer += arr[front++];
            }
            if(arr[front].compareTo(arr[end]) > 0){
                answer += arr[end--];
            }
            if(front == end){
                answer += arr[front++];   
            }
            if(arr[front].equals(arr[end])){
                f_tmp = front + 1;
                e_tmp = end - 1;
                same = false;
                while(true){
                    if(!arr[f_tmp].equals(arr[e_tmp])){
                        break;
                    }else {
                        if(f_tmp + 1 <= e_tmp - 1){
                            f_tmp++;
                            e_tmp--;
                        }else{
                            same = true;
                            break;
                        }
                    }
                }
                if(!same){
                    if(arr[f_tmp].compareTo(arr[e_tmp]) < 0){
                        answer += arr[front++];
                    }else{
                        answer += arr[end--];
                    }
                }else{
                    answer += arr[front++];
                }
            }
        }
        return answer;
    }
}