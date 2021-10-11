package ProductManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Product p1 = new Product("C01","IpX","Australia",10,"100%");
        Product p2 = new Product("C02","Ip11","Japan",16,"98%");
        Product p3 = new Product("C03","Ip12","Australia",20,"95%");
        List<Product> productList = new ArrayList<>();


        addProduct(productList,p1,"productList.txt");
        addProduct(productList,p2,"productList.txt");
        addProduct(productList,p3,"productList.txt");
        display("productList.txt");
        searchInfo("productList.txt");
    }
    public static void searchInfo(String path){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Ma san pham can search");
        String code = scanner.nextLine();

        FileInputStream is = null;
        ObjectInputStream ois = null;
        try{
            is = new FileInputStream(path);
            ois = new ObjectInputStream(is);
            List<Product> productList = (List<Product>)ois.readObject();

            for (int i = 0; i < productList.size(); i++) {
                if(code.equals(productList.get(i).getCode())){
                    System.out.println(productList.get(i));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                is.close();
                ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    public static void display(String path){
        FileInputStream is = null;
        ObjectInputStream ois = null;

        try{
            is = new FileInputStream(path);
            ois = new ObjectInputStream(is);

            for (Product a:(List<Product>)ois.readObject()) {
                System.out.println(a);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void addProduct(List<Product> list,Product product,String path){
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        //Them mot product
        list.add(product);
        try{
            os = new FileOutputStream(path);
            oos = new ObjectOutputStream(os);

            //Viet lai list Product
            oos.writeObject(list);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                os.close();
                oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
