package pokemon;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainer.getPokemons().add(pokemon);

                trainers.put(trainerName, trainer);
            } else {
                trainers.get(trainerName).getPokemons().add(pokemon);
            }

            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!line.equals("End")) {

            for (Trainer t : trainers.values()) {
                boolean badgeIncrement = false;
                for (Pokemon pokemon : t.getPokemons()) {
                    if (pokemon.getElement().equals(line) && pokemon.getHealth() > 10) {
                        badgeIncrement = true;
                    }
                }

                if (badgeIncrement) {
                    t.setBadges(t.getBadges() + 1);
                } else {
                    t.loseHealth();
                }
            }

//            String finalLine = line;
//            trainers.values().forEach(t->{
//                t.getPokemons().forEach(p->{
//                    boolean badgeIncrement = false;
//                    if(p.getElement().equals(finalLine))
//                    {
//                        badgeIncrement = true;
//                    }
//
//                    if(badgeIncrement)
//                    {
//                        t.setBadges(t.getBadges()+1);
//                    }else
//                    {
//                        t.loseHealth();
//                    }
//                });
//            });

            line = scanner.nextLine();
        }

        for (int i = 0; i < trainers.values().size(); i++) {
            trainers.values().forEach(Trainer::removePokemons);
        }



        trainers.entrySet().stream().sorted((f, s) -> s.getValue().getBadges().compareTo(f.getValue().getBadges()))
                .forEach(t ->
                        System.out.println(String.format("%s %d %s", t.getValue().getName(), t.getValue().getBadges(), t.getValue().getPokemons().size())));
    }
}
