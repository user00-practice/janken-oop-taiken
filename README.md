<p align="center"><img src="docs/images/class_logo.png" alt="クラスロゴ" width="200"></p>

# じゃんけんで体験するオブジェクト指向（講師用リポジトリ）

体験シリーズ「じゃんけんで体験するオブジェクト指向」（2限・50分×2）の教材一式です。このリポジトリは**講師専用**です。

同じじゃんけんゲームを、STEP1（CUI・制御構造）→ STEP2（GUI・OOP）→ STEP3（CPU複数人に拡張）の順に作ります。STEP3 は OOP 版だけで行い、CUI 版で人数を増やす大変さは講師がデモで見せます。対象は、Java の基本文法を学び終えたプログラミング初心者です。

## 仕組み：受講者用リポジトリへの自動同期

```
講師用リポジトリ（このリポジトリ：user00-practice/janken-oop-taiken）
      │ main へ push
      ▼
GitHub Actions（.github/workflows/sync-to-student-repo.yml）
      │ answer/ と teacher/ を除外
      │ STUDENT_README.md → README.md にリネーム
      ▼
受講者用リポジトリ（user00-practice/janken-oop-taiken-student。手動編集しない）
```

セットアップ手順は [SETUP.md](./SETUP.md) を参照してください。

## フォルダ構成

| フォルダ・ファイル | 内容 | 受講者用への同期 |
| --- | --- | --- |
| `step1-cui/`・`step2-gui-oop/`・`step3-multi/` | 受講者が TODO を書くスターター（各 README.md に課題の説明） | される |
| `.idea/`・`.gitignore`・`docs/images/` | IntelliJ のプロジェクト構成と実行構成、Gitの除外設定、クラスロゴ | される |
| `STUDENT_README.md` | 受講者用リポジトリの README.md になる | される（リネームして） |
| `answer/` | 各STEPの完成コードと、講師デモ用の「CUI版・CPU3人」（IntelliJで単独のプロジェクトとして開く） | **されない** |
| `teacher/` | シナリオ（docx）・ハンドアウト（docx）・解説スライド（pptx） | **されない** |
| `README.md`（この文書）・`SETUP.md` | 講師向けの説明 | **されない** |

ハンドアウトは受講者用ですが、印刷やLMSなど Git 以外の経路で配布する前提で `teacher/` に保管しています。

## 当日の流れ（概要）

| 時間 | 内容 |
| --- | --- |
| 1限 0〜10分 | 導入・クローン |
| 1限 10〜35分 | STEP1：CUI版（TODO 1〜3） |
| 1限 35〜50分 | STEP1 の振り返りと、OOP の考え方（クラスに分ける） |
| 2限 0〜22分 | STEP2：GUI・OOP版（TODO A〜C） |
| 2限 22〜30分 | 講師デモ：CUI版を CPU 3人に拡張すると… |
| 2限 30〜43分 | STEP3：複数人版（TODO 1〜2） |
| 2限 43〜50分 | まとめ：OOP のメリット |

詳しい進行は `teacher/` のシナリオを参照してください。

## 動作確認環境

- Java SE 25 以降、IntelliJ IDEA、Swing（追加ライブラリなし）
