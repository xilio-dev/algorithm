import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TextDiffTool extends JFrame {
    private final JTextPane leftTextPane;
    private final JTextPane rightTextPane;
    private JButton compareButton;

    public TextDiffTool() {
        setTitle("文本对比工具");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 创建左右两个文本区域
        leftTextPane = createTextPane();
        rightTextPane = createTextPane();

        // 创建滚动面板
        JScrollPane leftScrollPane = new JScrollPane(leftTextPane);
        JScrollPane rightScrollPane = new JScrollPane(rightTextPane);

        // 创建分割面板
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setDividerLocation(0.5);

        // 创建底部面板
        JPanel bottomPanel = new JPanel();
        compareButton = new JButton("对比文本");
        compareButton.addActionListener(new CompareButtonListener());
        bottomPanel.add(compareButton);

        // 添加组件到主窗口
        add(splitPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JTextPane createTextPane() {
        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 14));
        return textPane;
    }

    private class CompareButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String leftText = leftTextPane.getText();
            String rightText = rightTextPane.getText();

            // 清除之前的高亮
            clearHighlights(leftTextPane);
            clearHighlights(rightTextPane);

            // 找出差异并高亮显示
            highlightDifferences(leftText, rightText);
        }
    }

    private void highlightDifferences(String text1, String text2) {
        // 使用LCS算法找出公共子序列
        List<DiffRange> diffs = findDifferences(text1, text2);

        // 高亮显示差异
        highlightText(leftTextPane, diffs, true);
        highlightText(rightTextPane, diffs, false);
    }

    private List<DiffRange> findDifferences(String text1, String text2) {
        List<DiffRange> diffs = new ArrayList<>();

        int m = text1.length();
        int n = text2.length();

        // 创建DP表
        int[][] dp = new int[m + 1][n + 1];

        // 填充DP表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 回溯找出差异
        int i = m, j = n;
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && text1.charAt(i - 1) == text2.charAt(j - 1)) {
                i--;
                j--;
            } else if (i > 0 && (j == 0 || dp[i][j] == dp[i - 1][j])) {
                // text1中有多余字符
                diffs.add(new DiffRange(i - 1, i, true));
                i--;
            } else if (j > 0 && (i == 0 || dp[i][j] == dp[i][j - 1])) {
                // text2中有多余字符
                diffs.add(new DiffRange(j - 1, j, false));
                j--;
            }
        }

        return diffs;
    }

    private void highlightText(JTextPane textPane, List<DiffRange> diffs, boolean isLeft) {
        StyledDocument doc = textPane.getStyledDocument();
        Highlighter highlighter = textPane.getHighlighter();
        highlighter.removeAllHighlights();

        for (DiffRange diff : diffs) {
            if ((isLeft && diff.isLeft) || (!isLeft && !diff.isLeft)) {
                try {
                    int start = diff.start;
                    int end = diff.end;

                    // 确保范围有效
                    if (start >= 0 && end <= doc.getLength() && start <= end) {
                        highlighter.addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.PINK));
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void clearHighlights(JTextPane textPane) {
        textPane.getHighlighter().removeAllHighlights();
    }

    private static class DiffRange {
        int start;
        int end;
        boolean isLeft; // true表示左侧文本的差异，false表示右侧文本的差异

        public DiffRange(int start, int end, boolean isLeft) {
            this.start = start;
            this.end = end;
            this.isLeft = isLeft;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextDiffTool tool = new TextDiffTool();
            tool.setVisible(true);
        });
    }
}
