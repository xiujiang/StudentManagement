package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    //定义组件
    JFrame jf1,jf2;
    JPanel jp1, jp2, jp3,jp4,jp5;
    JButton jb1, jb2;
    JLabel houseInfoName,studentInfoName,houseNameLabel,houseIdCardLabel,houseBirthdayLabel,houseAddressLabel,
            studentIdLabel,studentIdCardLabel,studentCollageLabel,
            studentPrefessionLabel,studentClassLabel;
    JTextField houseNameTextField,houseIdCardTextField,houseBirthdayTextField,houseAddressTextField,
            studentIdTextField,studentIdCardTextField,studentCollageTextField,
            studentPrefessionTextField,studentClassTextField;
    ArrayList jt = new ArrayList<JTextField>();

    JTextArea baseInfoArea;     //基本信息区

    public static void main(String[] args) {
        Main main = new Main();
    }



    public Main() {
        //创建组件
        //面板组件JPanel布局模式默认的是流式布局FlowLayout\
        jf1 = new JFrame("学生管理");

        jf1.setLayout(new BorderLayout());
        jp1 = new JPanel(new GridLayout(5, 2));     // 左边户籍输入框
        jp2 = new JPanel(new GridLayout(6, 2));     //右边学籍输入框
        jp1.setSize(20,40);
        jp3 = new JPanel();     //信息显示区
        jp4 = new JPanel();      //按钮
        jp5 = new JPanel(new GridLayout(1,2));
        jb1 = new JButton("查询");
        jb2 = new JButton("清空");
        houseInfoName = new JLabel("户籍信息");
        houseNameLabel = new JLabel("姓名");
        houseNameTextField = new JTextField(10);
        houseNameTextField.setSize(15,10);
        houseIdCardLabel = new JLabel("身份证号");
        houseIdCardTextField = new JTextField(18);
        houseBirthdayLabel = new JLabel("出生日期");
        houseBirthdayTextField = new JTextField(20);
        houseAddressLabel  = new JLabel("住址");
        houseAddressTextField = new JTextField(50);
        houseInfoName.setHorizontalAlignment(SwingConstants.RIGHT);
        houseNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        houseIdCardLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        houseBirthdayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        houseAddressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jp1.add(houseInfoName);
        jp1.add(new Label());
        jp1.add(houseNameLabel);
        jp1.add(houseNameTextField);
        jp1.add(houseIdCardLabel);
        jp1.add(houseIdCardTextField);
        jp1.add(houseBirthdayLabel);
        jp1.add(houseBirthdayTextField);
        jp1.add(houseAddressLabel);
        jp1.add(houseAddressTextField);


        studentInfoName = new JLabel("学籍信息");
        studentIdLabel = new JLabel("学号");
        studentIdTextField = new JTextField(10);
        studentIdCardLabel = new JLabel("身份证号");
        studentIdCardTextField = new JTextField(18);
        studentCollageLabel = new JLabel("所属学院");
        studentCollageTextField = new JTextField(50);
        studentPrefessionLabel = new JLabel("所属专业");
        studentPrefessionTextField = new JTextField(20);
        studentClassLabel = new JLabel("班级");
        studentClassTextField = new JTextField(50);
        studentInfoName.setHorizontalAlignment(SwingConstants.RIGHT);
        studentIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentClassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentIdCardLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentCollageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentPrefessionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jp2.add(studentInfoName);
        jp2.add(new Label());
        jp2.add(studentIdLabel);
        jp2.add(studentIdTextField);
        jp2.add(studentIdCardLabel);
        jp2.add(studentIdCardTextField);
        jp2.add(studentCollageLabel);
        jp2.add(studentCollageTextField);
        jp2.add(studentPrefessionLabel);
        jp2.add(studentPrefessionTextField);
        jp2.add(studentClassLabel);
        jp2.add(studentClassTextField);

        baseInfoArea = new JTextArea(30, 30);
        //把组件添加JPanel
        jp3.add(baseInfoArea);

        JScrollPane js = new JScrollPane();
        jp3.add(js);
        jp4.add(jb1);
        jp4.add(jb2);
        jp5.add(jp2);
        jp5.add(jp1);

        //把JPanel加入到JFrame
        jf1.add(jp5, BorderLayout.NORTH);
        jf1.add(jp3, BorderLayout.CENTER);
        jf1.add(jp4, BorderLayout.SOUTH);
        js.setViewportView(baseInfoArea);
        event();
        //设置窗口属性
        jf1.setSize(500, 400);
        jf1.setLocation(700, 500);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf1.setResizable(false);
        jf1.setVisible(true);
        Collections.addAll(jt,houseNameTextField,houseIdCardTextField,houseBirthdayTextField,houseAddressTextField,
                studentIdTextField,studentIdCardTextField,studentCollageTextField,
                studentPrefessionTextField,studentClassTextField);
    }

    private void event() {
        jf1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HouseInfo houseInfo = new HouseInfo();
                houseInfo.setName(houseNameTextField.getText());
                houseInfo.setAddress(houseAddressTextField.getText());
                String date = houseBirthdayTextField.getText();


                houseInfo.setIdCard(houseIdCardTextField.getText());

                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setClassName(studentClassTextField.getText());
                studentInfo.setCollege(studentCollageTextField.getText());
                studentInfo.setIdCard(studentIdCardTextField.getText());
                studentInfo.setProfession(studentPrefessionTextField.getText());
                studentInfo.setStudentId(studentIdTextField.getText());
                if(!checkInfo(houseInfo,studentInfo)){
                    baseInfoArea.setText("信息输入不完整，请补充信息\n");
                    return;
                }
                if(!isDate(date)){
                    baseInfoArea.setText("日期格式有误，格式为: YYYY-MM-DD\n");
                    return;
                }
                Date dt = new Date();
                try {
                    dt = new SimpleDateFormat("YYYY-MM-DD").parse(date);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                houseInfo.setBirthday(dt);
                StudentService studentService = new StudentService();
                BaseInfo baseInfo = studentService.getStudentBaseInfo(houseInfo,studentInfo);
                baseInfoArea.setText(baseInfo.getInfo());
            }

        });

        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baseInfoArea.setText("");
                jt.forEach(
                        t->{
                    ((JTextField)t).setText("");
                });
            }
        });
    }

    public boolean checkInfo(HouseInfo houseInfo,StudentInfo studentInfo){
        if(houseInfo.getName().isEmpty()|| houseInfo.getAddress().isEmpty() || houseInfo.getIdCard().isEmpty()|| houseBirthdayTextField.getText().isEmpty()){
            return false;
        }
        if(studentInfo.getClassName().isEmpty() || studentInfo.getCollege().isEmpty() || studentInfo.getStudentId().isEmpty()|| studentInfo.getIdCard().isEmpty() || studentInfo.getProfession().isEmpty()){
            return false;
        }
        return true;
    }
    public static boolean isDate(String date){
        Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");
        return p.matcher(date).matches();
    }
    public boolean isBlack(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

}
