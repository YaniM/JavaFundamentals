package google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private ArrayList<Parent> parents = new ArrayList<>();
    private ArrayList<Children> children  = new ArrayList<>();
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Person(String name,Company company){
        this.name=name;
        this.company=company;
    }

    public Person(String name,Car car){
        this.name=name;
        this.car=car;
    }

    public Person(String name){
        this.name=name;
        this.parents= new ArrayList<>();
        this.children= new ArrayList<>();
        this.pokemons= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("\n");

        sb.append("Company:\n");
        if(this.getCompany()!=null){
            sb.append(this.getCompany().toString());
        }

        sb.append("Car:\n");
        if(this.getCar()!=null)
        {
            sb.append(this.getCar().toString());
        }

        sb.append("Pokemon:\n");
        if(this.getPokemons().size()!=0)
        {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }

        sb.append("Parents:\n");
        if(this.getParents().size()!=0)
        {
            for (Parent parent : parents) {
                sb.append(parent.toString());
            }
        }

        sb.append("Children:\n");
        if(this.getChildren().size()!=0)
        {
            for (Children child : children) {
                sb.append(child.toString());
            }
        }
        return sb.toString();

    }
}
