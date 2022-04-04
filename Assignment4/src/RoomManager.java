import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RoomManager {
    private static ArrayList<Room> roomInfoLynn = new ArrayList<>();
    private static ArrayList<Room> roomInfoYidan = new ArrayList<>();
    private static ArrayList<Room> roomInfoLearningNexus = new ArrayList<>();
    public static boolean addRoom (String rid, Library location, int capacity) {
        boolean isFlag = false;
        Room r = new Room(rid, location, capacity);
        if (location.equals(Library.Lynn)) {
            if (roomInfoLynn.size() == 0) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        roomInfoLynn.add(r);
                        isFlag = true;
                    }
                }
            } else if (roomInfoLynn.size() >= 1) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        for (int i = 0; i < roomInfoLynn.size(); i++) {
                            if (roomInfoLynn.get(i).getRid().equals(rid)) {
                                break;
                            } else {
                                if (i < roomInfoLynn.size() - 1) {
                                    continue;
                                } else if (i == roomInfoLynn.size() - 1) {
                                    roomInfoLynn.add(r);
                                    isFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (location.equals(Library.Yidan)) {
            if (roomInfoYidan.size() == 0) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        roomInfoYidan.add(r);
                        isFlag = true;
                    }
                }
            } else if (roomInfoYidan.size() >= 1) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        for (int i = 0; i < roomInfoYidan.size(); i++) {
                            if (roomInfoYidan.get(i).getRid().equals(rid)) {
                                break;
                            } else {
                                if (i < roomInfoYidan.size() - 1) {
                                    continue;
                                } else if (i == roomInfoYidan.size() - 1) {
                                    roomInfoYidan.add(r);
                                    isFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (location.equals(Library.LearningNexus)) {
            if (roomInfoLearningNexus.size() == 0) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        roomInfoLearningNexus.add(r);
                        isFlag = true;
                    }
                }
            } else if (roomInfoLearningNexus.size() >= 1) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        for (int i = 0; i < roomInfoLearningNexus.size(); i++) {
                            if (roomInfoLearningNexus.get(i).getRid().equals(rid)) {
                                break;
                            } else {
                                if (i < roomInfoLearningNexus.size() - 1) {
                                    continue;
                                } else if (i == roomInfoLearningNexus.size() - 1) {
                                    roomInfoLearningNexus.add(r);
                                    isFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return isFlag;
    }






    public static boolean addRoom (String rid, Library location, int capacity, boolean hasDisplay, boolean hasWhiteboard){
        boolean isFlag = false;
        Room r = new Room(rid, location, capacity,hasDisplay,hasWhiteboard);
        if (location.equals(Library.Lynn)) {
            if (roomInfoLynn.size() == 0) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        roomInfoLynn.add(r);
                        isFlag = true;
                    }
                }
            } else if (roomInfoLynn.size() >= 1) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        for (int i = 0; i < roomInfoLynn.size(); i++) {
                            if (roomInfoLynn.get(i).getRid().equals(rid)) {
                                break;
                            } else {
                                if (i < roomInfoLynn.size() - 1) {
                                    continue;
                                } else if (i == roomInfoLynn.size() - 1) {
                                    roomInfoLynn.add(r);
                                    isFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (location.equals(Library.Yidan)) {
            if (roomInfoYidan.size() == 0) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        roomInfoYidan.add(r);
                        isFlag = true;
                    }
                }
            } else if (roomInfoYidan.size() >= 1) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        for (int i = 0; i < roomInfoYidan.size(); i++) {
                            if (roomInfoYidan.get(i).getRid().equals(rid)) {
                                break;
                            } else {
                                if (i < roomInfoYidan.size() - 1) {
                                    continue;
                                } else if (i == roomInfoYidan.size() - 1) {
                                    roomInfoYidan.add(r);
                                    isFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (location.equals(Library.LearningNexus)) {
            if (roomInfoLearningNexus.size() == 0) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        roomInfoLearningNexus.add(r);
                        isFlag = true;
                    }
                }
            } else if (roomInfoLearningNexus.size() >= 1) {
                if (rid.length() == 4) {
                    if (rid.charAt(0) == 'R' && rid.charAt(1) >= '1' && rid.charAt(1) <= '9' && rid.charAt(2) >= '0' && rid.charAt(2) <= '9' && rid.charAt(3) >= '0' && rid.charAt(3) <= '9' && capacity >= 1) {
                        for (int i = 0; i < roomInfoLearningNexus.size(); i++) {
                            if (roomInfoLearningNexus.get(i).getRid().equals(rid)) {
                                break;
                            } else {
                                if (i < roomInfoLearningNexus.size() - 1) {
                                    continue;
                                } else if (i == roomInfoLearningNexus.size() - 1) {
                                    roomInfoLearningNexus.add(r);
                                    isFlag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return isFlag;
    }





    public static boolean orderRoom (Library location, String rid, String SID, int start, int end, int numberOfTeammates){
        boolean isFlag = false;
        if (location.equals(Library.Lynn)){
            for(int i = 0;i < roomInfoLynn.size();i++){
                if (Arrays.asList(roomInfoLynn.get(i).getApplicants()).contains(SID)){
                    return false;
                }
            }
            for (int i = 0; i < roomInfoLynn.size(); i++) {
                if (roomInfoLynn.get(i).getRid().equals(rid)) {
                    if (roomInfoLynn.get(i).setApplicant(start, end, SID, numberOfTeammates)) {
                        isFlag = true;
                    }
                }
            }
        }
        if (location.equals(Library.Yidan)){
            for(int i = 0;i < roomInfoYidan.size();i++){
                if (Arrays.asList(roomInfoYidan.get(i).getApplicants()).contains(SID)){
                    return false;
                }
            }
            for (int i = 0; i < roomInfoYidan.size(); i++) {
                if (roomInfoYidan.get(i).getRid().equals(rid)) {
                    if (roomInfoYidan.get(i).setApplicant(start, end, SID, numberOfTeammates)) {
                        isFlag = true;
                    }
                }
            }
        }
        if (location.equals(Library.LearningNexus)){
            for(int i = 0;i < roomInfoLearningNexus.size();i++){
                if (Arrays.asList(roomInfoLearningNexus.get(i).getApplicants()).contains(SID)){
                    return false;
                }
            }
            for (int i = 0; i < roomInfoLearningNexus.size(); i++) {
                if (roomInfoLearningNexus.get(i).getRid().equals(rid)) {
                    if (roomInfoLearningNexus.get(i).setApplicant(start, end, SID, numberOfTeammates)) {
                        isFlag = true;
                    }
                }
            }
        }
        return isFlag;
    }







    public static boolean cancelOrder (String SID){
        boolean isFlag = false;
        for (int i = 0;i<roomInfoLynn.size();i++){
            if (Arrays.asList(roomInfoLynn.get(i).getApplicants()).contains(SID)){
                roomInfoLynn.get(i).removeApplicant(SID);
                isFlag = true;
            }else{
            }
        }
        for (int i = 0;i<roomInfoYidan.size();i++){
            if (Arrays.asList(roomInfoYidan.get(i).getApplicants()).contains(SID)){
                roomInfoYidan.get(i).removeApplicant(SID);
                isFlag = true;
            }else{
            }
        }
        for (int i = 0;i<roomInfoLearningNexus.size();i++){
            if (Arrays.asList(roomInfoLearningNexus.get(i).getApplicants()).contains(SID)){
                roomInfoLearningNexus.get(i).removeApplicant(SID);
                isFlag = true;
            }else{
            }
        }
        return isFlag;
    }


    public static boolean cancelOrder (String SID, Library location){
        boolean isFlag = false;
        if (location.equals(Library.Lynn)) {
            for (int i = 0; i < roomInfoLynn.size(); i++) {
                if (Arrays.asList(roomInfoLynn.get(i).getApplicants()).contains(SID)) {
                    roomInfoLynn.get(i).removeApplicant(SID);
                    isFlag = true;
                } else {
                }
            }
        }else if (location.equals(Library.Yidan)) {
            for (int i = 0; i < roomInfoYidan.size(); i++) {
                if (Arrays.asList(roomInfoYidan.get(i).getApplicants()).contains(SID)) {
                    roomInfoYidan.get(i).removeApplicant(SID);
                    isFlag = true;
                } else {
                }
            }
        }else if (location.equals(Library.LearningNexus)) {
            for (int i = 0; i < roomInfoLearningNexus.size(); i++) {
                if (Arrays.asList(roomInfoLearningNexus.get(i).getApplicants()).contains(SID)) {
                    roomInfoLearningNexus.get(i).removeApplicant(SID);
                    isFlag = true;
                } else {
                }
            }
        }
        return isFlag;
    }



    public static ArrayList<Room> searchRoom (Library location, int start, int end, boolean needDisplay, boolean needWhiteboard) {
        String rid;
        ArrayList<Room> RoomList = new ArrayList<>();
        if (needDisplay) {
            if (needWhiteboard) {
                if (location.equals(Library.Lynn)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLynn.size(); j++) {
                            if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end) && roomInfoLynn.get(j).getHasDisplay() && roomInfoLynn.get(j).getHasWhiteboard()) {
                                RoomList.add(roomInfoLynn.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.Yidan)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoYidan.size(); j++) {
                            if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end) && roomInfoYidan.get(j).getHasDisplay() && roomInfoYidan.get(j).getHasWhiteboard()) {
                                RoomList.add(roomInfoYidan.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.LearningNexus)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                            if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end) && roomInfoLearningNexus.get(j).getHasDisplay() && roomInfoLearningNexus.get(j).getHasWhiteboard()) {
                                RoomList.add(roomInfoLearningNexus.get(j));
                            }
                        }
                    }
                }
            } else {
                if (location.equals(Library.Lynn)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLynn.size(); j++) {
                            if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end) && roomInfoLynn.get(j).getHasDisplay()) {
                                RoomList.add(roomInfoLynn.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.Yidan)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoYidan.size(); j++) {
                            if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end) && roomInfoYidan.get(j).getHasDisplay()) {
                                RoomList.add(roomInfoYidan.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.LearningNexus)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                            if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end) && roomInfoLearningNexus.get(j).getHasDisplay()) {
                                RoomList.add(roomInfoLearningNexus.get(j));
                            }
                        }
                    }
                }
            }
        } else {
            if (needWhiteboard) {
                if (location.equals(Library.Lynn)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLynn.size(); j++) {
                            if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end) && roomInfoLynn.get(j).getHasWhiteboard()) {
                                RoomList.add(roomInfoLynn.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.Yidan)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoYidan.size(); j++) {
                            if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end) && roomInfoYidan.get(j).getHasWhiteboard()) {
                                RoomList.add(roomInfoYidan.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.LearningNexus)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                            if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end) && roomInfoLearningNexus.get(j).getHasWhiteboard()) {
                                RoomList.add(roomInfoLearningNexus.get(j));
                            }
                        }
                    }
                }
            } else {
                if (location.equals(Library.Lynn)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLynn.size(); j++) {
                            if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end)) {
                                RoomList.add(roomInfoLynn.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.Yidan)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoYidan.size(); j++) {
                            if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end)) {
                                RoomList.add(roomInfoYidan.get(j));
                            }
                        }
                    }
                } else if (location.equals(Library.LearningNexus)) {
                    for (int i = 100; i < 1000; i++) {
                        rid = "R";
                        rid += i;
                        for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                            if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end)) {
                                RoomList.add(roomInfoLearningNexus.get(j));
                            }
                        }
                    }
                }
            }
        }
        return RoomList;
    }


        public static ArrayList<Room> searchRoom ( int start, int end){
            String rid;
            ArrayList<Room> RoomList = new ArrayList<>();
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoYidan.size(); j++) {
                    if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoYidan.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLynn.size(); j++) {
                    if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLynn.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                    if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLearningNexus.get(j));
                    }
                }
            }
            return RoomList;
        }








        public static ArrayList<Room> searchRoom (int start, int end, Landmark landmark){
        String rid;
        ArrayList<Room> RoomList = new ArrayList<>();
        if (landmark.equals(Landmark.TeachingBuilding) || landmark.equals(Landmark.SUSTechCenter)){
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoYidan.size(); j++) {
                    if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoYidan.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLynn.size(); j++) {
                    if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLynn.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                    if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLearningNexus.get(j));
                    }
                }
            }
        }
        else if (landmark.equals(Landmark.ResearchBuilding) || landmark.equals(Landmark.TaizhouFloor) || landmark.equals(Landmark.AdministrativeBuilding)){
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLynn.size(); j++) {
                    if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLynn.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoYidan.size(); j++) {
                    if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoYidan.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                    if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLearningNexus.get(j));
                    }
                }
            }
        }
        else if (landmark.equals(Landmark.Dormitory)){
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                    if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLearningNexus.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoYidan.size(); j++) {
                    if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoYidan.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLynn.size(); j++) {
                    if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLynn.get(j));
                    }
                }
            }
        }
        else if (landmark.equals(Landmark.Playground)){
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoYidan.size(); j++) {
                    if (roomInfoYidan.get(j).getRid().equals(rid) && roomInfoYidan.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoYidan.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLearningNexus.size(); j++) {
                    if (roomInfoLearningNexus.get(j).getRid().equals(rid) && roomInfoLearningNexus.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLearningNexus.get(j));
                    }
                }
            }
            for (int i = 100; i < 1000; i++) {
                rid = "R";
                rid += i;
                for (int j = 0; j < roomInfoLynn.size(); j++) {
                    if (roomInfoLynn.get(j).getRid().equals(rid) && roomInfoLynn.get(j).setApplicant(start, end)) {
                        RoomList.add(roomInfoLynn.get(j));
                    }
                }
            }
        }
        return RoomList;
    }


    public static String showOrder (ArrayList<Room> list){
        String s = "";
        if (list.size() == 0){
            s = "No room to show.";
        }else{
            for (Room r : list){
                s += r;
            }
        }
        return s;
    }
}
