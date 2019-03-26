package google;

public class Children {
    private String name;
    private String birthDate;

    public Children(String name,String birthDate)
    {
        this.name=name;
        this.birthDate=birthDate;
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
