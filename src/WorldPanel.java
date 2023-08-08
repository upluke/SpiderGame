import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Timer;

public class WorldPanel extends JPanel implements ActionListener {
    private World world;

    public WorldPanel(){
        ProblemHelper problemHelper=new ProblemHelper();
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
        DataSource ds = DataSource.getInstance();
        LinkedList<String> operations =  ds.getOperations();
        LinkedList<Cell> cells= ds.getCells();
        Spider spider = new Spider();


        for (String o: operations){
            int spiderCurrPosition = ds.getSpiderCurrPosition();

            // calculate left boundary and right boundary
            int leftBoundary =(spiderCurrPosition/5) *(int) Math.sqrt(cells.size()); // leftBoundary <= position
            int rightBoundary = leftBoundary+5; // rightBoundary > position
            // TODO: 1. set and test n s  2. modulize main conditional function
            if(o=="move") {
                System.out.println("in in ");
                Cell currCell = cells.get(spiderCurrPosition);
                currCell.setHasSpider(false);
                char spiderDirection = currCell.getSpiderDirection();
                System.out.println(spiderDirection + " - " + spiderCurrPosition);


                if(spiderDirection =='n' && spiderCurrPosition-5>=0){
                    System.out.println("in nnnnnn");
                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition - 5);
                    cellSpiderWillMoveTo.setHasSpider(true);

                }else if(spiderDirection =='s' && spiderCurrPosition+5<cells.size()){
                    System.out.println("in ssssss");
                    Cell cellSpiderWillMoveTO = cells.get(spiderCurrPosition+5);
                    cellSpiderWillMoveTO.setHasSpider(true);

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
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);
    }
}
