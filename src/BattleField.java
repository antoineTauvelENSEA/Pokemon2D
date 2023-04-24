import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleField extends JFrame implements ActionListener {
    Player playerLeft;
    Player playerRight;
    BattlePanel battlePanel;
    JPanel buttonPanel;
    JButton[] buttons = new JButton[6];
    final Color[] colors = {Color.BLUE, Color.RED, Color.GREEN};
    final String[] action = {"Special Attack","Attack","Status","Special Attack","Attack","Status"};
    public BattleField(Player playerLeft, Player playerRight) throws HeadlessException {
        super("Battle Field");
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;

        this.setSize(420,250);

        battlePanel = new
                BattlePanel(playerLeft.getTeam().getPokedex().get(0),
                playerRight.getTeam().getPokedex().get(0));

        this.add(battlePanel);

        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(1,6));
        for (int i=0;i<6;i++){
            buttons[i]=new JButton(action[i]);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(colors[i%3]);
            buttonPanel.add(buttons[i]);
        }
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}
