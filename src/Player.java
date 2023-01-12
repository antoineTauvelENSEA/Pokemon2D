public class Player {
    private String name;
    private PCBox pcBox;
    private Team team;

    public Player(String name, Pokedex pokedex) {
        this.name = name;
        pcBox = new PCBox(10,pokedex);
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

    public void switchFromPCBoxToTeam(int indexPCBox, int indexTeam){
        if(team.pokedex.size()<6){
            team.pokedex.add(indexTeam,pcBox.pokedex.get(indexPCBox));
            pcBox.pokedex.remove(indexPCBox);
        }
        else{
            Pokemon temporaire = team.pokedex.get(indexTeam);
            team.pokedex.set(indexTeam,pcBox.pokedex.get(indexPCBox));
            pcBox.pokedex.set(indexPCBox,temporaire);
        }
    }

    public void switchFromTeamToPCBox(int indexTeam){
        if (indexTeam<team.pokedex.size()){
            pcBox.pokedex.add(team.pokedex.get(indexTeam));
            team.pokedex.remove(indexTeam);
        }
    }

    public void switchInsideTeam(int index1, int index2){
        if (index1<team.pokedex.size() && index2<team.pokedex.size()){
            Pokemon temporaire=team.pokedex.get(index1);
            team.pokedex.set(index1,team.pokedex.get(index2));
            team.pokedex.set(index2,temporaire);
        }
    }

    public Team getTeam() {
        return team;
    }

    public static void main (String[] args){
        Pokedex p = new Pokedex("./data/pokedex.csv");
        Player toto = new Player("Toto",p);
        System.out.println(toto);
        toto.switchInsideTeam(1,5);
        System.out.println(toto);

    }
}
