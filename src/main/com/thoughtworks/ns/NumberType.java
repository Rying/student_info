package com.thoughtworks.ns;

public enum NumberType {
    ARABIC(new ArabicScore()), ROMA(new RomaScore());

    private Score scoreClass;

    NumberType(Score score) {
        this.scoreClass = score;
    }

    public Score getScoreFinder() {
        return scoreClass;
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

    private static class ArabicScore implements Score {
        @Override
        public String getScore(int originalScore) {
            return String.valueOf(originalScore);
        }
    }

    private static class RomaScore implements Score {
        @Override
        public String getScore(int originalScore) {
            return getRomaScore(originalScore);
        }
    }
}
