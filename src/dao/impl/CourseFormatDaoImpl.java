package dao.impl;

import dao.CourseFormatDao;
import enums.Format;
import model.CourseFormat;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CourseFormatDaoImpl implements CourseFormatDao {
    private final String PATH_FILE = "C:\\JavaC\\mega_crm\\lib\\CourseFormat.txt";
    private final File COURSE_FORMAT_FILE = new File(PATH_FILE);
    private int count = 0;

    public CourseFormatDaoImpl() {
        boolean isCreated = false;
        if (!COURSE_FORMAT_FILE.exists()) {
            try {
                isCreated = COURSE_FORMAT_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated){
            System.out.println("Новый файл создан");
        }
    }

    @Override
    public void save(CourseFormat courseFormat) {
        int count = getCount();
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            out.print(++count + " ");
            out.print(courseFormat.getFormat() + " ");
            out.print(courseFormat.isOnline() + " ");
            out.print(courseFormat.getDurationInWeek() + " ");
            out.print(courseFormat.getLessonDuration() + " ");
            out.print(courseFormat.getLessonCountPerWeek() + " ");
            out.print(courseFormat.getDateCreated().toString().substring(0,22));
            out.println();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CourseFormat[] findAll() {
        int count = getCount();
        CourseFormat[] courseFormats = new CourseFormat[count];
        try {
            Scanner scanner = new Scanner(COURSE_FORMAT_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                CourseFormat courseFormat = new CourseFormat();
                courseFormat.setId(scanner.nextLong());
                courseFormat.setFormat(Format.valueOf(scanner.next()));
                courseFormat.setOnline(Boolean.parseBoolean(scanner.next()));
                courseFormat.setLessonDuration(scanner.nextInt());
                courseFormat.setLessonCountPerWeek(scanner.nextInt());
                courseFormat.setDurationInWeek(scanner.nextInt());
                courseFormat.setDateCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                courseFormats[i] = courseFormat;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courseFormats;
    }

    private int getCount(){
        int count = 0;
        try {
            Scanner scanner = new Scanner(COURSE_FORMAT_FILE);
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
