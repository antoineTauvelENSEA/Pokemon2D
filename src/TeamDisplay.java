import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TeamDisplay extends JPanel  {
    Image[] imageArray=new Image[6];
    Player player;
    boolean left;

    public TeamDisplay (Player player, boolean left){
        this.left=left;
        this.player=player;
        updateImageArray();

    }

    private void updateImageArray() {
        for (int i=0;i<player.getTeam().pokedex.size();i++){
            imageArray[i]=player.getTeam().pokedex.get(i).getImage();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i=0;i<6;i++){
            if (left){
                int w = imageArray[i].getWidth(null);
                int h = imageArray[i].getHeight(null);
                int x = 100*(i%2);
                int y = 120*(i/2);
                g.drawImage(imageArray[i],x,y,x+w,y+h,w,0,0,h,null);
            }
            else{
                g.drawImage(imageArray[i],100*(i%2),120*(i/2),null);
            }
            g.drawString(player.getTeam().pokedex.get(i).getName(),25+100*(i%2),100+120*(i/2));
        }

    }

}
