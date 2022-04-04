import java.util.Scanner;
public class Vip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        if (T>=1) {
            int arr[] = new int[T];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
                sum += arr[i];
            }
            int temp = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (temp < arr[0]) {
                    temp = arr[i];
                }
            }
            if ((T >= 10 && sum >= 3000) || temp >= 5000) {
                System.out.println("Diamond");
            } else if ((T >= 5 && sum >= 2000) || temp >= 3000) {
                System.out.println("Gold");
            } else if ((T >= 3 && sum >= 1000) || temp >= 1500) {
                System.out.println("Silver");
            } else {
                System.out.println("Ordinary");
            }
        }else{
            System.out.println("Ordinary");
        }

    }
}
