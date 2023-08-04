import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Play")){
            System.out.println("Clicked play");
            world.updateCellsWithOperationsData();
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
