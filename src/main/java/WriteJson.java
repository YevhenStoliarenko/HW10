import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteJson {
    public void writeJson() throws FileNotFoundException {
        Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();
        Scanner scanner = new Scanner(new File("textjson.txt"));
        List<Person> users = new ArrayList<>();
        Integer age = null;
        String line = null;
        int count;
        while (scanner.hasNext()) {
            if((scanner.nextLine()).equals("name age\n")){
                continue;
            } else {
                if (scanner.hasNextLine()) {
                    line = scanner.next();
                }
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                }
            }
            Person person = new Person(line, age);
            users.add(person);
        }

        String customerJson = gsonMapper.toJson(users);
        System.out.println(customerJson);
    }
    @AllArgsConstructor
    @Builder
    @Data
    private static class Person{
        private String name;
        private Integer age;

    }
}
