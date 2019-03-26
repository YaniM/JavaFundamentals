package google;

public class Parent {
    private String name;
    private String birthDate;

    public Parent(String name,String date){
        this.name=name;
        this.birthDate=date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n",this.getName(),this.getBirthDate());
    }
}
