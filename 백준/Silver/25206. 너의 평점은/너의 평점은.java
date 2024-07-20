import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static double ret, total;
    static double score;
    static double grade;
    static class a{
        public double score;
        public String grade;
    }
    static a[] ar = new a[20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 20; i++){
            ar[i] = new a();
        }

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            ar[i].score = Double.parseDouble(st.nextToken());
            ar[i].grade = st.nextToken();
        }

        for (int i = 0; i < 20; i++) {
            if(ar[i].grade.equals("P")) continue;
            score = ar[i].score;
            total += score;
            grade = chcekGrade(ar[i].grade);
            ret += score * grade;
        }
        System.out.println(ret/total);
        br.close();
    }
    static double chcekGrade(String s){
        double ret = 0;
        switch (s){
            case "A+" : ret = 4.5; break;
            case "A0" : ret = 4.0; break;
            case "B+" : ret = 3.5; break;
            case "B0" : ret = 3.0; break;
            case "C+" : ret = 2.5; break;
            case "C0" : ret = 2.0; break;
            case "D+" : ret = 1.5; break;
            case "D0" : ret = 1.0; break;
            case "F" : ret = 0; break;
            default: break;
        }
        return ret;
    }
}
