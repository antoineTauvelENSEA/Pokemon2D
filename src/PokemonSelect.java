import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PokemonSelect extends JFrame implements ActionListener {
    JButton OKButton;
    JLabel label;
    int dummy=0;

    Image exemple;


    public PokemonSelect() {
        super("Pokemon select interface");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        OKButton = new JButton("OK");
        OKButton.setBounds(275, 290,100,50);
        label = new JLabel("Bonjour tout le monde");
        this.add(OKButton);
        this.add(label);
        this.setVisible(true);
        OKButton.addActionListener(this);
        try {
            exemple = ImageIO.read(new File("./img/pokemon/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.getGraphics().drawImage(exemple,100,100,null);
    }

    public static void main(String[] args){
        PokemonSelect gui = new PokemonSelect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dummy++;
        System.out.println("click");
        label.setText("You clicked "+dummy+" times");
    }
}

