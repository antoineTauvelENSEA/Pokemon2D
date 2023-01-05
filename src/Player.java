public class Player {
    private String name;
    private PCBox pcBox;
    private Team team;

    public Player(String name, Pokedex pokedex) {
        this.name = name;
        pcBox = new PCBox(20,pokedex);
        team = new Team(6,pcBox);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pcBox=" + pcBox +
                ", team=" + team +
                '}';
    }

    public static void main (String[] args){
        Pokedex p = new Pokedex("./data/pokedex.csv");
        Player toto = new Player("Toto",p);
        System.out.println(toto);
    }
}
