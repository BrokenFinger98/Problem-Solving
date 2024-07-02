import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        char result;

        if(A == 1){
            if(B == 2){
                result = 'B';
            }else{
                result = 'A';
            }
        }else if(A == 2){
            if(B == 1){
                result = 'A';
            }else{
                result = 'B';
            }
        }else{
            if(B == 1){
                result = 'B';
            }else{
                result = 'A';
            }
        }
        System.out.println(result);
    }
}
