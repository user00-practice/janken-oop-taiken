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
     */
    public List<Player> play(Hand yourHand) {
        you.setHand(yourHand);
        cpu.decideHand();

        // TODO C：勝敗を判定して、勝った人をリストで返す
        //   ・2人の手が同じなら、あいこなので空のリスト List.of() を返す
        //   ・あなたの手が CPU の手に勝つ（beats）なら、you.addWin() をしてから List.of(you) を返す
        //   ・それ以外は、cpu.addWin() をしてから List.of(cpu) を返す
        return List.of();
    }

    public Player getYou() {
        return you;
    }

    public CpuPlayer getCpu() {
        return cpu;
    }
}
