public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        Teacher teacher = new Teacher();
        CourseTime courseTime = new CourseTime(Day.Friday,1);
        Classroom room = new Classroom(101 , 200 , building , CourseType.Lecture);
        Course course = new Course("0","1","a",teacher,100,CourseType.Lecture,courseTime,room);
        teacher.createCourse(course);
        System.out.println(Course.idCnt);
        System.out.println(course.id);
    }
}
