package comm.example;

import java.io.*;

public class FileReaderWriter {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("farrago.txt");
        File outputFile = new File("outagain.txt");

        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);
        int c;

        while ((c = in.read()) != -1){
            System.out.println((char)c);
            out.write(c);
        }

        System.out.println("FileReader is used to read a file and FileWriter is used for writing.");

        in.close();
        out.close();
    }
}
