import java.awt.*;

public class TrashCan {

    Rectangle bounds;
    public TrashCan(int x, int y, int w, int h){
        bounds= new Rectangle(x, y, w, h);
    }

    public void draw(Graphics g){
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        int x = (int) bounds.getX();
        int y = (int) bounds.getY();
        // lid
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x - 5, y - 5, width + 10, 8);

        // trashcan body
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, width, height);

        // vertical lines
        g.setColor(Color.BLACK);
        int lineSpacing = width / 6;
        for (int i = 1; i <= 5; i++) {
            int lineX = x + i * lineSpacing;
            g.drawLine(lineX, y, lineX, y + height);
        }
    }


    public boolean isBlockOnTrashCan(Ball ball){
        if(bounds.contains(ball.getX(), ball.getY())){
            System.out.println("1");
            return true;
        }
        return false;

    }




}
