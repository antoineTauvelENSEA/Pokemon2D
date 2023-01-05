import java.util.Random;

public class Team extends Pokedex{
    public Team (int pokemonNumber, Pokedex zoo, boolean removeFromZoo) {
        super();
        Random rd = new Random();
        for (int i = 0; i < pokemonNumber;i++) {
            int index=rd.nextInt(zoo.pokedex.size());
            pokedex.add(zoo.pokedex.get(index));
            zoo.pokedex.remove(index);
            }
        }
    }
}
