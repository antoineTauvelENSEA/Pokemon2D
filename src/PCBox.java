import java.util.Random;

public class PCBox extends Pokedex{
    public PCBox (int pokemonNumber, Pokedex zoo) {
        super();
        Random rd = new Random();
        for (int i = 0; i < pokemonNumber; i++) {
            int index = rd.nextInt(zoo.pokedex.size());
            Pokemon toBeClone = zoo.pokedex.get(index);
            try {
                pokedex.add((Pokemon) toBeClone.clone());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
