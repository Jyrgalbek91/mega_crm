import model.Course;
import model.CourseFormat;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.setId(1);
        course.setName("Java");
        course.setPrice(15000);

        CourseFormat courseFormat = new CourseFormat();
        courseFormat.setId(1);
        courseFormat.setOnline(true);
        courseFormat.setFormat("Bootcamp");
        courseFormat.setLessonCountPerWeek(5);
        courseFormat.setDurationInWeek(18);
        courseFormat.setLessonDuration(3);

        course.setCourseFormat(courseFormat);

        System.out.println(course);
    }
}