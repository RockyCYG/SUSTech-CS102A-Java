import java.util.Scanner;
public class Eat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h1 = scan.nextInt();
        int m1 = scan.nextInt();
        int s1 = scan.nextInt();
        int h2 = scan.nextInt();
        int m2 = scan.nextInt();
        int s2 = scan.nextInt();
        int dh = h2-h1;
        int dm = m2-m1;
        int ds = s2-s1;
        int dMinute,dSecond;
        if (ds>=0) {
            dMinute = dh * 60 + dm;
            dSecond = ds;
        }else{
            dMinute = dh * 60 + dm - 1;
            dSecond = 60+ds;
        }
        if (dMinute == 0 && dSecond == 0){
            System.out.println("0s");
        }else if(dMinute == 0 && dSecond != 0 ){
            System.out.println(dSecond + "s");
        }else if (dMinute != 0 && dSecond == 0){
            System.out.println(dMinute + "m");
        }else{
            System.out.println(dMinute + "m" + dSecond + "s");
        }
    }
}
