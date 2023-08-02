import java.util.LinkedList;

public class DataSource {

    private static DataSource _instance;
    private LinkedList<Cell> cells;
    private LinkedList<String> operations;
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

}
