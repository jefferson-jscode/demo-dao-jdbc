package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        List<Seller> sellers = sellerDao.findByDepartment(new Department(1, ""));
        System.out.println(sellers);

        System.out.println("\n=== TEST 3: seller findAll ===");
        List<Seller> allSellers = sellerDao.findAll();
        System.out.println(allSellers );

        System.out.println("\n=== TEST 4: seller insert ===");
        Department department = new Department(1, null);
        Seller newSeller = new Seller(null, "Jack Bauer", "bauer@ctu.gov.us", new Date(), 38000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("\nInserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Close O'Brian");
        seller.setEmail("cloe.obrian@ctu.gov.us");
        sellerDao.update(seller);
        System.out.println("\nUpdate completed");

        System.out.println("\n=== TEST 6: seller deleteById ===");
        sellerDao.deleteById(8);
        System.out.println("Deleted");

    }
}
