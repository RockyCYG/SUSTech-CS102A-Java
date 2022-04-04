import java.util.Scanner;
public class CS301 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num1 = scan.next();
        String num2 = scan.next();
        int l1 = num1.length();
        int l2 = num2.length();
        int max,min;
        if (l1>=l2){
           max = l1;
           min = l2;
        }else{
           max = l2;
           min = l1;
        }
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int[] array3 = new int[max+1];
        for (int i = 0;i<min;i++){
            array3[max-i] = (array1[l1-i-1]-'0') + (array2[l2-i-1]-'0');
        }
        if (l1>l2) {
            for (int i = min; i < max; i++) {
                array3[max-i] = array1[l1-i-1]-'0';
            }
        }else if(l1<l2){
            for (int i = min;i<max;i++){
                array3[max-i] = array2[l2-i-1]-'0';
            }
        }
        for (int i = 0;i<max+1;i++) {
            if (array3[max - i] >= 2) {
                array3[max - i] = array3[max - i] % 2;
                array3[max - i - 1]++;
            }
        }
        if (array3[0] == 0){
        for (int i = 1;i<max+1;i++) {
            System.out.print(array3[i]);
        }
        }else{
            for (int i = 0;i<max+1;i++){
                System.out.print(array3[i]);
            }
        }
    }
}


