import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;


public class WorldPanel extends JPanel implements ActionListener {
    private World world;
    ProblemHelper problemHelper;
    DataSource ds = DataSource.getInstance();

//    private Timer spiderMoveTimer;
    public WorldPanel(){

//        spiderMoveTimer = new Timer(2000, this); // 1000ms delay (1 second)
        problemHelper =new ProblemHelper();
        problemHelper.load("1");
        world = new World();


        setLayout(new BorderLayout());
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(6, 1));
        btnPanel.setPreferredSize(new Dimension(100, 800));
        JButton playBtn = new JButton("Play");
        JButton resetBtn = new JButton("Reset");
        playBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        btnPanel.add(playBtn);
        btnPanel.add(resetBtn);

        add(btnPanel, BorderLayout.EAST);

        setBackground(Color.white);

    }


    public void updateCellsWithOperationsData(){

        LinkedList<String> operations =  ds.getOperations();
        LinkedList<Cell> cells= ds.getCells();
        Spider spider = new Spider();
//        spiderMoveTimer.setInitialDelay(0);
//        spiderMoveTimer.start();
        for (String o: operations){
            //                spiderMoveTimer.stop();

            int spiderCurrPosition = ds.getSpiderCurrPosition();

            // calculate left boundary and right boundary
            int leftBoundary =(spiderCurrPosition/5) *(int) Math.sqrt(cells.size()); // leftBoundary <= position
            int rightBoundary = leftBoundary+5; // rightBoundary > position

            Cell currCell = cells.get(spiderCurrPosition);

            // TODO: 1. set and test n s  2. modulize main conditional function 3. handle other operations
            if(o=="move") {
                System.out.println("in in ");
                currCell.setHasSpider(false);
                char spiderDirection = currCell.getSpiderDirection();
                System.out.println(spiderDirection + " - " + spiderCurrPosition);


                if(spiderDirection =='n' && spiderCurrPosition-5>=0){
                    System.out.println("in nnnnnn");
                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition - 5);
                    cellSpiderWillMoveTo.setHasSpider(true);
                    ds.setSpiderCurrPosition(spiderCurrPosition-5);
                    cellSpiderWillMoveTo.setSpiderDirection('n');


                }else if(spiderDirection =='s' && spiderCurrPosition+5<cells.size()){
                    System.out.println("in ssssss");
                    Cell cellSpiderWillMoveTO = cells.get(spiderCurrPosition+5);
                    cellSpiderWillMoveTO.setHasSpider(true);
                    ds.setSpiderCurrPosition(spiderCurrPosition+5);
                    cellSpiderWillMoveTO.setSpiderDirection('s');


                }else if(spiderDirection =='w' && (spiderCurrPosition-1) >=leftBoundary){
                    System.out.println("in wwwwww");
                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition-1);
                    cellSpiderWillMoveTo.setHasSpider(true);
                    ds.setSpiderCurrPosition(spiderCurrPosition-1);
                    cellSpiderWillMoveTo.setSpiderDirection('w');


                }else if(spiderDirection == 'e' && (spiderCurrPosition +1) < rightBoundary){
                    System.out.println("in eeeeee");
                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition+1);
                    cellSpiderWillMoveTo.setHasSpider(true);
                    ds.setSpiderCurrPosition(spiderCurrPosition+1);
                    cellSpiderWillMoveTo.setSpiderDirection('e');


                }else{
                    System.out.println("here?");
                    currCell.setHasSpider(true);
                }
                System.out.println();
                repaint();


            }else if(o=="turn"){
                char spiderDirection =  ds.getSpiderDirection();
                HashMap<Character, Character> directionLoopUpHashMap= new HashMap<>(){{
                    put('n', 'e');
                    put('e', 's');
                    put('s', 'w');
                    put('w', 'n');
                }};

                ds.setSpiderDirection(directionLoopUpHashMap.get(spiderDirection));
            }else if(o=="paintBlue"){
                currCell.setHasPainted(true);
                currCell.setPaintedColor("blue");
                // TODO: 1. adjust painted square position 2. update corresponding cell data
            }else if(o=="paintRed"){
                currCell.setHasPainted(true);
                currCell.setPaintedColor("red");
            }else if(o=="paintGreen"){
                currCell.setHasPainted(true);
                currCell.setPaintedColor("green");
            }


        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Play")){
            System.out.println("Clicked play");
            updateCellsWithOperationsData();
        }else{
            System.out.println("Clicked reset");
            ds.resetCells();
            problemHelper.load("1");
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);
    }
}
