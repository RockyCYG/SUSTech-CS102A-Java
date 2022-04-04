public class Student extends Person implements CourseOperator {
    public Student() {
    }

    public Student(String id, String name) {
        super(id, name);
    }

    public boolean courseExist(String code, String name, CourseType type) {
        for (Course course : schedule.values()) {
            if (course.code.equals(code) && course.name.equals(name) && course.type.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public boolean courseExist(Course course) {
        for (Course c : schedule.values()) {
            if (c.code.equals(course.code) && c.name.equals(course.name) && c.type.equals(course.type)) {
                return true;
            }
        }
        return false;
    }

    boolean chooseCourse(Course course) {
        if (schedule.containsKey(course.time)) {
            return false;
        }
        for (Course courses : schedule.values()) {
            if (courses.name.equals(course.name) && courses.code.equals(course.code) && courses.type.equals(course.type)) {
                return false;
            }
        }
        if (!schedule.containsKey(course.time) && course.students.size() < course.capacity) {
            schedule.put(course.time, course);
            course.students.add(this);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (this.schedule.containsKey(course.time)) {
            schedule.remove(course.time, course);
            course.students.remove(this);
            return true;
        }
        return false;
    }

    public boolean changeCourse(Course oldCourse1, Course newCourse2) {
        if (oldCourse1.code.equals(newCourse2.code) && oldCourse1.type.equals(newCourse2.type)) {
            if (newCourse2.students.size() < newCourse2.capacity) {
                schedule.remove(oldCourse1.time, oldCourse1);
                oldCourse1.students.remove(this);
                schedule.put(newCourse2.time, newCourse2);
                newCourse2.students.add(this);
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
                        a = a + schedule.get(courseTime).code + ", " + schedule.get(courseTime).abbrevName + ", " + schedule.get(courseTime).teacher.name + ", " + schedule.get(courseTime).room.toString();
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
