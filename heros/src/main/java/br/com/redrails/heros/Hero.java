package br.com.redrails.heros;

/**
 * Criado por luiz em 10/04/14.
 * Todos os direitos reservados para RedRails
 */
public class Hero {
    private long id;
    private String name;
    private String favoriteSkill;
    private String ultimateSkill;
    private Double rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteSkill() {
        return favoriteSkill;
    }

    public void setFavoriteSkill(String favoriteSkill) {
        this.favoriteSkill = favoriteSkill;
    }

    public String getUltimateSkill() {
        return ultimateSkill;
    }

    public void setUltimateSkill(String ultimateSkill) {
        this.ultimateSkill = ultimateSkill;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String toString(){
        return this.name;
    }
}
