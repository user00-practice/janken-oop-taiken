package janken;

import java.util.Random;

/**
 * コンピュータの参加者を表すクラス。
 * Player の機能（名前・手・勝った回数）をそのまま受け継ぎ（extends）、
 * 「自分で手を決める」機能だけを追加している。
 */
public class CpuPlayer extends Player {

    private final Random random = new Random();

    public CpuPlayer(String name) {
        super(name);
    }

    /** 手をランダムに決めて、自分の手として設定する。 */
    public void decideHand() {
        // TODO B：3つの手の中から1つをランダムに選んで、setHand で自分の手にする。
        //   Hand.values() で、グー・チョキ・パーが入った配列が手に入る。
        //   random.nextInt(3) で、0〜2 のどれかが手に入る。
    }
}
