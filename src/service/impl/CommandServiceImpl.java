package service.impl;

import dao.CourseDao;
import dao.CourseFormatDao;
import dao.ManagerDao;
import dao.impl.CourseDaoImpl;
import dao.impl.CourseFormatDaoImpl;
import dao.impl.ManagerDaoImpl;
import enums.Format;
import model.Course;
import model.CourseFormat;
import model.Manager;
import service.CommandService;

import java.util.Arrays;

public class CommandServiceImpl implements CommandService {
    @Override
    public void run() {
        ManagerDao managerDao = new ManagerDaoImpl();
        Manager manager = new Manager();
        manager.setName("Jyrgal");
        manager.setSurname("Almazbekovekov");
        manager.setEmail("joni@gmail.com");
        manager.setPhone("996505555221");
        manager.setSalary(70000);

        CourseFormatDao courseFormatDao = new CourseFormatDaoImpl();
        CourseFormat courseFormat = new CourseFormat();
        courseFormat.setFormat(Format.ORDINARY);
        courseFormat.setLessonDuration(5);
        courseFormat.setDurationInWeek(36);
        courseFormat.setLessonCountPerWeek(3);
        courseFormat.setOnline(true);
//        courseFormatDao.save(courseFormat);


        CourseDao courseDao = new CourseDaoImpl();

        Course course = new Course();
        course.setName("c++");
        course.setPrice(15000);
//        courseDao.save(course);


//        MentorDao mentorDao = new MentorDaoImpl();
//        Mentor mentor = new Mentor();
//        mentor.setName("Dolon");
//        mentor.setSurname("Bekov");
//        mentor.setEmail("dolon@gmail.com");
//        mentor.setPhone("996550000000");
//        mentor.setExperience(5);
//        mentor.setSalaryForLesson(1500);
////        mentorDao.save(mentor);

//        Mentor[] mentors = mentorDao.findAll();
//        System.out.println(Arrays.toString(mentors));

//        CourseDao courseDao = new CourseDaoImpl();
        Course[] courses = courseDao.findAll();
        System.out.println(Arrays.toString(courses));


//        managerDao.save(manager);
//        Manager[] managers =managerDao.findAll();
//        System.out.println(Arrays.toString(managers));

//        StudentDao studentDao = new StudentDaoImpl();
//        Student[] students = studentDao.findAll();
//        System.out.println(Arrays.toString(students));

//        CourseFormatDao courseFormatDao = new CourseFormatDaoImpl();
//        CourseFormat[] courseFormats = courseFormatDao.findAll();
//        System.out.println(Arrays.toString(courseFormats));

//        GroupDao groupDao = new GroupDaoImpl();
//        Group[] groups = groupDao.findAll();
//        System.out.println(Arrays.toString(groups));

//          MentorDao mentorDao = new MentorDaoImpl();
//          Mentor[] mentors = mentorDao.findAll();
//        System.out.println(Arrays.toString(mentors));
    }
}
