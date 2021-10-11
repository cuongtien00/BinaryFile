package copyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap duong dan file muon copy");
        String source = scanner.nextLine();
        System.out.println("Nhap duong dan cu file dich");
        String dest = scanner.nextLine();
        System.out.println("Copy success!");
        try {
            copyFile(source, dest);
        }catch (Exception e){
            System.out.println("Copy not success!");
        }
        finally {
        }

    }
    public static void copyFile(String sourcePath, String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream(sourcePath);
            fileOutputStream = new FileOutputStream(destPath);
             byte [] bytes = new byte[1024];
            int ch ;
            while((ch = fileInputStream.read(bytes))>0){
                fileOutputStream.write(bytes,0,ch);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                fileInputStream.close();
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
