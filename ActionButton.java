package ru.knaur.oxana.znamen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ActionButton implements ActionListener {
    public static File file;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Открыть")) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = fileopen.getSelectedFile();
            }
        } else if (e.getActionCommand().equals("Преобразовать")) {
            if (file != null) {
                String str = file.getAbsolutePath();
                String[] path = str.split(".txt");
                Scanner scanner = null;
                try {
                    scanner = new Scanner(new File(str));
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                FileWriter writer = null;
                try {
                    writer = new FileWriter(path[0] + "New.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //  scanner.close();
                String[] stringsZn;
                char[] a;
                char[] c;
                char[] d;


                while (scanner.hasNext()) {
                    String s = scanner.nextLine();
                    stringsZn = s.split(" ");
                    for (String subS : stringsZn) {
                        if (subS.equals("")) continue;
                        subS = subS.replaceAll("[ ]", "");
                        subS = subS.replaceAll("\\\\", "\\\\\\\\");
                        try {
                            writer.write("\"" + subS + "\"");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                try {
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                scanner.close();
            }


        } else if (e.getActionCommand().equals("Очистить")) {
            file = null;
        }
    }
}
