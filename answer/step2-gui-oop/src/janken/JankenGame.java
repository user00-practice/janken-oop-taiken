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

        if (you.getHand() == cpu.getHand()) {
            return null;
        }
        if (you.getHand().beats(cpu.getHand())) {
            you.addWin();
            return you;
        }
        cpu.addWin();
        return cpu;
    }

    public Player getYou() {
        return you;
    }

    public CpuPlayer getCpu() {
        return cpu;
    }
}
