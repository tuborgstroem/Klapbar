//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Bar;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bar {
    public Bar() {
    }

    public void runBar() {
        String fileName = "/resources/barMessage.txt";
        new File(fileName);
        String msg = "";

        String name;
        try {
            InputStreamReader isr = new InputStreamReader(this.getClass().getResourceAsStream(fileName));

            BufferedReader reader;
            for(reader = new BufferedReader(isr); (name = reader.readLine()) != null; msg = msg + name + "\n") {
            }

            reader.close();
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Insert message: ");
        System.out.println(msg);
        System.out.println("To continue press 0");

        for(int a = input.nextInt(); a == 0; a = input.nextInt()) {
            System.out.println("Indtast navnet?");
            name = input.next();
            System.out.println("Indtast beløbet");
            String value = input.next();
            String myString = makeString(msg, name, value);
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, (ClipboardOwner)null);
            System.out.println(myString);
            System.out.println("To continue press 0");
        }

    }

    public static String makeString(String oldString, String name, String value) {
        String temp = oldString.replace("[NAVN]", name);
        temp = temp.replace("[ANTAL]", value);
        return temp;
    }
}
