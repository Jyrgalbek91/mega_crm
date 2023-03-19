package dao.impl;

import dao.CourseDao;
import model.Course;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CourseDaoImpl implements CourseDao {
    private final String PATH_FILE =  "C:\\JavaC\\mega_crm\\lib\\Course.txt";
    private final File COURSE_FILE = new File(PATH_FILE);
    private int count = 0;

    public CourseDaoImpl(){
        boolean isCreated = false;
        if (!COURSE_FILE.exists()) {
            try {
                isCreated = COURSE_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated){
            System.out.println("Новый файл создан");
        }
    }
    @Override
    public void save(Course course) {
        int count = getCount();
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(COURSE_FILE,true));
            out.print(++count + " ");
            out.print(course.getName() + " ");
            out.print(course.getPrice() + " ");
            out.print(course.getDateCreated().toString().substring(0,22));
            out.println();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course[] findAll() {
        int count = getCount();
        Course[] courses = new Course[count];
        try {
            Scanner scanner = new Scanner(COURSE_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Course course = new Course();
                course.setId(scanner.nextLong());
                course.setName(scanner.next());
                course.setPrice(Double.parseDouble(scanner.next()));
                course.setDateCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                courses[i] = course;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }
    private int getCount(){
        int count = 0;
        try {
            Scanner scanner = new Scanner(COURSE_FILE);
            while (scanner.hasNextLine()){
                count++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
}
