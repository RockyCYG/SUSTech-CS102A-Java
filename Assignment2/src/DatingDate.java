import java.util.Scanner;
public class DatingDate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int date1 = scan.nextInt();
        int date2 = scan.nextInt();
        int year1 = date1/10000;
        int year2 = date2/10000;
        int month,day,date;
        int sum = 0;
        int[] d = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i = year1;i<=year2;i++){
            month = i%10*10+i%100/10;
            day = i/100%10*10+i/100/10;
            date = i*10000+month*100+day;
            if ((i%4 == 0 && i%100 != 0) || i%400 == 0){
                d[1] = 29;
            }else{
                d[1] = 28;
            }
            if (month>=1 && month<=12 && day>=1 && day<=d[month-1] && date>=date1 && date<=date2){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
