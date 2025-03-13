package footbal.scoreboard.service;

import footbal.scoreboard.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScoreboardService {
    public static final String MATCH_INDEX_IS_OUT_OF_RANGE = "Match index is out of range.";
    public static final String CANNOT_BE_NULL_OR_EMPTY = "Team names cannot be null or empty";
    public static final String CANNOT_BE_NEGATIVE = "Scores cannot be negative.";
    public static final String ALREADY_EXISTS = "A match with one of the teams already exists.";

    //CopyOnWriteArrayList allows for safe iteration and modification of the list without explicit synchronization,
    //although it does incur a performance penalty on write operations since it creates a new copy upon modification.
    private final CopyOnWriteArrayList<Match> matches = new CopyOnWriteArrayList<>();

    public List<Match> getMatches() {
        return new ArrayList<>(matches);
    }

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam));
    }

    public void updateScore(int matchIndex, int homeScore, int awayScore) {
        validateMatchIndex(matchIndex);
        matches.get(matchIndex).updateScore(homeScore, awayScore);
    }

    public void finishMatch(int index) {
        validateMatchIndex(index);
        matches.remove(index);
    }

    private void validateMatchIndex(int index) {
    }

    public List<String> getFormatedSortedSummary() {
        return Collections.emptyList();
    }

    public List<Match> getSortedMatches() {
        return sortMatches();
    }

    private List<Match> sortMatches() {
        return new ArrayList<>(matches);
    }

    public void reset() {
        matches.clear();
    }
}
