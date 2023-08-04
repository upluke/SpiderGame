import java.util.Arrays;
import java.util.LinkedList;

public class DataSource {

    private static DataSource _instance;
    private LinkedList<Cell> cells;
    private int spiderCurrPosition;
    private char spiderCurrDirection;
    private LinkedList<String> operations = new LinkedList<>(Arrays.asList("move", "turn", "paintBlue"));
    private DataSource(){

        cells = new LinkedList<>();

    }


    public static DataSource getInstance(){
        if(_instance==null){
            _instance= new DataSource();
        }
        return _instance;
    }

    public void setCells(LinkedList<Cell> cells) {
        this.cells = cells;
    }

    public LinkedList<Cell> getCells(){
        return cells;
    }

    public int getSpiderCurrPosition(){
        return spiderCurrPosition;
    }

    public void setSpiderCurrPosition(int position){
        this.spiderCurrPosition=position;
    }

    public char getSpiderCurrDirection(){
        return spiderCurrDirection;
    }

    public void setSpiderCurrDirection(char direction){
        this.spiderCurrDirection =direction;
    }
    public void setOperations(){
        // TODO: takes blocks and update operations with blocks' info
    }

    public LinkedList<String> getOperations(){
        return operations;
    }

}
