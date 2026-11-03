package janken;

import java.util.Random;
import java.util.Scanner;

/**
 * 講師デモ用：STEP1 の CUI 版を「あなた＋CPU 3人」に無理やり拡張したもの。
 *
 * クラスを使わずに制御構造だけで人数を増やすと、どうなるかを見せるためのコード。
 * 「★」の付いた行が、CPU をもう1人（4人目）増やすときに書き足し・書き直しが必要な場所。
 * OOP 版（step3-multi）では、JankenGame の CPU_COUNT を 3 → 4 にするだけで済む。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 参加者ごとに「勝った回数」の変数が必要になる
        int playerWin = 0;
        int cpu1Win = 0;                                                   // ★
        int cpu2Win = 0;                                                   // ★
        int cpu3Win = 0;                                                   // ★
        int drawCount = 0;

        System.out.println("じゃんけんゲーム（CUI版・CPU 3人）");

        while (true) {
            System.out.print("手を選んでください（0：グー 1：チョキ 2：パー 9：終了）> ");
            String input = scanner.nextLine().trim();
            if (input.equals("9")) {
                break;
            }
            if (!(input.equals("0") || input.equals("1") || input.equals("2"))) {
                System.out.println("0、1、2、9 のどれかを入力してください");
                continue;
            }
            int player = Integer.parseInt(input);

            // CPU ごとに手の変数が必要になる
            int cpu1 = random.nextInt(3);                                  // ★
            int cpu2 = random.nextInt(3);                                  // ★
            int cpu3 = random.nextInt(3);                                  // ★

            // 手の表示：同じ switch 文を人数分コピーすることになる
            String playerName;
            switch (player) {
                case 0 -> playerName = "グー";
                case 1 -> playerName = "チョキ";
                default -> playerName = "パー";
            }
            String cpu1Name;                                               // ★
            switch (cpu1) {                                                // ★
                case 0 -> cpu1Name = "グー";                               // ★
                case 1 -> cpu1Name = "チョキ";                             // ★
                default -> cpu1Name = "パー";                              // ★
            }                                                              // ★
            String cpu2Name;                                               // ★
            switch (cpu2) {                                                // ★
                case 0 -> cpu2Name = "グー";                               // ★
                case 1 -> cpu2Name = "チョキ";                             // ★
                default -> cpu2Name = "パー";                              // ★
            }                                                              // ★
            String cpu3Name;                                               // ★
            switch (cpu3) {                                                // ★
                case 0 -> cpu3Name = "グー";                               // ★
                case 1 -> cpu3Name = "チョキ";                             // ★
                default -> cpu3Name = "パー";                              // ★
            }                                                              // ★
            System.out.println("あなた：" + playerName + "　CPU1：" + cpu1Name
                    + "　CPU2：" + cpu2Name + "　CPU3：" + cpu3Name);         // ★

            // 場に出ている手の種類を調べる：全員の手を1つずつ調べる条件が並ぶ
            boolean hasRock = player == 0 || cpu1 == 0 || cpu2 == 0 || cpu3 == 0;          // ★
            boolean hasScissors = player == 1 || cpu1 == 1 || cpu2 == 1 || cpu3 == 1;      // ★
            boolean hasPaper = player == 2 || cpu1 == 2 || cpu2 == 2 || cpu3 == 2;         // ★
            int kinds = (hasRock ? 1 : 0) + (hasScissors ? 1 : 0) + (hasPaper ? 1 : 0);

            if (kinds != 2) {
                System.out.println("あいこ");
                drawCount++;
                continue;
            }

            // 勝ちの手を決める
            int winHand;
            if (!hasPaper) {
                winHand = 0;          // グーとチョキ → グーの勝ち
            } else if (!hasRock) {
                winHand = 1;          // チョキとパー → チョキの勝ち
            } else {
                winHand = 2;          // パーとグー → パーの勝ち
            }

            // 勝ちの手を出した人を、1人ずつ調べて数える
            String winners = "";
            if (player == winHand) {
                playerWin++;
                winners += "あなた ";
            }
            if (cpu1 == winHand) {                                         // ★
                cpu1Win++;                                                 // ★
                winners += "CPU1 ";                                        // ★
            }                                                              // ★
            if (cpu2 == winHand) {                                         // ★
                cpu2Win++;                                                 // ★
                winners += "CPU2 ";                                        // ★
            }                                                              // ★
            if (cpu3 == winHand) {                                         // ★
                cpu3Win++;                                                 // ★
                winners += "CPU3 ";                                        // ★
            }                                                              // ★
            System.out.println(winners + "の勝ち！");
        }

        System.out.println("成績：あなた " + playerWin + "勝　CPU1 " + cpu1Win + "勝　CPU2 " + cpu2Win   // ★
                + "勝　CPU3 " + cpu3Win + "勝　あいこ " + drawCount + "回");                          // ★
    }
}
