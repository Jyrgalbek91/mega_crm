import dao.ManagerDao;
import dao.impl.ManagerDaoImpl;
import model.Manager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ManagerDao managerDao = new ManagerDaoImpl();
        Manager manager = new Manager();
        manager.setId(2);
        manager.setName("Jyrgal");
        manager.setSurname("Almazbekovekov");
        manager.setEmail("jyrgal@gmail.com");
        manager.setPhone("996505555555");
        manager.setSalary(50000);

//        managerDao.save(manager);
        Manager[] managers =managerDao.findAll();
        System.out.println(Arrays.toString(managers));
    }
}