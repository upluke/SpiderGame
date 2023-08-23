import java.util.Arrays;
import java.util.LinkedList;

public class DataSource {

    private static DataSource _instance;
    private LinkedList<Cell> cells;
    private int spiderCurrPosition;

    private char spiderDirection;

    private LinkedList<String> operations = new LinkedList<>(Arrays.asList("move","paintGreen", "move","paintRed","turn","move","move","paintBlue"));

    private LinkedList<String> testingOperations = new LinkedList<>();
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

    public void resetCells(){
        this.cells.clear();
    }

    public int getSpiderCurrPosition(){
        return this.spiderCurrPosition;
    }

    public void setSpiderCurrPosition(int position){
        this.spiderCurrPosition=position;
    }


    public  char getSpiderDirection(){
        return this.spiderDirection;
    }

    public void setSpiderDirection(char direction){
        this.spiderDirection = direction;
    }

    public void setOperations(){
        // TODO: takes blocks and update operations with blocks' info
    }

    public LinkedList<String> getOperations(){
        return operations;
    }

    // following is for testing ---------------------


    public void setTestingOperations(String newOperation) {
        this.testingOperations.add(newOperation);
    }

    public LinkedList<String> getTestingOperations(){
        return this.testingOperations;
    }


}
