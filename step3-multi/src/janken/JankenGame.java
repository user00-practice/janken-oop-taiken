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
        // TODO 1：CPU_COUNT 人の CpuPlayer を作って、リスト cpus に追加する
        //   名前は "CPU1"、"CPU2"、"CPU3" … とする（for 文で 1 から CPU_COUNT まで回す）
        //   ヒント：cpus.add(new CpuPlayer("CPU" + i));

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

        // TODO 2：勝った人を決めて、winners に追加する
        //   ① 手の種類が2種類でなければ（全員同じ手 or 3種類ぜんぶ出た）あいこ。
        //      そのまま winners（空のリスト）を返す
        //   ② 2種類のときは、2つの手のうち「もう一方に勝つ（beats）手」が勝ちの手
        //      （kinds から2つの手を取り出すには List<Hand> list = new ArrayList<>(kinds); を使う）
        //   ③ 勝ちの手を出した参加者全員について、addWin() をして winners に追加する

        return winners;
    }

    public Player getYou() {
        return you;
    }

    public List<CpuPlayer> getCpus() {
        return cpus;
    }
}
