import java.util.Scanner;
public class SUSTechRatio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int a,b,min;
            if (m<n){
                min = m;
            }else{
                min = n;
            }
            for (;min>=1;min--){
                if (m % min == 0 && n % min == 0){
                    break;
                }
            }
            a=m/min;
            b=n/min;
            System.out.println(a+" "+b);
    }
}
