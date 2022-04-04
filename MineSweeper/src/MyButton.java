import javax.swing.*;

public class MyButton extends JButton {
    boolean isClicked = false; //true为已点击，false为未点击
    //int status = 0; //0表示未点击，1表示左键点开空格或数字，2表示左键点开雷，3表示右键插上旗子
    Status status;
}
