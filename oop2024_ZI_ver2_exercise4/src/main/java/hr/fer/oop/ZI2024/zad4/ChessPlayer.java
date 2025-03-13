package hr.fer.oop.ZI2024.zad4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public static Stream<ChessPlayer> getGoodChessPlayers(List<ChessPlayer> lplayers, int ratingthreshold){
        List<ChessPlayer> list = lplayers.stream().filter(chessPlayer -> chessPlayer.getRating()>ratingthreshold).sorted(Comparator.comparing(ChessPlayer::getBirthyear)).toList();
        return list.stream();
    }

    public static double getAvgRating(Stream<ChessPlayer> cpstream, Country country){
        return cpstream.filter(chessPlayer -> chessPlayer.getCountry() == country).collect(Collectors.averagingInt(ChessPlayer::getRating));
    }

    public static String getFilteredPlayers(Stream<ChessPlayer> cpstream, Predicate<ChessPlayer> filter){
        StringBuilder sb = new StringBuilder("");
        List<ChessPlayer> list = cpstream.filter(filter).toList();
        for (ChessPlayer chessPlayer : list.reversed()){
            sb.append(chessPlayer.getLastname()).append(", ").append(chessPlayer.getFirstname()).append("; ");
        }
        return sb.replace(sb.length()-2, sb.length(), "").toString();
    }
    public static Map<Country, Integer> getMaxRatingForCountry(Stream<ChessPlayer> cpstream){
        Map<Country, Integer> map = new HashMap<>();
        List<ChessPlayer> list = cpstream.toList();
        for (ChessPlayer chessPlayer : list){
            if (!map.containsKey(chessPlayer.getCountry()) || map.get(chessPlayer.getCountry()) < chessPlayer.getRating()){
                map.put(chessPlayer.getCountry(), chessPlayer.getRating());
            }
        }
        return map;
    }
    public static final Comparator<ChessPlayer> BY_LAST_NAME = Comparator.comparing(ChessPlayer::getLastname);
    public static final Comparator<ChessPlayer> BY_FIRST_NAME = Comparator.comparing(ChessPlayer::getFirstname);
    public static final Comparator<ChessPlayer> BY_BIRTHYEAR = Comparator.comparing(ChessPlayer::getBirthyear).reversed();

    public static final Comparator<ChessPlayer> comparator = BY_LAST_NAME.thenComparing(BY_FIRST_NAME).thenComparing(BY_BIRTHYEAR);
}
