package copyBinaryFile;

import readWriteBinaryFile.Student;

import java.io.*;

public class CopyBinaryFile {
    public static void main(String[] args) {
        copyBinaryFile("student.txt","copy_student.txt");

    }
    public static void copyBinaryFile(String path,String dest){
        FileInputStream is = null;
        ObjectInputStream ois = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;

        try{
            is = new FileInputStream(path);
            ois = new ObjectInputStream(is);
            os =new FileOutputStream(dest);
            oos = new ObjectOutputStream(os);

            oos.writeObject(ois.readObject());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                ois.close();
                os.close();
                oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
