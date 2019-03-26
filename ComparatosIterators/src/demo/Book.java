package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book o) {
       //int titleCompare = this.getTitle().compareTo(o.getTitle());

       if(this.getTitle().compareTo(o.getTitle())>0){
           return 1;
       }else if(this.getTitle().compareTo(o.getTitle())<0){
           return -1;
       }else{
           return this.getYear()-o.getYear();
       }
       //return titleCompare !=0 ? titleCompare : this.getYear()-o.getYear();
    }
}
