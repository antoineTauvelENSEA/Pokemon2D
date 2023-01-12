import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TeamDisplay extends JPanel {
    Image exemple;
    Pokedex p = new Pokedex("./data/pokedex.csv");
    Player toto = new Player("Toto",p);

    public TeamDisplay (){
        exemple=toto.getTeam().pokedex.get(0).getImage();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(exemple,0,0,null);

    }
}
