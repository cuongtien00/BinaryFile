package ProductManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements Serializable {
    private List<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public  void searchInfo(String path){
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
    public  void display(String path){
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
    public  void addProduct(List<Product> list, String path){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap code");
        String  code = scanner.nextLine();
        System.out.println("Nhap ten san pham");
        String name = scanner.nextLine();
        System.out.println("Nhap noi san xuat");
        String source = scanner.nextLine();
        System.out.println("Nhap gia");
        int price = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhap mo ta");
        String description = scanner1.nextLine();
        Product product = new Product(code,name,source,price,description);


        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        //Them mot product
        list.add(product);
        try {
            os = new FileOutputStream(path);
            oos = new ObjectOutputStream(os);

            //Viet lai list Product
            oos.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
