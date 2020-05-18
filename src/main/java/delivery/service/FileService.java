package delivery.service;

import delivery.exception.InputException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * @author nilver
 * @version 1.0.0
 * @since 1.0.0
 */
public class FileService {

    private static final String MESSAGE_ERROR_READ = "Can not read input file: ";
    private static final String PATH_BASE_INPUT = "src/main/resources/input/";
    private static final String PATH_BASE_OUTPUT = "src/main/resources/output/";

    public FileService() {

    }

    public Map<String, Integer> getMovements(String fileName) {
        Map<String, Integer> result = new TreeMap<>();
        String base = "in0";
        try (Stream<String> stream = Files.lines(Paths.get(PATH_BASE_INPUT + base + fileName))) {
            stream.forEach(line -> {
                String path = line.toUpperCase();
                if (result.containsKey(path)) {
                    result.put(path, result.get(path) + 1);
                } else {
                    result.put(path, 1);
                }
            });
        } catch (IOException e) {
            throw new InputException(MESSAGE_ERROR_READ + fileName, e);

        }
        return result;

    }

    public void writeFile(List<String> list, String nameFile) {
        try {
            String base = "out0";
            FileWriter myWriter = new FileWriter(PATH_BASE_OUTPUT + base + nameFile);
            for (int i = 0; i < list.size(); i++) {
                myWriter.write(list.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            throw new InputException("Writing results",e);
        }
    }


}
