import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person implements CourseOperator {
    private Location preferLocation;

    public Location getPreferLocation() {
        return preferLocation;
    }

    public void setPreferLocation(Location preferLocation) {
        this.preferLocation = preferLocation;
    }

    public Teacher() {
    }

    public Teacher(Location preferLocation) {
        this.preferLocation = preferLocation;
    }

    public Teacher(String id, String name) {
        super(id, name);
    }

    public List<Classroom> getFreeClassroom(CourseTime time, int capacity, CourseType type) {
        List<Classroom> classrooms = new ArrayList<>();
        if (preferLocation.equals(Location.LycheePark)) {
            for (int i = 0; i <= 5; i++) {
                for (Classroom classroom : Db.buildings.get(i).getRooms()) {
                    if (!classroom.getSchedule().containsKey(time) && classroom.seatNum >= capacity && classroom.type.equals(type)) {
                        classrooms.add(classroom);
                    }
                }
            }
            if (classrooms.size() == 0) {
                for (int i = 6; i <= 7; i++) {
                    for (Classroom classroom : Db.buildings.get(i).getRooms()) {
                        if (!classroom.getSchedule().containsKey(time) && classroom.seatNum >= capacity && classroom.type.equals(type)) {
                            classrooms.add(classroom);
                        }
                    }
                }
            }
        }
        else if (preferLocation.equals(Location.TeachingBuilding)) {
            for (int i = 6; i <= 7; i++) {
                for (Classroom classroom : Db.buildings.get(i).getRooms()) {
                    if (!classroom.getSchedule().containsKey(time) && classroom.seatNum >= capacity && classroom.type.equals(type)) {
                        classrooms.add(classroom);
                    }
                }
            }
            if (classrooms.size() == 0) {
                for (int i = 0; i <= 5; i++) {
                    for (Classroom classroom : Db.buildings.get(i).getRooms()) {
                        if (!classroom.getSchedule().containsKey(time) && classroom.seatNum >= capacity && classroom.type.equals(type)) {
                            classrooms.add(classroom);
                        }
                    }
                }
            }
        }
        return classrooms;
    }


    boolean createCourse(Course course) {
        if (this.schedule.containsKey(course.time)) {
            return false;
        }
        if (!course.room.schedule.containsKey(course.time) && course.room.seatNum >= course.capacity && course.room.type.equals(course.type)) {
            this.schedule.put(course.time, course);
            course.room.schedule.put(course.time, course);
            return true;
        }
        return false;
    }


    boolean createCourse(String code, String name, String abbrevName, CourseTime time, Classroom room, int capacity, CourseType type) {
        Course course = new Course(code, name, abbrevName, this, capacity, type, time, room);
        if (this.schedule.containsValue(course)) {
            return false;
        }
        if (!course.room.schedule.containsKey(course.time) && course.room.seatNum >= course.capacity && course.room.type.equals(course.type)) {
            this.schedule.put(course.time, course);
            course.room.schedule.put(course.time, course);
            return true;
        }
        return false;
    }


    public boolean dropCourse(Course course) {
        Course c = schedule.get(course.time);
        if (this.schedule.containsKey(course.time)) {
            schedule.remove(course.time, c);
            course.room.schedule.remove(course.time, c);
            return true;
        }
        return false;
    }

    public boolean changeCourse(Course oldCourse1, Course newCourse2) {
        if (oldCourse1.code.equals(newCourse2.code) && oldCourse1.type.equals(newCourse2.type) && oldCourse1.teacher.equals(newCourse2.teacher)) {
            if (!newCourse2.room.schedule.containsKey(newCourse2.time) && !newCourse2.teacher.schedule.containsKey(newCourse2.time)) {
                oldCourse1.room.schedule.remove(oldCourse1.time, oldCourse1);
                oldCourse1.teacher.schedule.remove(oldCourse1.time, oldCourse1);
                newCourse2.room.schedule.put(newCourse2.time, newCourse2);
                newCourse2.teacher.schedule.put(newCourse2.time, newCourse2);
                return true;
            }
        }
        return false;
    }

    public String printSchedule() {
        String a = this.name + "'s Schedule\n";
        for (Day day : Day.values()) {
            a += day.toString() + "\n";
            for (int time = 1; time <= 5; time++) {
                a = a + time + " ";
                CourseTime c = new CourseTime(day, time);
                for (CourseTime courseTime : schedule.keySet()) {
                    if (courseTime.equals(c)) {
                        a = a + schedule.get(courseTime).code + ", " + schedule.get(courseTime).abbrevName + ", " + schedule.get(courseTime).room.toString();
                        break;
                    }
                }
                a += "\n";
            }
        }
        return a;
    }


    public int getScheduleCourseNum() {
        int num = 0;
        for (CourseTime courseTime : schedule.keySet()) {
            num++;
        }
        return num;
    }
}
