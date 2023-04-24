import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BattlePanel extends JPanel {
    Pokemon pokemonLeft;
    Pokemon pokemonRight;
    Image versus;
    Image healthPoints;

    public BattlePanel(Pokemon pokemonLeft, Pokemon pokemonRight) {
        super();
        this.pokemonLeft = pokemonLeft;
        this.pokemonRight = pokemonRight;
        try{
            versus = ImageIO.read(new File("./img/versusSmall.png"));
            healthPoints = ImageIO.read(new File("./img/healthGauge.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        int leftHealth = Math.max(11-(int)((pokemonLeft.getHealth()*11)/100),0);
        int rightHealth = Math.max(11-(int)((pokemonRight.getHealth()*11)/100),0);
        g.drawImage(pokemonLeft.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH),0,15,200,230,200,0,0,200,null);
        g.drawImage(pokemonRight.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH),200,15,null);
        g.drawImage(versus,150,50,null);
        g.drawImage(healthPoints,0,75,30,125,
                30*leftHealth,0,30*(leftHealth+1),50,null);
        g.drawImage(healthPoints,370,75,400,125,
                30*rightHealth,0,30*(rightHealth+1),50,null);

    }
}
