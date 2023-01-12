import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pokemon implements Cloneable {
    private int number;
    private String name;
    private String type_1;
    private String type_2;
    private double total;
    private double healthPoint;
    private double attack;
    private double defense;
    private double spAtk;
    private double spDef;
    private double speed;
    private int generation;
    private boolean legendary;
    private Image image;

    public Pokemon(int number, String name, String type_1, String type_2, double total, double healthPoint, double attack, double defense, double spAtk, double spDef, double speed, int generation, boolean legendary) {
        this.number=number;
        this.name = name;
        this.type_1 = type_1;
        this.type_2 = type_2;
        this.total = total;
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
        this.image = null;
    }

    public Image getImage() {
        if (this.image == null)
        {
            try {
                this.image = ImageIO.read(new File("./img/pokemon/"+this.number+".png"));
            }
            catch (IOException e) {
                e.printStackTrace();}
        }
        return image;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "number=" + number +
                "name='" + name + '\'' +
                ", type_1='" + type_1 + '\'' +
                ", type_2='" + type_2 + '\'' +
                ", total=" + total +
                ", healthPoint=" + healthPoint +
                ", legendary=" + legendary +
                '}';
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public void attack(Pokemon p, AttackType a){
        double hitPoint;
        switch (a) {
            case PHYSIQUE:
                hitPoint = Math.max(1,this.attack-p.defense);
                    p.healthPoint=(hitPoint>p.healthPoint)?0:p.healthPoint-hitPoint;
                break;
            case SPECIAL:
                hitPoint = Math.max(1,this.spAtk-p.spDef);
                p.healthPoint=(hitPoint>p.healthPoint)?0:p.healthPoint-hitPoint;
                break;
            case STATUS_ATTACK:
                this.attack+=10;
                break;
            case STATUS_ATTACK_SPE:
                this.spAtk+=10;
                break;
            case STATUS_DEFENSE:
                this.defense+=10;
                break;
            case STATUS_DEFENSE_SPE:
                this.spDef+=10;
                break;
        }

    }
}
