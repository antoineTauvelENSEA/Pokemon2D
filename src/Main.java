public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");
        Pokemon p1 = new Pokemon (1024,"Tauvelosaur", "Informaticien",
                                    "prof", 100,15,10,50,
                                    12, 15, 0, -1, false);
        System.out.println(p1.toString());
        Pokedex p = new Pokedex("./data/pokedex.csv");
     /*   for (Pokemon poke : p.getPokedex()){
            System.out.println("Pokemon :"+poke);
        }*/
        Pokemon p3 = p.findByNumber(151);
        Pokemon p2 = p.findByNumber(150);

        System.out.println(p3);
        System.out.println(p2);

        p3.attack(p2,AttackType.STATUS_ATTACK);
        p3.attack(p2,AttackType.STATUS_ATTACK);
        p3.attack(p2,AttackType.PHYSIQUE);
        p3.attack(p2,AttackType.PHYSIQUE);
        p3.attack(p2,AttackType.PHYSIQUE);
        p3.attack(p2,AttackType.SPECIAL);
        p3.attack(p2,AttackType.SPECIAL);

        System.out.println(p3);
        System.out.println(p2);

        PCBox pcBox = new PCBox(20,p);
        Team team = new Team(6,pcBox);

    }
}
