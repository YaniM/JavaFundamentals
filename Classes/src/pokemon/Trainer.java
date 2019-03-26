package pokemon;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int badges;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Pokemon> pokemonsToRemove;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
        this.pokemonsToRemove = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void loseHealth() {
        for (Pokemon p : pokemons) {

            p.setHealth(p.getHealth() - 10);

            if (p.getHealth() <= 0) {
                this.getPokemonsToRemove().add(p);
            }
        }

    }

    public ArrayList<Pokemon> getPokemonsToRemove() {
        return pokemonsToRemove;
    }

    public void setPokemonsToRemove(ArrayList<Pokemon> pokemonsToRemove) {
        this.pokemonsToRemove = pokemonsToRemove;
    }

    public void removePokemons() {
        this.getPokemons().removeAll(this.pokemonsToRemove);
    }
}
