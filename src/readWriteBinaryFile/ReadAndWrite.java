package readWriteBinaryFile;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Cuong","TN");
        Student s2 = new Student(2,"Huyen","HN");
        Student s3 = new Student(3,"Long","HP");
        Student s4 = new Student(4,"Thang","BN");
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(s1);
        listStudent.add(s2);
        listStudent.add(s3);
        listStudent.add(s4);

        writeBinaryFile("student.txt",listStudent);

        List<Student> list = readBinaryFile("student.txt");
        for (Student a:list
             ) {
            System.out.println(a);
        }


    }
    public static void writeBinaryFile(String path, List<Student> list){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                fileOutputStream.close();
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<Student> readBinaryFile(String path){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<Student>student = new ArrayList<>();
        try{
            fileInputStream =new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);

            student =(List<Student>) objectInputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                fileInputStream.close();
                objectInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return student;
    }
}
