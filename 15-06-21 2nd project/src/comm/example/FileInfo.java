package comm.example;
import java.io.File;
import java.io.IOException;
public class FileInfo {
        public static void main(String[] args) {



        String fileName = "employee.out";
        File fn = new File(fileName);
        try {
            fn.createNewFile();
        } catch (IOException e) {
        	e.printStackTrace();

        }
        System.out.println("Name: " + fn.getName());

        // Check if the file exists using exists() method
        if (fn.exists()) {
            System.out.println(fileName + " does exist.");
        }

        if (fn.canRead()) {
            System.out.println(fileName  + " is readable.");
        }

        System.out.println(fileName + " is " + fn.length() + " bytes long.");
        System.out.println(fileName + " is last modifed at " +
                new java.util.Date(fn.lastModified())) ;

        if (fn.canWrite()) {
            System.out.println(fileName  + " is writable.");
        } else{
            System.out.println(fileName  + " is not writable.");
        }
    }
}