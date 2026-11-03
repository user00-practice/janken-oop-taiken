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
        // TODO A：グーはチョキに、チョキはパーに、パーはグーに勝つ。
        //   switch式で「この手（this）」ごとに分けて、other が勝てる相手の手かどうかを返す。
        //   例：case ROCK -> other == SCISSORS;
        return false;
    }
}
