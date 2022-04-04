import java.util.*;
public class GitMerge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[m];
        int s = 0;
        int t = 0;
        for (int i = 0;i<array1.length;i++){
            array1[i] = scan.nextInt();
        }
        for (int j = 0;j<array2.length;j++){
            array2[j] = scan.nextInt();
        }
        for (int a = 0;a<array1.length;a++){
            for (int b = t;b<array2.length;b++){
                if (array1[a] == array2[b]){
                    t = b;
                    s++;
                    break;
                }
                }
            }
        if (s == n){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        }
    }
