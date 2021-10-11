package ProductManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        ProductManager productManager = new ProductManager();
        productManager.setProductList(productList);
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice!=0){
            System.out.println("Quan ly san pham");
            System.out.println("1.Them moi san pham");
            System.out.println("2.Hien thi thong tin san pham");
            System.out.println("3.Hien thi danh sach thong tin san pham");
            System.out.println("4.Exit!");
            System.out.println("Moi nhap lua chon cua ban:");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    productManager.addProduct(productList,"productList.txt");
                    break;
                case 2:
                    productManager.searchInfo("productList.txt");
                    break;
                case 3:
                    productManager.display("productList.txt");
                    break;
                case 4:
                    System.exit(0);
            }

        }
    }
}
