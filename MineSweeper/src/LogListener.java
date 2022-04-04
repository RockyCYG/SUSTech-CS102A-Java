import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogListener implements ActionListener {
    JTextField nameField = null;
    JPasswordField passwordField = null;

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void actionPerformed(ActionEvent e) {
        String buttonStr = e.getActionCommand();//取到按钮上的字符串

        if (buttonStr.equals("登录")) {
            String name = nameField.getText();
            String password = passwordField.getText();
            if (name.equals("cyg") && password.equals("123cyg")) {
                RegisterFrame.registerFrame.dispose();
                MyFrame frame = new MyFrame(9, 9, 10);
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "欢迎您来到扫雷！", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "请在模式菜单栏中选择模式。", "Choose", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "您输入的用户名和密码有误！\n请重新输入！");
            }
        }
    }
}