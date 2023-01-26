import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonSelect extends JFrame implements ActionListener {
    JButton battleButton;
    JLabel label;
    TeamDisplay[] teamDisplay=new TeamDisplay[2];
    JPanel arena=new JPanel();
    Player player1;
    Player player2;
    BattleField battleField=null;

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

        arena.setLayout(new GridLayout(1,2));

        teamDisplay[0] = new TeamDisplay(player1,true);
        arena.add(teamDisplay[0]);

        teamDisplay[1] = new TeamDisplay(player2,false);
        arena.add(teamDisplay[1]);

        this.add(arena);

        this.setVisible(true);

        Timer timer = new Timer(100,this::actionPerformed);
        timer.start();

    }

    public static void main(String[] args){
        Pokedex p = new Pokedex("./data/pokedex.csv");
        Player player1 = new Player("Ash",p);
        Player player2 = new Player("Red",p);

        PokemonSelect gui = new PokemonSelect(player1,player2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()!=null) {
            battleField=new BattleField(player1,player2);
        }
        else{
            this.repaint();}
    }


}

