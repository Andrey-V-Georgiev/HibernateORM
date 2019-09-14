package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;

@Component
public class CopiesUtil {

    public Integer setCopiesCount(String arg_2) {
        int copies = Integer.parseInt(arg_2);
        System.out.println(copies + "\n");
        return copies;
    }
}
