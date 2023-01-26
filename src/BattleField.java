import javax.swing.*;
import java.awt.*;

public class BattleField extends JFrame {
    Player playerLeft;
    Player playerRight;
    BattlePanel battlePanel;
    public BattleField(Player playerLeft, Player playerRight) throws HeadlessException {
        super("Battle Field");
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;

        battlePanel = new
                BattlePanel(playerLeft.getTeam().getPokedex().get(0),
                playerRight.getTeam().getPokedex().get(0));

        this.add(battlePanel);

        this.setSize(300,200);
        this.setVisible(true);


    }
}
