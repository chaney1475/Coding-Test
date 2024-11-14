import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=1;i<=5;i++) {
            String s = br.readLine();
            if(s.contains("FBI")) {
                sb.append(i + " ");
                flag = false;
            }
        }
        
        if(flag) {
            System.out.println("HE GOT AWAY!");
        }else {
            System.out.println(sb);
        }
    }
}