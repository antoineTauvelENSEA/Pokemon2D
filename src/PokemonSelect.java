import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PokemonSelect extends JFrame implements ActionListener, MouseListener {
    JButton battleButton;
    JLabel label;
    int dummy=0;
    TeamDisplay[] teamDisplay=new TeamDisplay[2];
    JPanel arena=new JPanel();
    Player player1;
    Player player2;

    public PokemonSelect(Player player1, Player player2) {
        super("Pokemon select interface");
        this.player1=player1;
        this.player2=player2;
        this.setSize(700, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        battleButton = new JButton("Battle");
        battleButton.setBounds(275, 350,100,50);
        label = new JLabel("Bonjour tout le monde");
        this.add(battleButton);
        this.add(label);
        battleButton.addActionListener(this);
        this.addMouseListener(this);
        arena.setLayout(new GridLayout(1,2));

        teamDisplay[0] = new TeamDisplay(player1,true);
        arena.add(teamDisplay[0]);

        teamDisplay[1] = new TeamDisplay(player2,false);
        arena.add(teamDisplay[1]);

        this.add(arena);

        this.setVisible(true);

    }

    public static void main(String[] args){
        Pokedex p = new Pokedex("./data/pokedex.csv");
        Player player1 = new Player("Ash",p);
        Player player2 = new Player("Red",p);

        PokemonSelect gui = new PokemonSelect(player1,player2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dummy++;
        System.out.println("click");
        label.setText("You clicked "+dummy+" times");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e);
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

