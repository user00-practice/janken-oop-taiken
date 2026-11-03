package janken;

/**
 * じゃんけんの参加者を表すクラス。
 * 名前・今出している手・勝った回数を、参加者1人ごとに自分で覚えておく。
 */
public class Player {

    private final String name;
    private Hand hand;
    private int winCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getWinCount() {
        return winCount;
    }

    /** 勝った回数を1増やす。 */
    public void addWin() {
        winCount++;
    }
}
