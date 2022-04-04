import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Classroom{
    int id;
    int seatNum;
    CourseType type;
    Building building = new Building();
    Map<CourseTime, Course> schedule = new HashMap<>();
    public Classroom(){
    }
    public Classroom( int id , int seatNum , Building building, CourseType type ){
        this.id = id;
        this.seatNum = seatNum;
        this.building = building;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Map<CourseTime, Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<CourseTime, Course> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return type+"R"+id+"("+seatNum+")"+building.toString();
    }
    public String addCourse(Course course) {
        if (schedule.containsKey(course.time)){
            return "ERROR: Another course already exists at the time.";
        }
        if (!type.equals(course.type)){
            return "ERROR: Course type not same as classroom.";
        }
        if (course.capacity > seatNum){
            return "ERROR: Not enough seats in the classroom for this course.";
        }
        schedule.put(course.time,course);
        return "OK: Adding course to classroom success.";
    }

    public boolean deleteCourse(Course course){
        if (schedule.containsKey(course.time)){
            schedule.remove(course.time,course);
            return true;
        }
        return false;
    }

    public Course getCourse(CourseTime courseTime){
        if (schedule.containsKey(courseTime)){
            return schedule.get(courseTime);
        }
        return null;
    }

    public String printSchedule(){
        String a = this.toString() + " Schedule\n";
        for (Day day : Day.values()){
            a += day.toString() + "\n";
            for (int time = 1; time<=5; time++){
                a = a + time + " ";
                CourseTime c = new CourseTime(day,time);
                for (CourseTime courseTime : schedule.keySet()){
                    if (courseTime.equals(c)){
                        a = a + schedule.get(courseTime).code + ", " + schedule.get(courseTime).abbrevName + ", " + schedule.get(courseTime).teacher.name;
                        break;
                    }
                }
                a += "\n";
            }
        }
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id && seatNum == classroom.seatNum && type == classroom.type && Objects.equals(building, classroom.building) && Objects.equals(schedule, classroom.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatNum, type, building, schedule);
    }

    public int getScheduleCourseNum(){
        int num = 0;
        for (CourseTime courseTime : schedule.keySet()){
            num ++;
        }
        return num;
    }
}