import java.util.Random;

public class Team extends Pokedex{
    public Team (int pokemonNumber, Pokedex zoo, boolean removeFromZoo) {
        super();
        Random rd = new Random();
        if (removeFromZoo) {
            for (int i = 0; i < pokemonNumber;i++)
            {
                int index=rd.nextInt(zoo.pokedex.size());
                pokedex.add(zoo.pokedex.get(index));
                zoo.pokedex.remove(index);
            }
        }
        else{
            for (int i = 0; i < pokemonNumber;i++)
            {
                int index=rd.nextInt(zoo.pokedex.size());
                Pokemon toBeClone = zoo.pokedex.get(index);
                try{pokedex.add((Pokemon) toBeClone.clone());}
                catch (Exception e){e.printStackTrace();}
            }

        }
    }
}
