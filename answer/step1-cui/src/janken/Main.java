package janken;

import java.util.Random;
import java.util.Scanner;

/**
 * STEP1：コンソールで遊ぶじゃんけんゲーム。
 * クラスを分けずに、main メソッドの中に if 文・switch 文・繰り返しだけで書く。
 * 手は数字で表す（0：グー、1：チョキ、2：パー）。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int winCount = 0;    // 勝った回数
        int loseCount = 0;   // 負けた回数
        int drawCount = 0;   // あいこの回数

        System.out.println("じゃんけんゲーム（CUI版）");

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
            int player = Integer.parseInt(input);   // あなたの手

            // TODO 1：コンピュータの手を決める
            int cpu = random.nextInt(3);

            // TODO 2：2人の手を表示する（同じ switch 文を2回書くことになる）
            String playerName;
            switch (player) {
                case 0 -> playerName = "グー";
                case 1 -> playerName = "チョキ";
                default -> playerName = "パー";
            }
            String cpuName;
            switch (cpu) {
                case 0 -> cpuName = "グー";
                case 1 -> cpuName = "チョキ";
                default -> cpuName = "パー";
            }
            System.out.println("あなた：" + playerName + "　コンピュータ：" + cpuName);

            // TODO 3：勝ち・負け・あいこを判定して表示し、回数を数える
            if (player == cpu) {
                System.out.println("あいこ");
                drawCount++;
            } else if ((player == 0 && cpu == 1) || (player == 1 && cpu == 2) || (player == 2 && cpu == 0)) {
                System.out.println("あなたの勝ち！");
                winCount++;
            } else {
                System.out.println("あなたの負け");
                loseCount++;
            }
        }

        System.out.println("成績：" + winCount + "勝 " + loseCount + "敗 " + drawCount + "分");
    }
}
