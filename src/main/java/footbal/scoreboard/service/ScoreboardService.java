package footbal.scoreboard.service;

import footbal.scoreboard.Match;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScoreboardService {
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
