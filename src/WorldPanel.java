import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
        int spiderCurrPosition = ds.getSpiderCurrPosition();

        // calculate left boundary and right boundary
        int leftBoundary =(spiderCurrPosition/5) *(int) Math.sqrt(cells.size()); // leftBoundary <= position
        int rightBoundary = leftBoundary+5; // rightBoundary > position

        for (String o: operations){
            // TODO: 1. check the boundaries 2. modulize main conditional function
            if(o=="move") {
                Cell cell = cells.get(spiderCurrPosition);
                cell.setHasSpider(false);
                char spiderDirection = cell.getSpiderDirection();
                if(spiderDirection =='n' && spiderDirection-5>=0){
                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition - 5);
                    cellSpiderWillMoveTo.setHasSpider(true);
                    repaint();

                }else if(spiderDirection =='s' && spiderDirection+5<cells.size()){
                    Cell cellSpiderWillMoveTO = cells.get(spiderCurrPosition+5);
                    cellSpiderWillMoveTO.setHasSpider(true);
                    repaint();
                }else if(spiderDirection =='w' && spiderDirection-5<4){

                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition-1);
                    cellSpiderWillMoveTo.setHasSpider(true);
                    repaint();
                }else{
                    Cell cellSpiderWillMoveTo = cells.get(spiderCurrPosition+1);
                    cellSpiderWillMoveTo.setHasSpider(true);
                    repaint();
                }
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
