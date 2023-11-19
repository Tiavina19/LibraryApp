package model;

public class Author {
    private int authorId;
    private String name;
    private char gender;

    public Author(int authorId, String name, char gender) {
        this.authorId = authorId;
        this.name = name;
        this.gender = gender;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
