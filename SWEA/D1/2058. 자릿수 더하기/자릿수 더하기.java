import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int ret = 0;
        for(int i = A; i > 0; i /= 10){
            ret += i%10;
        }
        System.out.println(ret);
    }
}
