import java.util.Scanner;
public class Customer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String user = scan.next();
        double [][] arr = new double[num][2];
        double sum = 0.0;
        for (int i = 0;i<arr.length;i++){
            arr[i][0] = scan.nextDouble();
            arr[i][1] = scan.nextDouble();
            sum = sum + arr[i][0] * arr[i][1];
        }
        if (user.equals("Diamond")){
            System.out.println(String.format("%.1f",sum*0.7));
        }else if (user.equals("Gold")){
            System.out.println(String.format("%.1f",sum*0.8));
        }else if (user.equals("Silver")){
            System.out.println(String.format("%.1f",sum*0.9));
        }else if (user.equals("Ordinary")){
            System.out.println(String.format("%.1f",sum));
        }
    }
}
