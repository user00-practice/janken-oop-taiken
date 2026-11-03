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
            //   0〜2 のどれかをランダムに選んで、変数 cpu に入れる（random.nextInt(3) を使う）
            int cpu = 0;

            // TODO 2：2人の手を「あなた：グー　コンピュータ：パー」のように表示する
            //   数字（0〜2）を「グー」「チョキ」「パー」に変えるには switch 文を使う
            System.out.println("あなた：" + player + "　コンピュータ：" + cpu);

            // TODO 3：勝ち・負け・あいこを判定して表示し、それぞれの回数を1増やす
            //   あいこ：2人の手が同じ
            //   勝ち　：(あなた, コンピュータ) が (グー, チョキ)・(チョキ, パー)・(パー, グー) のどれか
            //   負け　：それ以外

        }

        System.out.println("成績：" + winCount + "勝 " + loseCount + "敗 " + drawCount + "分");
    }
}
