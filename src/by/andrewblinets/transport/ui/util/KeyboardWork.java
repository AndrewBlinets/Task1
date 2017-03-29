package by.andrewblinets.transport.ui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KeyboardWork {

    private BufferedReader in;
    private boolean flagError;

    public KeyboardWork() {
        try {
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }
        catch (Throwable t)
        {
            System.out.println(t.getMessage());
        }
        this.flagError =  false;
    }

    public double readDouble(String str)
    {
        do {
            System.out.println(str);
            try {
                flagError = false;
                return Double.parseDouble(in.readLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Enter a numerical value, please!!!");
                flagError = true;
            }
            catch (IOException e) {
                System.out.println("Error reading from the keyboard");
                flagError = true;
            }
        }
        while (flagError);
        return 0;
    }

    public int readInt(String str)
    {
        do {
            System.out.print(str);
            try {
                flagError = false;
                return Integer.parseInt(in.readLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Enter a numerical value, please!!!");
                flagError = true;
            }
            catch (IOException e) {
                System.out.println("Error reading from the keyboard");
                flagError = true;
            }
        }while (flagError);
        return 0;
    }

    public String readString(String str)
    {
        do {
            System.out.println(str);
            try {
                flagError = false;
                String string = in.readLine();
                if(string.length() != 0)
                    return string;
                else
                    flagError = true;
            } catch (IOException e) {
                System.out.println("Error reading from the keyboard");
                flagError = true;
            }
        }
        while (flagError);
        return "";
    }
}
