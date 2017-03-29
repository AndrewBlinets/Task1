package by.andrewblinets.transport.ui.read;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class ReadJsonFile implements IteamMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src\\by\\andrewblinets\\transport\\file\\info.json"));
            JSONObject jsonObject = (JSONObject)obj;
            parserJSON(jsonObject,userInterface);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void parserJSON(JSONObject jsonObject, UserInterface userInterface) {
        throw new UnsupportedOperationException();
    }
}
