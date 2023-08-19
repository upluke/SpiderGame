import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener {
    Ball ball =new Ball(53, 163, 30, 30);;
    TrashCan trashCan = new TrashCan(40,670,30,50);;

    Block moveBlock = new Block(600, 163, 60, 60);
    int preX, preY;

    boolean isClickedOut =false;
    public WorkAreaPanel(){
        setPreferredSize(new Dimension(800, getHeight()));
//        setBackground(Color.GRAY);
        addMouseListener(this);
        addMouseMotionListener(this);
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

        ball.draw(g);
        trashCan.draw(g);
        moveBlock.draw(g);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        preX = (int)(ball.getX() - e.getX());
        preY = (int)(ball.getY() - e.getY());
        System.out.println(preX + " " + preY + "*****" +ball.getX() + " " + ball.getY());
        if(ball.contains(e.getX(), e.getY())){
            System.out.println("in");
            ball.move(preX+ e.getX(), preY+ e.getY());
            repaint();
        }else{
            isClickedOut=true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!isClickedOut){

            ball.move(preX+e.getX(), preY+e.getY());
            repaint();
        }

        if(trashCan.isBlockOnTrashCan(ball)){

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
