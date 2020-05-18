package delivery.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class FileService {

    private final String MESSAGE_ERROR_READ = "Can not read input file: ";

    public Map<String, Integer> getMovements(String fileName)  {
        Map<String, Integer> result = new TreeMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String path = line.toUpperCase();
                if (result.containsKey(path)) {
                    result.put(path, result.get(path) + 1);
                } else {
                    result.put(path, 1);
                }
            });
        } catch (IOException e) {
            throw  new InputException(MESSAGE_ERROR_READ+fileName, e);

        }
        return result;

    }

    public void writeFile(List<String> list, String name) {
        System.out.println("-------------: " + name);
        list.forEach(a -> {
                    System.out.println(name);
                    System.out.println(a);

                }
        );
    }


}
