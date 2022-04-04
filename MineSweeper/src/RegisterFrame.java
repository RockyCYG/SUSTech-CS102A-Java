import javax.swing.*;
import java.awt.*;

public class RegisterFrame {
    static JFrame registerFrame = new JFrame();
    ImageIcon picture = new ImageIcon("D:\\java\\MineSweeper\\src\\华山论剑.jpg");
    JLabel showPicture = new JLabel(picture);
    JButton logButton = new JButton("登录");
    JButton registerButton = new JButton("注册");

    JLabel name1 = new JLabel("用户名");
    JLabel inputPassword = new JLabel("密码");

    JTextField name = new JTextField();
    JPasswordField password = new JPasswordField();

    JCheckBox rememberPassword = new JCheckBox("记住密码");


    public RegisterFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        registerFrame.setTitle("登录界面");
        registerFrame.setBounds((int) (centerX - 0.5 * centerX) + 100, (int) (centerY - 0.5 * centerY) - 50, 700, 610);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setFont(new Font("宋体", Font.PLAIN, 15));
        registerFrame.setLayout(new FlowLayout());

        logButton.setBackground(Color.cyan);
        Dimension dimension = new Dimension(610, 30);
        name.setPreferredSize(dimension);//设置用户名的输入框尺寸
        password.setPreferredSize(dimension);//设置密码输入框尺

        registerFrame.add(showPicture);//添加图片到窗体上
        registerFrame.add(name1);
        registerFrame.add(name);
        registerFrame.add(inputPassword);
        registerFrame.add(password);
        registerFrame.add(logButton);
        registerFrame.add(registerButton);
        registerFrame.add(rememberPassword);

        LogListener listener = new LogListener();
        logButton.addActionListener(listener);//在登录按钮上添加动作监听器
        registerButton.addActionListener(listener);//在注册按钮上添加动作监听器

        registerFrame.setVisible(true);//可视化 1.将窗体显示在窗体上2.所有组件的添加必须在这行代码之前完成

        listener.setNameField(name);
        listener.nameField = name;
        listener.passwordField = password;
        listener.getNameField();
    }

}
