@SuppressWarnings("ALL")
public class Player {
    private int positionX;

    private int positionY;


    private String direction;
    public Player(int x, int y){
        positionX = x;
        positionY = y;
        direction = "N";
    }

    public boolean movePlayer(String direction, Maze maze){

        if(direction.equals("N")){
            return moveNorth(maze);
        }

        if(direction.equals("S")){
          return moveSouth(maze);
        }

        if(direction.equals("E")){
            return moveEast(maze);
        }

        if(direction.equals("W")){
            return moveWest(maze);
        }
        System.out.println("couldnt move ");
    return false;
    }

    private boolean moveWest(Maze maze) {
        System.out.println("going west");

        if(maze.isValid(positionX-1, positionY)){
            maze.move(positionX-1, positionY);
            positionX = positionX-1;

            return true;
        }else{
            return false;
        }
    }

    private boolean moveSouth(Maze maze) {
        System.out.println("going South");

        if(maze.isValid(positionX, positionY +1)){
            maze.move(positionX, positionY +1);
            positionY = positionY+1;

            return true;
        }else{
            return false;
        }

    }




    private boolean moveEast(Maze maze) {
        System.out.println("going East");

        if(maze.isValid(positionX+1, positionY)){
            maze.move(positionX+1, positionY);
            positionX = positionX+1;

            return true;
        }else{
            return false;
        }
    }

    private boolean moveNorth(Maze maze) {
        System.out.println("going North");
        if(maze.isValid(positionX, positionY - 1)){
                maze.move(positionX, positionY - 1);
                positionY = positionY+1;

                return true;
            }else{
                return false;
            }

    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean moveRight(Maze maze) {
        switch (direction){
            case "N":
                return  movePlayer("E", maze);
            case "E":
                return  movePlayer("S", maze);
            case "S":
                return movePlayer("W", maze);
            case "W":
                return  movePlayer("N", maze);
        }
        return false;
    }

    public boolean moveForward(Maze maze) {
        switch (direction){
            case "N":
              return  movePlayer("N", maze);

            case "E":
                return movePlayer("E", maze);
            case "S":
                return movePlayer("S", maze);

            case "W":
                return  movePlayer("W", maze);

        }
        return false;
    }

    public void rotate(boolean clockWise, Maze maze) {
        if(clockWise) {
            switch (direction) {
                case "N":
                    direction = "E";
                    break;
                case "E":
                    direction = "S";
                    break;
                case "S":
                    direction = "W";
                    break;
                case "W":
                    direction = "N";
                    break;
            }
        }else {
            switch (direction) {
                case "N":
                    direction = "W";
                    break;
                case "E":
                    direction = "N";
                    break;
                case "S":
                    direction = "E";
                    break;
                case "W":
                    direction = "S";
                    break;
            }
        }
    }

    public boolean canMoveRight(Maze maze) {
        switch (direction) {
            case "N":
                if(positionX+1 < maze.getHeight()-1)
                return maze.isValid(positionX +1 , positionY);
                return false;
            case "E":
                if(positionY+1 < maze.getWidth()-1)
                return maze.isValid(positionX, positionY+1);
                return false;
            case "S":
                if(positionX-1 > 0)
                return maze.isValid(positionX-1, positionY);
                return false;
            case "W":
                if(positionY-1 > 0 )
                return maze.isValid(positionX, positionY-1);
                return false;
        }
        return false;

    }


}
