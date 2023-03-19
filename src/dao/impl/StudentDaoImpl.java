package dao.impl;

import dao.StudentDao;
import model.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

    private final String PATH_FILE = "C:\\JavaC\\mega_crm\\lib\\Student.txt";
    private final File STUDENT_FILE = new File(PATH_FILE);
    private int count = 0;

    public StudentDaoImpl() {
        boolean isCreated = false;
        if (!STUDENT_FILE.exists()) {
            try {
                isCreated = STUDENT_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated) {
            System.out.println("Новый файл создан");
        }
    }

    @Override
    public void save(Student student) {
        int count = getCount();
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            out.print(++count + " ");
            out.print(student.getName() + " ");
            out.print(student.getSurname() + " ");
            out.print(student.getEmail() + " ");
            out.print(student.getPhone() + " ");
            out.print(student.getDob() + " ");
            out.print(student.getDateCreated().toString().substring(0, 22));
            out.println();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student[] findAll() {
        int count = getCount();
        Student[] students = new Student[count];
        try {
            Scanner scanner = new Scanner(STUDENT_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Student student = new Student();
                student.setId(scanner.nextLong());
                student.setName(scanner.next());
                student.setSurname(scanner.next());
                student.setEmail(scanner.next());
                student.setPhone(scanner.next());
                student.setDob(LocalDate.parse(scanner.next()));
                student.setDateCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                students[i] = student;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    private int getCount() {
        int count = 0;
        try {
            Scanner scanner = new Scanner(STUDENT_FILE);
            while (scanner.hasNextLine()) {
                count++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
}
