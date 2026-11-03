package janken;

import java.util.List;

/**
 * じゃんけんの進行（手を出す・勝敗を決める）を担当するクラス。
 */
public class JankenGame {

    private final Player you = new Player("あなた");
    private final CpuPlayer cpu = new CpuPlayer("CPU");

    /**
     * あなたの手を受け取ってじゃんけんを1回行い、勝った人のリストを返す。
     * あいこなら、勝った人が0人なので空のリストを返す。
     * （「該当なし」を null で表すと、呼び出す側がチェックを忘れたときにエラーになるので使わない）
     */
    public List<Player> play(Hand yourHand) {
        you.setHand(yourHand);
        cpu.decideHand();

        if (you.getHand() == cpu.getHand()) {
            return List.of();
        }
        if (you.getHand().beats(cpu.getHand())) {
            you.addWin();
            return List.of(you);
        }
        cpu.addWin();
        return List.of(cpu);
    }

    public Player getYou() {
        return you;
    }

    public CpuPlayer getCpu() {
        return cpu;
    }
}
