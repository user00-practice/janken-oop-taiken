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
import java.util.ArrayList;
import java.util.List;

/**
 * じゃんけんゲーム（複数人版）の画面を作るクラス。
 * CPU の人数分のラベルを、JankenGame が持っている CPU のリストから作る。
 */
public class MainFrame extends JFrame {

    private static final Font BIG_FONT = new Font(Font.DIALOG, Font.BOLD, 26);
    private static final Font NORMAL_FONT = new Font(Font.DIALOG, Font.PLAIN, 20);

    private final JankenGame game = new JankenGame();

    private final JLabel youLabel = new JLabel("", SwingConstants.CENTER);
    /** CPU 1人につき1つのラベル（CPU の人数だけ作る） */
    private final List<JLabel> cpuLabels = new ArrayList<>();
    private final JLabel resultLabel = new JLabel("手を選んでください", SwingConstants.CENTER);

    public MainFrame() {
        setTitle("じゃんけんゲーム（複数人版）");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 300 + 40 * game.getCpus().size());
        setLocationRelativeTo(null);

        // 上：参加者全員の手と勝った回数（あなた＋CPUの人数分）
        JPanel top = new JPanel(new GridLayout(0, 1));
        top.setBorder(BorderFactory.createEmptyBorder(15, 10, 0, 10));
        youLabel.setFont(NORMAL_FONT);
        top.add(youLabel);
        for (int i = 0; i < game.getCpus().size(); i++) {
            JLabel label = new JLabel("", SwingConstants.CENTER);
            label.setFont(NORMAL_FONT);
            cpuLabels.add(label);
            top.add(label);
        }
        resultLabel.setFont(BIG_FONT);
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

        add(top, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
        updatePlayers();
    }

    /** グー・チョキ・パーのボタンが押されたときの処理。 */
    private void onHand(Hand hand) {
        List<Player> winners = game.play(hand);

        if (winners.isEmpty()) {
            resultLabel.setText("あいこ");
        } else {
            List<String> names = new ArrayList<>();
            for (Player winner : winners) {
                names.add(winner.getName());
            }
            resultLabel.setText(String.join("・", names) + " の勝ち！");
        }
        updatePlayers();
    }

    /** 参加者全員の手と勝った回数の表示を更新する。 */
    private void updatePlayers() {
        youLabel.setText(text(game.getYou()));
        List<CpuPlayer> cpus = game.getCpus();
        for (int i = 0; i < cpus.size(); i++) {
            cpuLabels.get(i).setText(text(cpus.get(i)));
        }
    }

    /** 「CPU1：グー（2勝）」のような表示用の文字列を作る。 */
    private String text(Player player) {
        String hand = player.getHand() == null ? "？" : player.getHand().getLabel();
        return player.getName() + "：" + hand + "（" + player.getWinCount() + "勝）";
    }
}
