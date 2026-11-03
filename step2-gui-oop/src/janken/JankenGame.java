package janken;

/**
 * じゃんけんの進行（手を出す・勝敗を決める）を担当するクラス。
 */
public class JankenGame {

    private final Player you = new Player("あなた");
    private final CpuPlayer cpu = new CpuPlayer("CPU");

    /**
     * あなたの手を受け取ってじゃんけんを1回行い、勝った人を返す。あいこなら null を返す。
     */
    public Player play(Hand yourHand) {
        you.setHand(yourHand);
        cpu.decideHand();

        // TODO C：勝敗を判定する
        //   ・2人の手が同じなら、あいこなので null を返す
        //   ・あなたの手が CPU の手に勝つ（beats）なら、you.addWin() をしてから you を返す
        //   ・それ以外は、cpu.addWin() をしてから cpu を返す
        return null;
    }

    public Player getYou() {
        return you;
    }

    public CpuPlayer getCpu() {
        return cpu;
    }
}
