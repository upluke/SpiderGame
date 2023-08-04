import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;

public class ProblemHelper {

    private LinkedList<Cell> problem;


    public ProblemHelper(){
        problem = new LinkedList<>();
    }

    public void load(String level) {
        DataSource ds = DataSource.getInstance();
        try(BufferedReader reader = new BufferedReader(new FileReader("levels/"+level+".txt"))){
            String gridDataStr = reader.readLine();
            String[] gridDataArr = gridDataStr.split(", ");


            String blockDataString = reader.readLine();
            // String[] spawnBlockArr = blockDataString.split(", ");

            int id = 0;
            HashMap<Character, Color> colorMap  =new HashMap<>();
            colorMap.put('r', Color.RED);
            colorMap.put('b', Color.BLUE);
            colorMap.put('g', Color.GREEN);

            HashMap<Character, Character> spiderDirectionMap = new HashMap<>();
            spiderDirectionMap.put('n', 'n');
            spiderDirectionMap.put('s', 's');
            spiderDirectionMap.put('w', 'w');
            spiderDirectionMap.put('e', 'e');

            for (int i =0; i< gridDataArr.length;i++) {
                String currCellData = gridDataArr[i];

                id = i+1;
                Color color =colorMap.getOrDefault(currCellData.charAt(1), Color.BLACK);
                boolean hasDiamond=currCellData.contains("r")|| currCellData.contains("b")|| currCellData.contains("g");
                boolean hasSpider=currCellData.contains("n")|| currCellData.contains("s") || currCellData.contains("w")|| currCellData.contains("e");
                char spiderDirection=spiderDirectionMap.getOrDefault(currCellData.charAt(1), 'n');

                // initialize spider's position and direction in DataSource
                if(hasSpider){
                    ds.setSpiderCurrPosition(i);
                }
                Cell cell = new Cell(hasDiamond,hasSpider, color,spiderDirection, id);

                problem.add(cell);

            }

            DataSource.getInstance().setCells(problem);

//            for (Cell item : problem) {
//                System.out.println(item.getId() + " ^^^^^^ " +item.hasDiamond());
//            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Cell> getProblem(){
        return problem;
    }
}
