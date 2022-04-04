import java.util.Scanner;
public class WhichRestaurant {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] array = new int[num];
        int a = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++) {
            int length = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j-1]>array[j]){
                    break;
                }else {
                    length++;
                    if (length>=a){
                        x=i;
                        y=j;
                        a=length;
                    }
                }
            }
        }
        for (int i = x;i<=y;i++) {
            System.out.print(array[i] + " ");
        }
    }
}