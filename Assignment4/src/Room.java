import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String rid;
    private Library location = Library.Lynn;
    private int capacity = 3;
    private boolean hasDisplay = true;
    private boolean hasWhiteboard = true;
    private String[] applicants = new String[14];
    public Room (String rid){
        this.rid = rid;
    }
    public Room (String rid, Library location, int capacity){
        this.rid = rid;
        this.location = location;
        this.capacity = capacity;
    }
    public Room (String rid, Library location, int capacity, boolean hasDisplay, boolean hasWhiteboard){
        this.rid = rid;
        this.location = location;
        this.capacity = capacity;
        this.hasDisplay = hasDisplay;
        this.hasWhiteboard = hasWhiteboard;
    }

    public String getRid(){
        return rid;
    }
    public String[] getApplicants(){
        return applicants;
    }
    public int getCapacity(){
        return capacity;
    }
    public boolean getHasDisplay(){
        return hasDisplay;
    }
    public boolean getHasWhiteboard(){
        return hasWhiteboard;
    }


    public String toString (){
        String a = location+" "+rid+", "+"capacity="+capacity+", "+"hasDisplay="+hasDisplay+", "+"hasWhiteboard="+hasWhiteboard+"\n";
        String b = "|08:00   |09:00   |10:00   |11:00   |12:00   |13:00   |14:00   |15:00   |16:00   |17:00   |18:00   |19:00   |20:00   |21:00   |\n";
        String c = "";
        for (int i = 0;i<applicants.length;i++) {
            if (i == 0) {
                if (applicants[i] == null) {
                    c += "|EMPTY   ";
                } else if (applicants[i].equals(applicants[i + 1])) {
                    c += "|" + applicants[i] + "         ";
                } else {
                    c += "|" + applicants[i];
                }
            }
            if (i >= 1 && i<applicants.length-1) {
                if (applicants[i] == null) {
                    c += "|EMPTY   ";
                } else {
                   if (applicants[i].equals(applicants[i - 1])) {
                        continue;
                    }
                   if (applicants[i].equals(applicants[i + 1])) {
                        c += "|" + applicants[i] + "         ";
                    }
                    else {
                        c += "|" + applicants[i];
                    }
                }
            }
            if (i == applicants.length-1){
                if (applicants[i] == null) {
                    c += "|EMPTY   ";
                } else {
                    if (applicants[i].equals(applicants[i - 1])) {
                        continue;
                    } else {
                        c += "|" + applicants[i];
                    }
                }
            }
        }
        c+="|\n";
        return(a+b+c);
    }

    public String toString (int start, int end) {
        String a = location + " " + rid + ", " + "capacity=" + capacity + ", " + "hasDisplay=" + hasDisplay + ", " + "hasWhiteboard=" + hasWhiteboard + "\n";
        String b = "";
        String c = "";
        if (start < end && start >= 8 && end>=9 && start <= 21 && end <= 22) {
            if (start == 8) {
                if (end == 9) {
                    b = "|08:00   ";
                } else {
                    b = "|08:00   |09:00   ";
                    for (int i = 10; i < end; i++) {
                        b = b + "|" + i + ":00   ";
                    }
                }
            } else if (start == 9) {
                b += "|09:00   ";
                for (int i = 10; i < end; i++) {
                    b = b + "|" + i + ":00   ";
                }
            } else {
                for (int i = start; i < end; i++) {
                    b = b + "|" + i + ":00   ";
                }
            }
            b += "|\n";


            if (end - start == 1) {
                if (applicants[start - 8] == null) {
                    c = "|EMPTY   ";
                } else {
                    c = "|" + applicants[start - 8];
                }
            }
            else if (end - start == 2) {
                if (applicants[start - 8] == null) {
                    if (applicants[end - 9] == null) {
                        c = "|EMPTY   |EMPTY   ";
                    } else {
                        c = "!EMPTY   |" + applicants[end - 9];
                    }
                } else {
                    if (applicants[end - 9] == null) {
                        c = "|"+applicants[start-8]+"|EMPTY   ";
                    }else if (applicants[start - 8].equals(applicants[end - 9])) {
                        c = "|" + applicants[start - 8] + "         ";
                    } else{
                        c = "|" + applicants[start - 8] + "|" + applicants[end - 9];
                    }
                }
            }
            else {
                for (int i = start - 8; i < end - 8; i++) {
                    if (i == start - 8) {
                        if (applicants[i] == null) {
                            c += "|EMPTY   ";
                        } else if (applicants[i].equals(applicants[i + 1])) {
                            c += "|" + applicants[i] + "         ";
                        } else {
                            c += "|" + applicants[i];
                        }
                    } else if (i > start - 8 && i < end - 9) {
                        if (applicants[i] == null) {
                            c += "|EMPTY   ";
                        } else if (applicants[i].equals(applicants[i + 1])) {
                            c += "|" + applicants[i] + "         ";
                        } else if (applicants[i].equals(applicants[i - 1])) {
                            continue;
                        } else {
                            c += "|" + applicants[i];
                        }
                    } else if (i == end - 9) {
                        if (applicants[i] == null) {
                            c += "|EMPTY   ";
                        } else if (applicants[i].equals(applicants[i - 1])) {
                            continue;
                        } else {
                            c += "|" + applicants[i];
                        }
                    }
                }
            }
                c += "|\n";
                return (a + b + c);
            }else{
                return null;
            }
        }

    public boolean setApplicant(int start, int end){
        boolean isFlag = true;
        for (int i = start - 8;i<end - 8;i++){
            if (applicants[i] == null){
            }else{
                isFlag = false;
            }
        }
        return isFlag;
    }



    public boolean setApplicant(int start, int end, String SID, int numberOfTeammates) {
        boolean isFlag = false;
        if (start < end && start >= 8 && end>=9 && start <= 21 && end <= 22 && end - start == 1) {
            if (numberOfTeammates + 1 >= 1 && numberOfTeammates + 1 <= capacity && applicants[start - 8] == null){
                if (Arrays.asList(applicants).contains(SID)){
                    isFlag = false;
                }else {
                    applicants[start - 8] = SID;
                    isFlag = true;
                }
            }
        }else if (start < end && start >= 8 && end>=9 && start <= 21 && end <= 22 && end - start == 2){
            if (numberOfTeammates + 1 >= 1 && numberOfTeammates + 1 <= capacity && applicants[start - 8] == null && applicants[start - 7] == null){
                if (Arrays.asList(applicants).contains(SID)) {
                   isFlag = false;
                }else{
                    applicants[start - 8] = SID;
                    applicants[start - 7] = SID;
                    isFlag = true;
                }
            }
        }
        return isFlag;
    }


    public boolean removeApplicant (String SID){
        boolean isFlag = false;
        if (SID != null) {
            for (int i = 0; i < applicants.length; i++) {
                if ((SID).equals(applicants[i])) {
                    applicants[i] = null;
                    isFlag = true;
                }
            }
        }
        return isFlag;
    }
}