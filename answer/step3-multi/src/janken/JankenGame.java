package janken;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * じゃんけんの進行（手を出す・勝敗を決める）を担当するクラス。
 * STEP3 では、CPU を1人から「CPU_COUNT 人」に増やす。
 */
public class JankenGame {

    /** CPU の人数。ここを変えるだけで人数を変えられるようにする。 */
    public static final int CPU_COUNT = 3;

    private final Player you = new Player("あなた");
    private final List<CpuPlayer> cpus = new ArrayList<>();

    public JankenGame() {
        for (int i = 1; i <= CPU_COUNT; i++) {
            cpus.add(new CpuPlayer("CPU" + i));
        }
    }

    /**
     * あなたの手を受け取ってじゃんけんを1回行い、勝った人のリストを返す。
     * あいこなら空のリストを返す。
     */
    public List<Player> play(Hand yourHand) {
        you.setHand(yourHand);
        for (CpuPlayer cpu : cpus) {
            cpu.decideHand();
        }

        // 参加者全員（あなた＋CPU）を1つのリストにまとめる
        List<Player> players = new ArrayList<>();
        players.add(you);
        players.addAll(cpus);

        // 場に出ている手の種類を集める（Set は、同じものを1つにまとめて覚える）
        Set<Hand> kinds = new HashSet<>();
        for (Player player : players) {
            kinds.add(player.getHand());
        }

        List<Player> winners = new ArrayList<>();

        // ① 手の種類が2種類でなければ、あいこ
        if (kinds.size() != 2) {
            return winners;
        }

        // ② 2つの手のうち、もう一方に勝つ手が「勝ちの手」
        List<Hand> list = new ArrayList<>(kinds);
        Hand first = list.get(0);
        Hand second = list.get(1);
        Hand winHand = first.beats(second) ? first : second;

        // ③ 勝ちの手を出した参加者全員が勝ち
        for (Player player : players) {
            if (player.getHand() == winHand) {
                player.addWin();
                winners.add(player);
            }
        }
        return winners;
    }

    public Player getYou() {
        return you;
    }

    public List<CpuPlayer> getCpus() {
        return cpus;
    }
}
