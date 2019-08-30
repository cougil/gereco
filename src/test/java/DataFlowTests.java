import com.google.gson.Gson;
import models.Institution;
import org.junit.Test;
import services.EventService;
import services.InstitutionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class DataFlowTests {
    private EventService eventService = new EventService();
    private InstitutionService institutionService = new InstitutionService();

    @Test
    public void updateLocalEvent(){
        eventService.writeEvent("5d0d49f5ff94054db4198a83");
    }

    @Test
    public void readLocalEvent(){
        eventService.updateEvent("5d0d49f5ff94054db4198a83");
    }

    @Test
    public void insertNewEvent(){
        eventService.insertEventInCollection(readAndReturnJson("event"));
    }

    @Test
    public void failureInsertNewInstitution(){
        boolean validRegister = institutionService.insertInstitution(
                new Gson().fromJson(readAndReturnJson("institution"), Institution.class));
        assertFalse(validRegister);
    }

    @Test
    public void updateInstitution(){
        institutionService.updateInstitution(new Gson().fromJson(readAndReturnJson("institution"),
                Institution.class));
    }

    private String readAndReturnJson(String path){
        String jsonEvent = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + path + ".json"));
            jsonEvent = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonEvent;
    }
}
