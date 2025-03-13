package hr.fer.oop.ZI2024.zad2;

import java.util.Comparator;
import java.util.Objects;

public class ChessPlayer {
    private String firstname;
    private String lastname;
    private Country country;

    private int rating;
    private int birthyear;

    public ChessPlayer(String firstname, String lastname, Country country, int rating, int birthyear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.rating = rating;
        this.birthyear = birthyear;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Country getCountry() {
        return country;
    }

    public int getRating() {
        return rating;
    }

    public int getBirthyear() {
        return birthyear;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s %s %d: %d", country, firstname, lastname, birthyear, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPlayer that = (ChessPlayer) o;
        return rating == that.rating && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, rating);
    }

    public static final Comparator<ChessPlayer> BY_LASTNAME = Comparator.comparing(ChessPlayer::getLastname);
    public static final Comparator<ChessPlayer> BY_FIRSTNAME = Comparator.comparing(ChessPlayer::getFirstname);
    public static final Comparator<ChessPlayer> BY_RATING = Comparator.comparing(ChessPlayer::getRating);

    public static final Comparator<ChessPlayer> comparator = BY_LASTNAME.thenComparing(BY_FIRSTNAME).thenComparing(BY_RATING);
}
