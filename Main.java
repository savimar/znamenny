package ru.knaur.oxana.znamen;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(new File(scanner.nextLine()));
        FileWriter writer = new FileWriter(scanner.nextLine());
        scanner.close();
        String[] stringsZn;
        char[] a;
        char[] c;
        char[] d;


        while (scanner1.hasNext()) {
            String s = scanner1.nextLine();
            stringsZn = s.split(" ");
            for (String s1 : stringsZn) {
                if (s1.equals("")) continue;
                s1 = s1.replaceAll("[ ]", "");
                s1 = s1.replaceAll("\\\\", "\\\\\\\\");
                writer.write("\"" + s1 + "\" ");
            }
     }
     writer.close();
        scanner1.close();
    }
}
