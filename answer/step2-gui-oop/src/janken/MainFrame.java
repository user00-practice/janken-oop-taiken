package janken;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * じゃんけんゲーム（GUI版）の画面を作るクラス。
 * 画面の表示だけを担当し、じゃんけんの処理は JankenGame に任せる。
 */
public class MainFrame extends JFrame {

    private static final Font BIG_FONT = new Font(Font.DIALOG, Font.BOLD, 26);
    private static final Font NORMAL_FONT = new Font(Font.DIALOG, Font.PLAIN, 20);

    private final JankenGame game = new JankenGame();

    private final JLabel youLabel = new JLabel("あなた：", SwingConstants.CENTER);
    private final JLabel cpuLabel = new JLabel("CPU：", SwingConstants.CENTER);
    private final JLabel resultLabel = new JLabel("手を選んでください", SwingConstants.CENTER);
    private final JLabel scoreLabel = new JLabel("", SwingConstants.CENTER);

    public MainFrame() {
        setTitle("じゃんけんゲーム（GUI版）");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 420);
        setLocationRelativeTo(null);

        // 上：2人の手と結果
        youLabel.setFont(NORMAL_FONT);
        cpuLabel.setFont(NORMAL_FONT);
        resultLabel.setFont(BIG_FONT);
        JPanel top = new JPanel(new GridLayout(3, 1));
        top.setBorder(BorderFactory.createEmptyBorder(15, 10, 0, 10));
        top.add(youLabel);
        top.add(cpuLabel);
        top.add(resultLabel);

        // 中央：グー・チョキ・パーのボタン
        JPanel buttons = new JPanel(new GridLayout(1, 3, 10, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (Hand hand : Hand.values()) {
            JButton button = new JButton(hand.getLabel());
            button.setFont(BIG_FONT);
            button.addActionListener(e -> onHand(hand));
            buttons.add(button);
        }

        // 下：成績
        scoreLabel.setFont(NORMAL_FONT);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        add(top, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
        add(scoreLabel, BorderLayout.SOUTH);
        updateScore();
    }

    /** グー・チョキ・パーのボタンが押されたときの処理。 */
    private void onHand(Hand hand) {
        Player winner = game.play(hand);

        Player you = game.getYou();
        Player cpu = game.getCpu();
        youLabel.setText(you.getName() + "：" + label(you.getHand()));
        cpuLabel.setText(cpu.getName() + "：" + label(cpu.getHand()));
        if (winner == null) {
            resultLabel.setText("あいこ");
        } else {
            resultLabel.setText(winner.getName() + "の勝ち！");
        }
        updateScore();
    }

    /** 成績の表示を更新する。 */
    private void updateScore() {
        scoreLabel.setText(game.getYou().getName() + " " + game.getYou().getWinCount() + "勝　"
                + game.getCpu().getName() + " " + game.getCpu().getWinCount() + "勝");
    }

    /** 手の表示名を返す（まだ手が決まっていなければ「？」）。 */
    private String label(Hand hand) {
        return hand == null ? "？" : hand.getLabel();
    }
}
