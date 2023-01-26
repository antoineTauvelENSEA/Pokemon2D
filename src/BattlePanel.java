import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BattlePanel extends JPanel {
    Pokemon pokemonLeft;
    Pokemon pokemonRight;
    Image versus;

    public BattlePanel(Pokemon pokemonLeft, Pokemon pokemonRight) {
        super();
        this.pokemonLeft = pokemonLeft;
        this.pokemonRight = pokemonRight;
        try{
            versus = ImageIO.read(new File("./img/versusSmall.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(pokemonLeft.getImage(),0,30,100,130,100,0,0,100,null);
        g.drawImage(pokemonRight.getImage(),150,30,null);
        g.drawImage(versus,110,45,null);
    }
}
