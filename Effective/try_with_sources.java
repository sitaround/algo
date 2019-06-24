package Effective;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class try_with_sources{
    public static void main(String[] args) {
        String input = "tt";
        System.out.println(input);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
                input = br.readLine();
                bw.write(input);
                bw.newLine();
                bw.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(input);  // flush로 인해 buffer가 날라간듯?
    }
}