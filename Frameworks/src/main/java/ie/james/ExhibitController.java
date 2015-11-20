package ie.james;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utility.FileParser;

import java.io.IOException;
import java.util.List;


@RestController
public class ExhibitController {
    @RequestMapping("/exhibit")
    public Exhibit exhibit(@RequestParam(value="id") String id) throws IOException {
        List<Exhibit> exhibits=new FileParser().parseFromJson("C:\\Users\\User\\Desktop\\Frameworks\\682506");
        for(Exhibit e: exhibits){
            if(e.getId().equalsIgnoreCase(id)){
                return e;
            }

        }
        return null;
    }
}