import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class World {

    private String level;
    LinkedList<Cell> cells;


    public World (){
        try {
            cells = DataSource.getInstance().getCells();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCellsWithOperationsData(){
        DataSource ds = DataSource.getInstance();
        LinkedList<String> operations =  ds.getOperations();
        LinkedList<Cell> cells= ds.getCells();
        Spider spider = new Spider();
        int spiderCurrPosition = ds.getSpiderCurrPosition();
        char spiderCurrDirection = ds.getSpiderCurrDirection();

        System.out.println(spiderCurrDirection + "****" + spiderCurrPosition);
//        for(Cell c : cells){
//            if(c.hasSpider()){
//                int x = spider.getX();
//                int y = spider.getY();
//                System.out.println(x + " ---- " + y);
//                System.out.println(ds.getSpiderCurrPosition());
//            }
//
//        }
        for (String o: operations){
            switch (o){
                case "move":

            }
        }
    }






    public void draw(Graphics g){
        int x=50;
        int y=50;
        int rowSize = (int)Math.sqrt(cells.size());
        int rowCount = 0;

        for (Cell c: cells){
            if(rowCount==rowSize){
                y+=80;
                x=50;
                rowCount=0;
            }
            c.setCellPosition(x, y);
            c.draw(g);
            x+=80;
            rowCount+=1;
        }
    }



}
