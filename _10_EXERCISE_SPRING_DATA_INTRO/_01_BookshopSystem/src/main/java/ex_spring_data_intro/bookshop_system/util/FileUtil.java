package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtil {
    //return list of all lines (without the blank lines)

    public String[] fileContent(String path) throws IOException {

        File file = new File(path);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        List<String> fileInfo = new ArrayList<>();
        String line;

        while((line = bf.readLine()) != null){
          fileInfo.add(line);
        }

        return fileInfo.stream()
                .filter(l->!l.equals(""))
                .toArray(String[]::new);
    }
}
