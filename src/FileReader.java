import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private File file;


    public FileReader(String path) throws FileNotFoundException {
        file = new File(path);

    }

    public Maze CreateMaze() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);


            String[] firstLine =  scanner.nextLine().split(" ");
            int width = Integer.parseInt(firstLine[0]);

        int height = Integer.parseInt(firstLine[1]);
            String[] secondLine =  scanner.nextLine().split(" ");
            int startX = Integer.parseInt(secondLine[0]); int startY = Integer.parseInt(secondLine[1]);
            String[] thirdLine =  scanner.nextLine().split(" ");
            int endX = Integer.parseInt(thirdLine[0]); int endY = Integer.parseInt(thirdLine[1]);
            List<List<String>> map = new ArrayList<>();
            for(int i = 0 ; i < height; i++) {

                String[] line = scanner.nextLine().split(" ");
                List<String> line2 = Arrays.asList(line);
                map.add(line2);

            }
        return new Maze(width, height, startX, startY, endX, endY, map);
    }
}
