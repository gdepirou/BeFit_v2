package fr.gdemau.befit_v2.Model;

public class User {

    private String id;
    private String username;
    private String fullname;



    private Integer difficulty;
    private String bio;

    public User(String id, String username, String fullname, Integer difficulty, String bio) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.difficulty = difficulty;
        this.bio = bio;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
