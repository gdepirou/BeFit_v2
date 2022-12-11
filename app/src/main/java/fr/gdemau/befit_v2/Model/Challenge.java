package fr.gdemau.befit_v2.Model;

import android.media.Image;

public class Challenge {
    private String challenge_name;
    private String challenge_number;
    private Integer challenge_image;
    private Integer challenge_difficulty;

    public void setChallenge_image(Integer challenge_image) {
        this.challenge_image = challenge_image;
    }

    public void setChallenge_difficulty(Integer challenge_difficulty) {
        this.challenge_difficulty = challenge_difficulty;
    }

    public Challenge(String challenge_name, String challenge_number, Integer challenge_image, Integer challenge_difficulty) {
        this.challenge_name = challenge_name;
        this.challenge_number = challenge_number;
        this.challenge_image = challenge_image;
        this.challenge_difficulty = challenge_difficulty;

    }

    public String getChallenge_name() {
        return challenge_name;
    }

    public void setChallenge_name(String challenge_name) {
        this.challenge_name = challenge_name;
    }

    public String getChallenge_number() {
        return challenge_number;
    }

    public void setChallenge_number(String challenge_number) {
        this.challenge_number = challenge_number;
    }

    public Integer getChallenge_image() {
        return challenge_image;
    }

    public Integer getChallenge_difficulty() {
        return challenge_difficulty;
    }
}
