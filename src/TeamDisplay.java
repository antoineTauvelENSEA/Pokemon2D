import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TeamDisplay extends JPanel implements MouseListener {
    Image[] imageArray=new Image[6];
    Player player;
    boolean left;

    int pokemonSelected=0;
    boolean selectionStarted=false;

    public TeamDisplay (Player player, boolean left){
        this.left=left;
        this.player=player;
        updateImageArray();
        this.addMouseListener(this);
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
            int w = imageArray[i].getWidth(null);
            int h = imageArray[i].getHeight(null);
            int x = 100*(i%2);
            int y = 120*(i/2);
            if (left){
                 g.drawImage(imageArray[i],x,y,x+w,y+h,w,0,0,h,null);
            }
            else{
                g.drawImage(imageArray[i],x,y,null);
            }
            if (selectionStarted && i==pokemonSelected){
                g.setColor(Color.RED);
                g.drawRect(x,y,w,90);
                g.drawString(player.getTeam().pokedex.get(i).getName(),25+100*(i%2),100+120*(i/2));
                g.setColor(Color.BLACK);
            }
            else{
                g.drawString(player.getTeam().pokedex.get(i).getName(),25+100*(i%2),100+120*(i/2));
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==1){
            if(e.getX()<200 && e.getY()<360){
                int pokemonNumber=(e.getX()/100)+2*(e.getY()/120);
                System.out.println(pokemonNumber);
                if(!selectionStarted){
                    selectionStarted=true;
                    pokemonSelected=pokemonNumber;
                    this.repaint();
                }
                else{
                    selectionStarted=false;
                    player.switchInsideTeam(pokemonSelected,pokemonNumber);
                    this.updateImageArray();
                    this.repaint();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
