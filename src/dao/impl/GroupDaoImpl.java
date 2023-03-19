package dao.impl;

import dao.GroupDao;
import model.Group;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class GroupDaoImpl implements GroupDao {

    private final String PATH_FILE = "C:\\JavaC\\mega_crm\\lib\\Group.txt";
    private final File GROUP_FILE = new File(PATH_FILE);
    private int count = 0;
    public GroupDaoImpl(){
        boolean isCreated = false;
        if (!GROUP_FILE.exists()) {
            try {
                isCreated = GROUP_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated){
            System.out.println("Новый файл создан");
        }
    }
    @Override
    public void save(Group group) {
        int count = getCount();
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            out.print(++count + " ");
            out.print(group.getName() + " ");
            out.print(group.getRoom() + " ");
            out.print(group.getStartTime() + " ");
            out.print(group.getDateCreated().toString().substring(0,22));
            out.println();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group[] findAll() {
        int count = getCount();
        Group[] groups = new Group[count];
        try {
            Scanner scanner = new Scanner(GROUP_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Group group = new Group();
                group.setId(scanner.nextLong());
                group.setName(scanner.next());
                group.setRoom(scanner.next());
                group.setStartTime(LocalTime.parse(scanner.next()));
                group.setDateCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                groups[i] = group;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return groups;
    }
    private int getCount(){
        int count = 0;
        try {
            Scanner scanner = new Scanner(GROUP_FILE);
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
