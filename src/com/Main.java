package com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.Map;

public class Main {
    //定义组件
    JFrame jf;
    JPanel jp1, jp2, jp3;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    JLabel apiLabel, secretLabel, amountLabel,symbolLabel;
    JTextField apiJTextField, secretTextField, amountTextField,symbolTextField;
    JTextArea logArea;
    boolean b = false;          //是否挖矿
    String apiKey = "";
    String sercet = "";
    String symbol = "";
    String amount = "";
    String orderId="";
    public static void main(String[] args) {
        Main main = new Main();
//        main.trade();
    }



    public Main() {
        //创建组件
        //面板组件JPanel布局模式默认的是流式布局FlowLayout\
        jf = new JFrame("我的工具");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jb1 = new JButton("开始");
        jb2 = new JButton("关闭");
        apiLabel = new JLabel("apiKey:");
        apiJTextField = new JTextField(10);
        secretLabel = new JLabel("secret:");
        secretTextField = new JTextField(10);
        amountLabel = new JLabel("单次数量");
        amountTextField = new JTextField(5);
        symbolLabel = new JLabel("操作币种");
        symbolTextField = new JTextField( 5);
        logArea = new JTextArea(30, 30);
        //设置布局，JPanel默认布局FlowLayout,本案例运用到的刚好是流式布局，所以不用设置了
        //把组件添加JPanel
        jp1.add(apiLabel);
        jp1.add(apiJTextField);
        jp1.add(secretLabel);
        jp1.add(secretTextField);
        jp1.add(amountLabel);
        jp1.add(amountTextField);
        jp1.add(symbolLabel);
        jp1.add(symbolTextField);
        jp2.add(logArea);
        JScrollPane scrollPane_1 = new JScrollPane();
        jp2.add(scrollPane_1);
        jp3.add(jb1);
        jp3.add(jb2);

        //把JPanel加入到JFrame
        jf.add(jp1, BorderLayout.NORTH);
        jf.add(jp2, BorderLayout.CENTER);
        jf.add(jp3, BorderLayout.SOUTH);
        scrollPane_1.setViewportView(logArea);
        event();
        //设置窗口属性
        jf.setSize(600, 400);
        jf.setLocation(700, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setResizable(false);
        jf.setVisible(true);
    }

    private void event() {
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

        });
        jb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String apikeyStr = apiJTextField.getText();
                String secretStr = secretTextField.getText();
                String amountStr = amountTextField.getText();
                String symbolStr = symbolTextField.getText();
                if (!isBlack(apikeyStr) && !isBlack(secretStr) && !isBlack(amountStr) && !isBlack(symbolStr)) {
                    System.out.println("点击:" + apiJTextField.getText() + "___" + secretStr + "___" + amountStr);
                    apiKey = apikeyStr;
                    sercet = secretStr;
                    symbol = symbolStr;
                    amount = amountStr;
                    apiJTextField.setEditable(false);
                    amountTextField.setEditable(false);
                    secretTextField.setEditable(false);
                    b = true;
                    logArea.append("\n"+"开始挖矿");

                }else{
                    logArea.append("\n"+"参数不完整，请重新输入");
                }
            }

        });


        jb2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                apiJTextField.setEditable(true);
                amountTextField.setEditable(true);
                secretTextField.setEditable(true);
                b = false;
                logArea.append("\n"+"关闭挖矿");
            }

        });
    }

    public boolean isBlack(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

}
