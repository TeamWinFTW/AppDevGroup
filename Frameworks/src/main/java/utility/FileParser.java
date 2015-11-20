package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import ie.james.Exhibit;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05/11/2015.
 */
public class FileParser {
    public List<Exhibit> parseFromJson(String dir)throws IOException

    {

        Exhibit exhibit=null;
        List<Exhibit> exhibitList = new ArrayList();

        List<Path> files = files = FileFinder.getFileList(dir, "*.json");
        for (Path f : files) {
            exhibit = new ObjectMapper().readValue(f.toFile(), Exhibit.class);
            exhibitList.add(exhibit);
        }

    return exhibitList;
    }
}
