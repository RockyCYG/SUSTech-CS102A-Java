import java.util.*;

public class MagicStrings {
    private int[] priority = new int[26];
    private String[] ss;
    public MagicStrings(String s){
        priority = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        this.setSs(s);
    }
    public MagicStrings(int[] priority, String s){
        this.setPriority(priority);
        this.setSs(s);
    }
    public MagicStrings(String priority, String s){
        this.setPriority(priority);
        this.setSs(s);
    }
    public void setPriority(int[] priority){
        for (int i = 0;i<this.priority.length;i++){
            this.priority[i] = priority[i];
        }
    }
    public void setPriority(String priority){
        String[] a;
        a = priority.split(" ");
        for (int i = 0;i<a.length;i++){
            this.priority[i] = Integer.parseInt(a[i]);
        }
    }
    public void setPriority(char c, int priority){
        if (c>='A' && c<='Z'){
            c+=32;
        }
        this.priority[c-'a'] = priority;
    }
    public void setSs(String input){
        for (int i = 0;i<input.length();i++){
                if ((input.charAt(i) < 'A' || (input.charAt(i) > 'Z' && input.charAt(i) < 'a') || input.charAt(i) > 'z') && input.charAt(i) != ' ') {
                    input = input.replace(input.charAt(i), ',');
                }
        }
        input = input.replaceAll(",","");
        ss = input.split("\\s+");
    }
    public int stringNum(){
        if (ss == null){
            return 0;
        }else{
            return ss.length;
        }
    }
    public int compareString(String a, String b) {
        String a1 = a.toLowerCase(Locale.ROOT);
        String b1 = b.toLowerCase(Locale.ROOT);
        if (a1.length() == b1.length()) {
            for (int i = 0; i < a1.length(); i++) {
                    if (priority[a1.charAt(i) - 'a'] > priority[b1.charAt(i) - 'a']) {
                        return 1;
                    } else if (priority[a1.charAt(i) - 'a'] < priority[b1.charAt(i) - 'a']) {
                        return -1;
                    }
                }
            return 0;
        }
        if (a1.length() > b1.length()) {
            for (int i = 0; i < b1.length(); i++) {
                if (priority[a1.charAt(i) - 'a'] > priority[b1.charAt(i) - 'a']) {
                    return 1;
                } else if (priority[a1.charAt(i) - 'a'] < priority[b1.charAt(i) - 'a']) {
                    return -1;
                }
            }
            return 1;
        }
        for (int i = 0; i < a1.length(); i++) {
                if (priority[a1.charAt(i) - 'a'] > priority[b1.charAt(i) - 'a']) {
                    return 1;
                } else if (priority[a1.charAt(i) - 'a'] < priority[b1.charAt(i) - 'a']) {
                    return -1;
                }
            }
            return -1;
    }
    public void sortSs(){
        String temp;
        int x;
        for (int i = 0;i<ss.length;i++){
            for (int j = ss.length - 1 ;j>i;j--){
                x = compareString(ss[j-1],ss[j]);
                if (x == -1){
                    temp = ss[j];
                    ss[j] = ss[j-1];
                    ss[j-1] = temp;
                }
            }
        }
    }
    public String getStrings(){
        String getStrings = "";
        for (int i = 0;i<ss.length;i++){
            getStrings = getStrings + ss[i] + " ";
        }
        return getStrings.trim();
}
}
