import com.google.gson.Gson;
import models.Institution;
import org.junit.Test;
import services.EventService;
import services.InstitutionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataFlowTests {
    private EventService eventService = new EventService();
    private InstitutionService institutionService = new InstitutionService();

    @Test
    public void updateLocalEvent(){
        eventService.requestOneEvent("5d0d49f5ff94054db4198a83");
    }

    @Test
    public void readLocalEvent(){
        eventService.updateOneEvent("5d0d49f5ff94054db4198a83");
    }

    @Test
    public void insertNewEvent(){
        eventService.insertOneEvent(readAndReturnJson("event"), "5d1e81f16272763c4e85ac96");
    }

    @Test
    public void insertNewInstitution(){
        institutionService.insertInstitution(new Gson().fromJson(readAndReturnJson("institution"), Institution.class));
    }

    @Test
    public void updateInstitution(){
        institutionService.updateInstitution(new Gson().fromJson(readAndReturnJson("institution"), Institution.class), "5d1e827d0b7f8e7746315c82");
    }

    @Test
    public void requestInstitution(){
        institutionService.requestInstitution("5d1e827d0b7f8e7746315c82");
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
