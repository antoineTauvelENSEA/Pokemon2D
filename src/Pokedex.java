import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Pokedex {
    protected ArrayList<Pokemon> pokedex= new ArrayList<>();

    public ArrayList<Pokemon> getPokedex() {
        return pokedex;
    }

    public Pokedex (){

    }

    public Pokedex (String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line=br.readLine();
            line=br.readLine();
            do{
                String fields[] = new String[12];
                fields=line.split(",");
                pokedex.add(new Pokemon(Integer.parseInt(fields[0]),
                        fields[1],fields[2],
                        fields[3],Double.parseDouble(fields[4]),
                        Double.parseDouble(fields[5]),Double.parseDouble(fields[6]),
                        Double.parseDouble(fields[7]),Double.parseDouble(fields[8]),
                        Double.parseDouble(fields[9]),Double.parseDouble(fields[10]),
                        Integer.parseInt(fields[11]),fields[12].equals("True")));
                line=br.readLine();
            }while (line != null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Pokemon findByNumber(int number){
        for (Pokemon poke : pokedex){
            if (poke.getNumber()==number) return poke;
        }
        return null;
    }

    @Override
    public String toString() {
        String retour="";
        for (Pokemon p : pokedex){
            retour=retour + p + "\n";
        }
        return retour;
    }
}
