import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game(){
      super("Final test");

      JPanel header = new JPanel();
      WorldPanel worldPanel = new WorldPanel();

      WorkAreaPanel workAreaPanel = new WorkAreaPanel();
      worldPanel.setPreferredSize(new Dimension(400, 800));
      add(header);
      add(worldPanel);
      add(workAreaPanel);

      add(header, BorderLayout.NORTH);
      add(worldPanel, BorderLayout.CENTER);
      add(workAreaPanel, BorderLayout.EAST);

    }

    public static void main(String[] args){
        Game win =new Game();
        win.setSize(1400, 800);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
