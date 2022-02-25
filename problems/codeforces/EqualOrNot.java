package problems.codeforces;

import java.util.Scanner;

public class EqualOrNot {
    public static boolean equalOrNotCode(String s){
        int count = 0;
        for(char i : s.toCharArray()){
            if(i == 'n' || i == 'N'){
                count++;
            }
        }
        if(count == 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        String info = "";
        for(int i = 0; i<t; i++){
            info = sc.next();
            if(equalOrNotCode(info)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

        sc.close();
    }
}