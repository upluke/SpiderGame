import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener {


//    Ball ball =new Ball(53, 163, 30, 30);

    private Block fixedMoveBlock;
    private LinkedList<Block> testingBlocks;
//    Block moveBlock = new Block(600, 163, 60, 60, Color.YELLOW, "move");
//
//    Block turnBlock = new Block(600, 263, 60, 60, Color.ORANGE, "turn");
//
//    Block paintBlock = new Block(600, 363, 60, 60, Color.RED, "paint");

    TrashCan trashCan = new TrashCan(40,670,30,50);
    int preX, preY;

    boolean isClickedOut =false;
    public WorkAreaPanel(){
        setPreferredSize(new Dimension(800, getHeight()));
        addMouseListener(this);
        addMouseMotionListener(this);

        fixedMoveBlock = new Block(600, 163, 60, 60, Color.BLACK, "move");
        testingBlocks = new LinkedList<>();
    }

    public void createANewBlock(int x, int y){


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int panelWidth = getWidth();
        int sectionWidth = panelWidth / 3;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, sectionWidth*2, getHeight());
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(sectionWidth*2, 0 , sectionWidth, getHeight());

//        ball.draw(g);
        fixedMoveBlock.draw(g);

        for(Block tb: testingBlocks){
            tb.draw(g);
        }

        trashCan.draw(g);
//        moveBlock.draw(g);
//        turnBlock.draw(g);
//        paintBlock.draw(g);


        DataSource ds = DataSource.getInstance();
//        LinkedList<String> testingOperations =  ds.getTestingOperations();
//        for(String to: testingOperations){
//
//        }
        LinkedList<Block> testingBlocks = ds.getTestingBlocks();
        System.out.println(testingBlocks.size());
        for(Block tb: testingBlocks){
            tb.draw(g);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        preX = (int)(fixedMoveBlock.getX() - e.getX());
        preY = (int)(fixedMoveBlock.getY() - e.getY());
//        System.out.println(preX + " " + preY + "***move block**" +moveBlock.getX() + " " + moveBlock.getY());
        if(fixedMoveBlock.contains(e.getX(), e.getY())){
           // createANewBlock(fixedMoveBlock.getX(), fixedMoveBlock.getY());
            testingBlocks.add(new Block(fixedMoveBlock.getX(), fixedMoveBlock.getY(), 60, 60, Color.BLACK, "move"));


            DataSource ds = DataSource.getInstance();
//            ds.setTestingOperations("move");
//            LinkedList<String> testingOperations = ds.getTestingOperations();
//            System.out.println(testingOperations.size());
            ds.setTestingBlocks(fixedMoveBlock.getX(), fixedMoveBlock.getY(), 60, 60, Color.RED, "move");

            repaint();
        }else{
            isClickedOut=true;
        }



    }

    @Override
    public void mouseDragged(MouseEvent e) {
        DataSource ds = DataSource.getInstance();
        LinkedList<Block> testingBlocks = ds.getTestingBlocks();
        if(!isClickedOut){
//            moveBlock.move(preX+e.getX(), preY+e.getY());
            for (Block tb: testingBlocks){
                tb.move(preX+e.getX(), preY+e.getY());
            }
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!isClickedOut) {
            // Create a new Block with the same properties as fixedMoveBlock
            Block newBlock = new Block(fixedMoveBlock.getX(), fixedMoveBlock.getY(), fixedMoveBlock.getWidth(), fixedMoveBlock.getHeight(), fixedMoveBlock.getColor(), fixedMoveBlock.getBlockValue());

            // Adjust the position of the new block based on mouse release coordinates
            newBlock.move(preX + e.getX(), preY + e.getY());

            // Add the new block to testingBlocks
            testingBlocks.add(newBlock);

            // Repaint the panel to display the new block
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isClickedOut=false;
    }





    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
