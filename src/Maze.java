import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    private int width;
    private int height;
    private List<Integer> startPoint = new ArrayList<>();
    private List<Integer> endPoint = new ArrayList<>();
    private List<List<String>> maze;

    public Maze(int width, int height, int startX, int startY, int endX, int endY, List<List<String>> maze){
        this.width= width;
        this.height= height;
        this.startPoint.add(startX);
        this.startPoint.add(startY);
         this.endPoint.add(endX);
         this.endPoint.add(endY);
         this.maze = maze;
         this.maze.get(startY).set(startX, "S");
         this.maze.get(endY).set(endX, "E");

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Integer> getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(List<Integer> startPoint) {
        this.startPoint = startPoint;
    }

    public List<Integer> getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(List<Integer> endPoint) {
        this.endPoint = endPoint;
    }

    public List<List<String>> getMaze() {
        return maze;
    }

    public void setMaze(List<List<String>> maze) {
        this.maze = maze;
    }

    @Override
    public String toString() {


        String maze= "";
        for(int i = 0; i< height; i++){
            for(int j= 0; j<width; j++){
                String ch = this.maze.get(i).get(j);
                       if(ch.equals(1)){
                           maze+= "#";
                       }
                       if(ch.equals("0"))
                           maze+= " ";
                        else
                         maze += ch;
            }
            maze+= "\n";
        }
        return maze;

    }

    public boolean isValid(int positionX, int positionY) {
        System.out.println(positionX + " " + positionY);

        if(this.maze.get(positionY).get(positionX).equals("E"))  {
            System.out.println("alo?");
                     System.exit(0);
        }
        if(!this.maze.get(positionY).get(positionX).equals("1") ){
            return true;
        }





 //       System.out.println("COULDNT MOVE!!");
                         return false;
    }

    public void move(int newPositionX, int newPositionY) {

                    this.maze.get(newPositionY).set(newPositionX, "X");
    }
}
