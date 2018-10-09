import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader file;

        file = new FileReader("input.txt");
        Maze maze = file.CreateMaze();
        Player player = new Player(maze.getStartPoint().get(0), maze.getStartPoint().get(1));


        while (true) {
            System.out.println(player.getDirection());
            System.out.println(maze);

          //can i go right?
         if(player.canMoveRight(maze)){
            player.rotate(true, maze);
            player.moveForward(maze);
         }else{
             if(!player.moveForward(maze)){
                 player.rotate(false, maze);
             }
         }



        }
    }
}
