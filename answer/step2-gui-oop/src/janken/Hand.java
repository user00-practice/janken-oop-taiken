package janken;

/**
 * じゃんけんの手（グー・チョキ・パー）を表す列挙型。
 */
public enum Hand {
    ROCK("グー"),
    SCISSORS("チョキ"),
    PAPER("パー");

    private final String label;

    Hand(String label) {
        this.label = label;
    }

    /** 画面に表示する名前を返す。 */
    public String getLabel() {
        return label;
    }

    /**
     * この手（this）が、相手の手（other）に勝つなら true を返す。
     */
    public boolean beats(Hand other) {
        return switch (this) {
            case ROCK -> other == SCISSORS;
            case SCISSORS -> other == PAPER;
            case PAPER -> other == ROCK;
        };
    }
}
