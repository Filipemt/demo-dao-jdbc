package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- TEST: FindByID: ---");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n--- TEST: FindByDepartment: ---");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n--- TEST: FindAll: ---");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        /*
        System.out.println("\n--- TEST: Insert: ---");
        Seller newSeller = new Seller(null, "Filipe", "filipe@gmail.com", new Date(), 10000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New seller ID: " + newSeller.getId());
         */

        System.out.println("\n--- TEST: Update: ---");
        seller = sellerDao.findById(1);
        seller.setEmail("gustavo@gmail.com");
        sellerDao.update(seller);
        System.out.println("Updated Complete!");
    }
}



