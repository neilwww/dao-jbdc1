package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDaoJBDC();

        System.out.println("=== test: department findById ====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("=== test2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== test3: department insert ====");
        Department newDepartment = new Department(5, "Games");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== test4: department update ====");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("comidas");
        departmentDao.update(dep2);
        System.out.println("updated!");

        System.out.println("\n=== test5: department delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
