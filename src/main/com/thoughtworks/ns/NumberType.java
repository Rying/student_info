package com.thoughtworks.ns;

public enum NumberType {
    ARABIC(new ArabicScoreRepresentation()), ROMA(new RomaScoreRepresentation());

    private ScoreRepresentation scoreRepresentationFinder;

    NumberType(ScoreRepresentation scoreRepresentation) {
        this.scoreRepresentationFinder = scoreRepresentation;
    }

    public ScoreRepresentation scoreFinder() {
        return scoreRepresentationFinder;
    }

    private static String getRomaScore(int score1) {
        String[][] RomaNumbers = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XCC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}};
        String RomaScore = "";
        int factor, digit = 2;

        for (factor = 100; factor > 0; factor /= 10) {
            RomaScore += RomaNumbers[digit][(score1 / factor) % 10];
            digit--;
        }

        return RomaScore;
    }

    private static class ArabicScoreRepresentation implements ScoreRepresentation {
        @Override
        public String score(int originalScore) {
            return String.valueOf(originalScore);
        }
    }

    private static class RomaScoreRepresentation implements ScoreRepresentation {
        @Override
        public String score(int originalScore) {
            return getRomaScore(originalScore);
        }
    }
}
