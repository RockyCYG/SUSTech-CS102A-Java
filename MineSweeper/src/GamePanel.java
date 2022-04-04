

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Time;
import java.util.Random;
//布置扫雷面板以及游戏规则





@SuppressWarnings("all")
public class GamePanel extends JPanel implements ActionListener{
    JFrame gameProgressText;//记录游戏进程！
    TextArea textArea;
    JTextField restMine = new JTextField(10);
    Timer timer;
    JTextField time = new JTextField(10); //记录所用时间

    //public static boolean isSingle; //true代表单人，false代表双人

    //boolean isFlag = false;//
    static int gameStatus = 0;//0代表扫雷未结束，1代表该回合已结束

    ImageIcon Flag = new ImageIcon("D:\\java\\MineSweeper\\src\\flag.png");
    ImageIcon Bomb = new ImageIcon("D:\\java\\MineSweeper\\src\\mine.GIF");
    int row, col, mineCount;
    private GridComponent[][] mineField;
    private int[][] chessboard;  //0代表空格，大于0代表周边雷数，-1代表雷，-2代表插上旗子并且正确，-3代表踩雷之后
    MyButton b[][] = new MyButton[row][col];
    private final Random random = new Random();
    Player player1;
    Player player2;
    Player onTurn;
    int clickTime;   //用户开始游戏前设置的点击次数！！！
    int clickNum;    //每一方用户实际点击次数！！！
    int restBomb;
    int openNum;     //记录用户是第几次打开按钮的！！！（不管是哪一方）
    JPanel north = new JPanel();
    JPanel buttonPanel = new JPanel();
    BorderLayout borderLayout;
    int[][] gridstatus = new int[row][col];         //记录格子是否被打开          0代表没打开，1代表打开
    int spend = 0; //单人：记录时间从0开始计时        双人：记录时间从10开始倒计时


    JButton restart = new JButton(new AbstractAction("重新开始") {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer = new Timer(1000,this);
            if (MyFrame.isAI) {
                openNum = 0;
                gameProgressText.dispose();
                removeCenter();
                setProgressText();
                restBomb = mineCount;
                rest();
                setVisible(true);
                validate();
                repaint();
            }
            else {
                if (MyFrame.sOrd == 1) {
                    spend = 0;
                    openNum = 0;
                    removeCenter();
                    restBomb = mineCount;
                    rest();
                    setVisible(true);
                    validate();
                    repaint();
                } else if (MyFrame.sOrd == 2) {
                    timer.start();
                    spend = 10;
                    openNum = 0;
                    gameProgressText.dispose();
                    removeCenter();
                    setProgressText();
                    restBomb = mineCount;
                    rest();
                    setVisible(true);
                    validate();
                    repaint();
                    //new MyFrame(row,col,mineCount);
                    //gameProgressText.dispose();
                }
            }
        }
    });


    public GamePanel() {

    }

    public GamePanel(int row, int col, int mineCount) {
        repaint();

        this.row = row;
        this.col = col;
        this.mineCount = mineCount;
        this.restBomb = mineCount;
        this.setVisible(true);
        this.setFocusable(true);
        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        this.setBackground(Color.WHITE);
        this.setSize(GridComponent.gridSize * col, GridComponent.gridSize * row);

        this.setHead();
        timer = new Timer(1000, this);


        if (MyFrame.sOrd == 1) {
            spend = 0;
            JOptionPane.showMessageDialog(null, "欢迎您来到扫雷单人模式！", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        } else if (MyFrame.sOrd == 2) {
            spend = 10;
            setProgressText();
        }
        this.addBombs();
        this.setButtons();
        this.setRules();
        this.add(buttonPanel, BorderLayout.CENTER);
        //repaint();
    }

    //如果有九个雷排成正方形的话调用这个方法
    private void rest() {
        this.addBombs();
        this.setButtons();
        this.setRules();
        this.add(buttonPanel, BorderLayout.CENTER);
        //repaint();
    }


    public void removeCenter() {
        buttonPanel.removeAll();
    }


    //布雷
    private void addBombs() {
        chessboard = new int[row][col];
        for (int i = 0; i < mineCount; ) {
            int x = random.nextInt(col);
            int y = random.nextInt(row);
            //-1表示地雷
            if (chessboard[y][x] != -1) {
                chessboard[y][x] = -1;
                i++;
            }
        }
    }

    private void countMineAround() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //if (chessboard[i][j] == -1) {
                //continue;
                //}
                int BombNum = 0;
                if (i - 1 >= 0 && j - 1 >= 0 && chessboard[i - 1][j - 1] == -1) {
                    BombNum++;
                }
                if (i - 1 >= 0 && chessboard[i - 1][j] == -1) {
                    BombNum++;
                }
                if (i - 1 >= 0 && j + 1 < col && chessboard[i - 1][j + 1] == -1) {
                    BombNum++;
                }
                if (j - 1 >= 0 && chessboard[i][j - 1] == -1) {
                    BombNum++;
                }
                if (j + 1 < col && chessboard[i][j + 1] == -1) {
                    BombNum++;
                }
                if (i + 1 < row && j - 1 >= 0 && chessboard[i + 1][j - 1] == -1) {
                    BombNum++;
                }
                if (i + 1 < row && chessboard[i + 1][j] == -1) {
                    BombNum++;
                }
                if (i + 1 < row && j + 1 < col && chessboard[i + 1][j + 1] == -1) {
                    BombNum++;
                }

                if (BombNum == 8 && chessboard[i][j] == -1) {
                    rest();
                } else {
                    if (chessboard[i][j] == -1) {
                        BombNum = 0;
                    } else {
                        chessboard[i][j] = BombNum;
                    }
                }
            }
        }
    }


    private void setButtons() {
        buttonPanel.setLayout(new GridLayout(row, col));
        b = new MyButton[row][col];
        //对chessboard数组中每一个元素赋值
        countMineAround();
    }

//this.setLayout(new GridLayout(row, col));

    public void setRules() {
        timer = new Timer(1000,this);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //JButton button = new JButton(chessboard[i][j] + "");
                //button.setBackground(Color.GRAY);
                //button.setBounds(j * GridComponent.gridSize, i * GridComponent.gridSize, GridComponent.gridSize-1, GridComponent.gridSize-1);
                MyButton button = new MyButton();
                button.setOpaque(true);
                button.setBackground(null);
                buttonPanel.add(button, BorderLayout.CENTER);
                button.status = Status.NotClicked;
                b[i][j] = button;
                //button.addActionListener(this);
                int r = i;
                int c = j;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //记录点了多少次
                        if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON2) {
                            clickNum++;
                            openNum++;

                            //避免首发触雷
                            if (openNum == 1 && chessboard[r][c] == -1) {
                                //随机数产生的行数-1, 随机数产生的列数-1
                                for (int x = -1, y = -1; ; ) {
                                    x = random.nextInt(row);
                                    y = random.nextInt(col);
                                    if (chessboard[x][y] != -1) {
                                        chessboard[r][c] = 0;
                                        chessboard[x][y] = -1;
                                        countMineAround();
                                        break;
                                    }
                                }

                            }

                            if (openNum == 1) {
                                if (MyFrame.isAI) {
                                } else {
                                    timer.start();
                                }
                            }


                            //单人情况（左键）
                            if (MyFrame.sOrd == 1) {
                                for (int i = 0; i < row; i++) {
                                    for (int j = 0; j < col; j++) {
                                        if (button.equals(b[i][j])) {
                                            if (chessboard[i][j] == -1) {
                                                BombMusic.play();
                                                lose();
                                                //button.status = 2;
                                                timer.stop();
                                                return;
                                            } else {
                                                //button.status = 1;
                                                openBlank(i, j);
                                                checkWin();
                                            }
                                        }
                                    }
                                }
                                restMine.setText("剩余雷数：" + restBomb + "");

                            }
                            //双人情况（左键）
                            else {
                                MouseLeft(button);
                                if (MyFrame.isAI){
                                    nextTurnAI();
                                }
                                else {
                                    nextTurn();
                                }
                                restMine.setText("剩余雷数：" + restBomb + "");
                            }

                        }
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            clickNum++;
                            openNum++;
                            //单人情况（右键）
                            if (MyFrame.sOrd == 1) {
                                if (openNum == 1){
                                    timer.start();
                                }
                                for (int i = 0; i < row; i++) {
                                    for (int j = 0; j < col; j++) {
                                        if (button.equals(b[i][j])) {
                                            if (button.status == Status.OpenFlag){
                                                button.setEnabled(true);
                                                button.setOpaque(true);
                                                button.setIcon(null);
                                                button.setBackground(null);
                                                button.setVisible(true);
                                                b[i][j].status = Status.NotClicked;
                                            }else if (button.status == Status.NotClicked) {
                                                button.setBackground(Color.GREEN);
                                                //button.setText(null);
                                                button.setIcon(Flag);
                                                //chessboard[i][j] = -2;//-2代表插旗
                                                //button.status = 3;
                                                //restBomb--;
                                                b[i][j].status = Status.OpenFlag;

                                                restMine.setText("剩余雷数：" + restBomb + "");
                                            }




                                            /*else {
                                                openBlank(i, j);
                                                checkWin();
                                                restMine.setText("剩余雷数：" + restBomb + "");
                                            }
                                            */
                                        }
                                    }
                                }

                            }
                            //双人情况（右键）
                            else {
                                MouseRight(button);
                                if (MyFrame.isAI){
                                    nextTurnAI();
                                }
                                else {
                                    nextTurn();
                                }
                                restMine.setText("剩余雷数：" + restBomb + "");
                            }
                        }
                    }
                });


            }
        }
    }


    //按鼠标左键的情况
    public void MouseLeft(MyButton button) {
        if (onTurn == null) {
            onTurn = player1;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (button.equals(b[i][j])) {
                    //openBomb(i,j);
                    if (chessboard[i][j] == -1) {
                        BombMusic.play();
                        //button.setEnabled(false);
                        button.setOpaque(true);
                        button.setIcon(Bomb);
                        button.setBackground(Color.RED);
                        button.setText(null);
                        //lose();
                        onTurn.costScore();
                        onTurn.addMistake();
                        //JOptionPane.showMessageDialog(null, "踩到雷，扣一分！");
                        chessboard[i][j] = -3;   //如果踩到雷，之后这个雷的chessboard的值改为-3
                        restBomb--;
                    } else {
                        /*button.setEnabled(false);
                        button.setOpaque(true);
                        button.setIcon(null);
                        button.setBackground(Color.CYAN);
                        button.setText(chessboard[i][j] + "");*/
                        openBlank(i, j);
                        //button.gridstatus = 1;

                    }
                }
            }
        }
    }


    //按鼠标右键插旗
    public void MouseRight(MyButton button) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (button.equals(b[i][j])) {
                    if (chessboard[i][j] == -1) {
                        FlagMusic.play();
                        //button.setEnabled(false);
                        button.setOpaque(true);
                        button.setBackground(Color.GREEN);
                        button.setText(null);
                        button.setIcon(Flag);
                        onTurn.addScore();
                        chessboard[i][j] = -2;//-2代表插旗成功，加分
                        //JOptionPane.showMessageDialog(null, "标记正确，加一分！");
                        restBomb--;
                        //button.status = 3;
                    } else {
                        if (chessboard[i][j] == 0) {
                            openBlank(i, j);
                            onTurn.addMistake();
                            FlagWrong.play();
                            //JOptionPane.showMessageDialog(null, "标记错误，增加一次失误！");
                        } else if (chessboard[i][j] > 0) {
                            button.setEnabled(false);
                            button.setOpaque(true);
                            button.setText(chessboard[i][j] + "");
                            button.setIcon(null);
                            button.setBackground(Color.LIGHT_GRAY);
                            onTurn.addMistake();
                            FlagWrong.play();
                            //JOptionPane.showMessageDialog(null, "标记错误，增加一次失误！");
                        }
                    }
                }
            }
        }
    }


    /**
     * 空格自动级联(递归)打开
     * ps:递归打开如果遇到旗子怎么办？
     *
     * @param r
     * @param c
     */
    public void openBlank(int r, int c) {
        MyButton button = b[r][c];
        //如果这个按钮已经被打开，则退出这个方法
        if (!button.isEnabled()) {
            return;
        }
        button.setIcon(null);
        button.setEnabled(false);
        button.setOpaque(true);
        button.setBackground(Color.LIGHT_GRAY);
        button.setText(chessboard[r][c] + "");


        if (chessboard[r][c] == 0) {
            if (r - 1 >= 0 && c - 1 >= 0 && chessboard[r - 1][c - 1] >= 0) {
                openBlank(r - 1, c - 1);
            }
            if (r - 1 >= 0 && chessboard[r - 1][c] >= 0) {
                openBlank(r - 1, c);
            }
            if (r - 1 >= 0 && c + 1 < col && chessboard[r - 1][c + 1] >= 0) {
                openBlank(r - 1, c + 1);
            }
            if (c - 1 >= 0 && chessboard[r][c - 1] >= 0) {
                openBlank(r, c - 1);
            }
            if (c + 1 < col && chessboard[r][c + 1] >= 0) {
                openBlank(r, c + 1);
            }
            if (r + 1 < row && c - 1 >= 0 && chessboard[r + 1][c - 1] >= 0) {
                openBlank(r + 1, c - 1);
            }
            if (r + 1 < row && chessboard[r + 1][c] >= 0) {
                openBlank(r + 1, c);
            }
            if (r + 1 < row && c + 1 < col && chessboard[r + 1][c + 1] >= 0) {
                openBlank(r + 1, c + 1);
            }
        }
    }


    /**
     * 当踩到雷时，调用lose方法
     * 单人游戏规则
     */

    private void lose() {

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                MyButton button = b[r][c];
                if (chessboard[r][c] == -1) {
                    button.setIcon(Bomb);
                    //button.setEnabled(false);
                    button.setOpaque(true);
                    button.setBackground(Color.RED);
                    button.setText(null);
                    //button.setDisabledIcon(Bomb);
                } else {
                    button.setIcon(null);
                    button.setEnabled(false);
                    button.setOpaque(true);
                    button.setBackground(Color.YELLOW);
                    button.setText(chessboard[r][c] + "");
                }
            }
        }

        JOptionPane.showMessageDialog(null, "你输了！\n再接再厉哦~", "Lose", JOptionPane.INFORMATION_MESSAGE);

    }



    private void checkWin() {
        int flagCount = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (b[r][c].isEnabled() || (b[r][c].status == Status.OpenFlag && chessboard[r][c] == -1)) {
                    flagCount++;
                }
            }
        }
        if (flagCount == mineCount) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (b[i][j].isEnabled()) {
                        b[i][j].setBackground(Color.GREEN);
                        b[i][j].setIcon(Flag);
                    }
                }
            }
            WinGame.play();
            JOptionPane.showMessageDialog(null, "恭喜你，你赢了！\n用时："+spend+"s", "获胜", JOptionPane.PLAIN_MESSAGE);
            timer.stop();
            String yourname = JOptionPane.showInputDialog(null,"高手，请留下姓名！");
            String text = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java\\MineSweeper\\src\\英雄榜.txt"));
                try {
                    String savetext = bufferedReader.readLine();
                    while(savetext != null){
                        text += savetext + "\n";
                        savetext = bufferedReader.readLine();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            text += yourname + " 用时：" + spend + "s";
            if (col == 9){
                text += "  难度：初级";
            }else if (col == 16){
                text += "  难度：中级";
            }else if (col == 30){
                text += "  难度：高级";
            }else {
                text += "  难度：自定义";
            }
            text += "\n";
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\java\\MineSweeper\\src\\英雄榜.txt"));

                bufferedWriter.write(text);
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }




        }
    }




    public void readHero(){
        String text = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java\\MineSweeper\\src\\英雄榜.txt"));
            try {
                String s = bufferedReader.readLine();
                while (s != null) {
                    text += s + "\n";
                    s = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, text, "英雄榜！", JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * 有一方到了点击次数就换下一个人, 并且每一回合后比较双方分数来决定胜负！！！
     */
    public void nextTurn() {
        if (onTurn == null) {
            onTurn = player1;
        }
        textArea.append(onTurn.getUserName() + " 's score: " + onTurn.getScore() + "\n");
        textArea.append(onTurn.getUserName() + " 's mistake: " + onTurn.getMistake() + "\n");
        //scoreBoard.update();
        if (clickNum == clickTime || spend == 0) {
            if (onTurn == player1) {
                onTurn = player2;
                spend = 10;
                //timer.start();
            } else if (onTurn == player2 ) {
                onTurn = player1;
                spend = 10;
                //timer.start();
            }
            clickNum = 0;
            compareScore();
        }
        if (gameStatus == 1) {
            return;
        } else if (gameStatus == 0) {
            textArea.append("Now it is " + onTurn.getUserName() + "'s turn.\n");
        }
    }


    public void nextTurnAI(){
        onTurn = player1;
        textArea.append(onTurn.getUserName() + " 's score: " + onTurn.getScore() + "\n");
        textArea.append(onTurn.getUserName() + " 's mistake: " + onTurn.getMistake() + "\n");
        if (clickNum == clickTime || spend == 0) {
             for (int clicknum = 0;clicknum<clickTime;clicknum++) {
                A:for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (chessboard[i][j] == -1) {
                            b[i][j].setOpaque(true);
                            b[i][j].setIcon(Flag);
                            b[i][j].setBackground(Color.GREEN);
                            b[i][j].setText(null);
                            chessboard[i][j] = -2;
                            player2.setScore(player2.getScore() + 1);
                            textArea.append("Now it is " + "AI" + "'s turn.\n");
                            textArea.append("AI" + " 's score: " + player2.getScore() + "\n");
                            textArea.append("AI" + " 's mistake: " + player2.getMistake() + "\n");
                            break A;
                        }
                    }
                }
            }
            clickNum = 0;
            compareScore();
        }
        if (gameStatus == 1) {
            return;
        } else if (gameStatus == 0) {
            textArea.append("Now it is " + onTurn.getUserName() + "'s turn.\n");
        }
    }




    public void setProgressText() {
        if (MyFrame.isAI){
            JOptionPane.showMessageDialog(null, "欢迎您来到扫雷人机模式！", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "欢迎您来到扫雷双人模式！", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        }
        String name1 = null;
        if (MyFrame.isAI){
            name1 = JOptionPane.showInputDialog(null, "请输入您的名字", "Player1", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            name1 = JOptionPane.showInputDialog(null, "请输入玩家1的名字", "Player1", JOptionPane.INFORMATION_MESSAGE);
        }
        String name2 = null;
        if (MyFrame.isAI){
            name2 = "AI";
        }
        else {
            name2 = JOptionPane.showInputDialog(null, "请输入玩家2的名字", "Player2", JOptionPane.INFORMATION_MESSAGE);
        }
        String ct = (JOptionPane.showInputDialog(null, "请输入单击次数(1-5)"));
        if (ct == null || ct.equals("")) {
            clickTime = 1;
        } else {
            clickTime = Integer.parseInt(ct);
        }

        if (name1 == null || name1.equals("")) {
            player1 = new Player();
        } else {
            player1 = new Player(name1);
        }

        if (name2 == null || name2.equals("")) {
            player2 = new Player();
        } else {
            player2 = new Player(name2);
        }
        onTurn = player1;

        //gameProgressText = new JFrame("游戏进程信息");
        gameProgressText = new JFrame("游戏进程信息");
        textArea = new TextArea(20, 30);
        Font font = new Font("字体", Font.BOLD, 30);
        textArea.setEnabled(false);
        textArea.setFont(font);
        gameProgressText.add(textArea);
        gameProgressText.pack();
        gameProgressText.setVisible(true);
        gameProgressText.setResizable(false);
        textArea.setText("游戏开始\n" + "玩家1：" + player1.getUserName() + "\n玩家2：" + player2.getUserName() + "\n" + "Now it is " + player1.getUserName() + "'s turn.\n");
    }
    //JTextField textField = new JTextField(10);


    public JFrame getGameProgressText() {
        return gameProgressText;
    }


    //比较每一回合后两人的分数！！
    public void compareScore() {
        String s1 = player1.getUserName() + " 's score: " + player1.getScore() + "\n" + player1.getUserName() + " 's mistake: " + player1.getMistake() + "\n";
        String s2 = player2.getUserName() + " 's score: " + player2.getScore() + "\n" + player2.getUserName() + " 's mistake: " + player2.getMistake() + "\n";
        int count = 0; //记录在场还有多少颗没有被点开的雷！！！
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chessboard[i][j] == -1) {
                    count++;
                }
            }
        }

        //获胜条件1
        if (player1.getScore() > player2.getScore()) {
            if (player1.getScore() - player2.getScore() > count) {
                WinGame.play();
                JOptionPane.showMessageDialog(null, s1 + s2 + "恭喜玩家" + player1.getUserName() + "获胜！", "游戏结果", JOptionPane.INFORMATION_MESSAGE);
                gameStatus = 1;
                openNum = 0;
                timer.stop();
                return;
            }
        } else if (player1.getScore() < player2.getScore()) {
            if (player2.getScore() - player1.getScore() > count) {
                WinGame.play();
                JOptionPane.showMessageDialog(null, s1 + s2 + "恭喜玩家" + player2.getUserName() + "获胜！", "游戏结果", JOptionPane.INFORMATION_MESSAGE);
                gameStatus = 1;
                openNum = 0;
                timer.stop();
                return;
            }
        }

        //获胜条件2
        if (count == 0) {
            if (player1.getScore() > player2.getScore()) {
                WinGame.play();
                JOptionPane.showMessageDialog(null, s1 + s2 + "恭喜玩家" + player1.getUserName() + "获胜！", "游戏结果", JOptionPane.INFORMATION_MESSAGE);
                gameStatus = 1;
                openNum = 0;
                timer.stop();
                return;
            } else if (player1.getScore() < player2.getScore()) {
                WinGame.play();
                JOptionPane.showMessageDialog(null, s1 + s2 + "恭喜玩家" + player2.getUserName() + "获胜！", "游戏结果", JOptionPane.INFORMATION_MESSAGE);
                gameStatus = 1;
                openNum = 0;
                timer.stop();
                return;
            } else if (player1.getScore() == player2.getScore()) {
                WinGame.play();
                if (player1.getMistake() > player2.getMistake()) {
                    JOptionPane.showMessageDialog(null, s1 + s2 + "恭喜玩家" + player2.getUserName() + "获胜！", "游戏结果", JOptionPane.INFORMATION_MESSAGE);
                    gameStatus = 1;
                    openNum = 0;
                    timer.stop();
                    return;
                } else if (player1.getMistake() < player2.getMistake()) {
                    JOptionPane.showMessageDialog(null, s1 + s2 + "恭喜玩家" + player1.getUserName() + "获胜！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
                    gameStatus = 1;
                    openNum = 0;
                    timer.stop();
                    return;
                } else if (player1.getMistake() == player2.getMistake()) {
                    JOptionPane.showMessageDialog(null, s1 + s2 + "双方平局！", "游戏结果", JOptionPane.INFORMATION_MESSAGE);
                    gameStatus = 1;
                    openNum = 0;
                    timer.stop();
                    return;
                }
            }
        }
    }

    //开透视
    public void seeBombs() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                MyButton button = b[i][j];
                //button.setVisible(true);
                if (chessboard[i][j] == -1) {
                    //button.setEnabled(false);
                    if (!b[i][j].equals(Status.OpenFlag)) {
                        button.setOpaque(true);
                        button.setIcon(Bomb);
                        button.setBackground(null);
                        button.setText(null);
                    }else if (b[i][j].equals(Status.OpenFlag)){
                        button.setOpaque(true);
                        button.setIcon(Flag);
                        button.setBackground(Color.GREEN);
                        button.setText(null);
                    }
                }
                /*else if (chessboard[i][j] >= 0){
                    button.setEnabled(false);
                    button.setOpaque(true);
                    button.setIcon(null);
                    button.setBackground(null);
                    button.setText(chessboard[i][j] + "");
                }*/
            }
        }
    }

    //关透视
    public void closeBombs() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                MyButton button = b[i][j];
                //button.setVisible(true);
                if (chessboard[i][j] == -1) {
                    //button.setEnabled(true);
                    if (!b[i][j].equals(Status.OpenFlag)) {
                        button.setOpaque(true);
                        button.setIcon(null);
                        button.setBackground(null);
                        button.setText(null);
                    }else{
                        button.setOpaque(true);
                        button.setIcon(Flag);
                        button.setBackground(Color.GREEN);
                        button.setText(null);
                    }
                } else if (chessboard[i][j] >= 0 && !b[i][j].equals(Status.OpenFlag)) {
                    if (button.isEnabled()) {
                        button.setOpaque(true);
                        button.setIcon(null);
                        button.setBackground(null);
                        button.setText(null);
                    } else {
                        button.setEnabled(false);
                        button.setOpaque(true);
                        button.setIcon(null);
                        button.setBackground(Color.LIGHT_GRAY);
                        button.setText(chessboard[i][j] + "");
                    }
                }
            }
        }
    }



    //存档！
    public void saveGame() {
        if (MyFrame.sOrd == 0) {
            JOptionPane.showMessageDialog(null, "请先开始游戏！", "提示", JOptionPane.WARNING_MESSAGE);
        } else {
            String filename = JOptionPane.showInputDialog("请输入存档文件的名字");
            File file = new File("D:\\java\\MineSweeper\\src\\" + filename + ".txt");
            //File file = new File("D:/save.txt");
            /*while(file.exists()){
                filename = JOptionPane.showInputDialog("对不起！该文档名已存在！请再次输入存档文件的名字");
                file = new File("D:\\java\\MineSweeper\\src");
            }

             */

            String context = "";
            //记录单人还是双人
            context += MyFrame.sOrd + "\n";
            //记录行数和列数和总雷数
            context += row + "\n";
            context += col + "\n";
            context += mineCount + "\n";
            //记录剩余的雷数
            context += restBomb + "\n";

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    context += chessboard[i][j];

                    if (i == row && j == col) {
                        break;
                    } else {
                        context += " ";
                    }
                }
            }
            context += "\n";

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (b[i][j].isEnabled()) {
                        context += "0";
                    } else {
                        context += "1";
                    }
                    if (i == row && j == col) {
                        break;
                    } else {
                        context += " ";
                    }
                }
            }
            context += "\n";


            //如果是双人，要加上每个人的名字、分数、失误数
            if (MyFrame.sOrd == 2) {
                context += player1.getUserName() + "\n";
                context += player1.getScore() + "\n";
                context += player1.getMistake() + "\n";
                context += player2.getUserName() + "\n";
                context += player2.getScore() + "\n";
                context += player2.getMistake() + "\n";

                //记录onTurn的是谁
                if (onTurn == player1) {
                    context += 1 + "\n";
                } else if (onTurn == player2) {
                    context += 2 + "\n";
                }
                //记录每一回合设置的手数
                context += clickTime + "\n";
                //记录onTurn玩家走了几步
                context += clickNum + "\n";
                //记录用户点击的次数
                context += openNum + "\n";
            }

            try {
                if (file.exists()) {
                    FileWriter writer = new FileWriter("D:\\java\\MineSweeper\\src\\" + filename + ".txt");
                    writer.write(context);
                    writer.close();
                } else {
                    file.createNewFile();
                    FileWriter writer = new FileWriter("D:\\java\\MineSweeper\\src\\" + filename + ".txt");
                    writer.write(context);
                    writer.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "错误！", "Error", JOptionPane.WARNING_MESSAGE);
            }


        }
    }


    //读档
    public GamePanel readGame() {
        //validate();
        //repaint();
        JFileChooser chooser = new JFileChooser(".");
        //"D:\\java\\MineSweeper\\src\\mine.GIF"
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String readContext = new String();

        try {
            readContext = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int readRow = 0;
        int readCol = 0;
        int readCountMine = 0;
        int line = 0;
        GamePanel readPanel = new GamePanel();
        while (true) {
            try {
                switch (line) {
                    case 0:
                        if (readContext.equals("1")) {
                            MyFrame.sOrd = 1;
                            JOptionPane.showMessageDialog(null, "这是同一个存档文件！", "提示", JOptionPane.INFORMATION_MESSAGE, null);
                        } else if (readContext.equals("2")) {
                            MyFrame.sOrd = 2;
                            JOptionPane.showMessageDialog(null, "这是同一个存档文件！", "提示", JOptionPane.INFORMATION_MESSAGE, null);
                        }else{
                            JOptionPane.showMessageDialog(null, "这不是同一个存档文件！", "警告", JOptionPane.WARNING_MESSAGE, null);
                            break;
                        }
                        break;
                    case 1:
                        readRow = Integer.parseInt(readContext);
                        break;
                    case 2:
                        readCol = Integer.parseInt(readContext);
                        break;
                    case 3:
                        readCountMine = Integer.parseInt(readContext);
                        //readPanel = new GamePanel(readRow, readCol, readCountMine);
                        readPanel.gridstatus = new int[readPanel.row][readPanel.col];
                        break;
                    case 4:
                        readPanel.restBomb = Integer.parseInt(readContext);
                        break;
                    case 5:
                        readPanel.chessboard = new int[readRow][readCol];
                        String[] s = readContext.split(" ");
                        for (int i = 0; i < readRow; i++) {
                            for (int j = 0; j < readCol; j++) {
                                readPanel.chessboard[i][j] = Integer.parseInt(s[i * readCol + j]);
                            }
                        }

                        break;

                    case 6:
                        String[] t = readContext.split(" ");
                        readPanel.gridstatus = new int[readRow][readCol];
                        for (int i = 0; i < readRow; i++) {
                            for (int j = 0; j < readCol; j++) {
                                readPanel.gridstatus[i][j] = Integer.parseInt(t[i * readCol + j]);
                            }
                        }
                        break;
                    case 7:
                        if (MyFrame.sOrd == 2) {
                            readPanel.player1 = new Player(readContext);
                        }
                        break;
                    case 8:
                        if (MyFrame.sOrd == 2) {
                            readPanel.player1.setScore(Integer.parseInt(readContext));
                        }
                        break;
                    case 9:
                        if (MyFrame.sOrd == 2) {
                            readPanel.player1.setMistake(Integer.parseInt(readContext));
                        }
                        break;
                    case 10:
                        if (MyFrame.sOrd == 2) {
                            readPanel.player2 = new Player(readContext);
                        }
                        break;
                    case 11:
                        if (MyFrame.sOrd == 2) {
                            readPanel.player2.setScore(Integer.parseInt(readContext));
                        }
                        break;
                    case 12:
                        if (MyFrame.sOrd == 2) {
                            readPanel.player2.setMistake(Integer.parseInt(readContext));
                        }
                        break;
                    case 13:
                        if (MyFrame.sOrd == 2) {
                            if (readContext.equals("1")) {
                                readPanel.onTurn = readPanel.player1;
                            } else if (readContext.equals("2")) {
                                readPanel.onTurn = readPanel.player2;
                            }
                        }
                        break;
                    case 14:
                        if (MyFrame.sOrd == 2) {
                            readPanel.clickTime = Integer.parseInt(readContext);
                        }
                        break;
                    case 15:
                        if (MyFrame.sOrd == 2) {
                            readPanel.clickNum = Integer.parseInt(readContext);
                        }
                        break;
                    case 16:
                        if (MyFrame.sOrd == 2) {
                            readPanel.openNum = Integer.parseInt(readContext);
                        }
                        break;
                }


                line++;

                if (!((readContext = bufferedReader.readLine()) != null)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        timer = new Timer(1000,this);
        readPanel.row = readRow;
        readPanel.col = readCol;
        readPanel.mineCount = readCountMine;
        readPanel.b = new MyButton[readPanel.row][readPanel.col];
        readPanel.textArea = new TextArea(20, 30);
        readPanel.setRules();
        readInit(readPanel);
        //readPanel.seeBombs();
        //readPanel.closeBombs();


        readPanel.add(readPanel.buttonPanel, BorderLayout.CENTER);

        readPanel.time.setText("时间：" + spend + "s");
        readPanel.setVisible(true);
        return readPanel;
    }


    public void readInit(GamePanel readPanel) {
        if (MyFrame.sOrd == 1) {
            //removeCenter();
            //restBomb = mineCount;
        } else if (MyFrame.sOrd == 2) {
            if (gameProgressText != null) {
                gameProgressText.dispose();
            }
            readPanel.gameProgressText = new JFrame("游戏进程信息");
            Font font = new Font("字体", Font.BOLD, 30);
            readPanel.textArea.setEnabled(false);
            readPanel.textArea.setFont(font);
            readPanel.gameProgressText.add(readPanel.textArea);
            readPanel.gameProgressText.pack();
            readPanel.gameProgressText.setVisible(true);
            readPanel.gameProgressText.setResizable(false);
            readPanel.textArea.setText("游戏继续\n" + "玩家1：" + readPanel.player1.getUserName() + "\n玩家2：" + readPanel.player2.getUserName() + "\n" + "Now it is " + readPanel.onTurn.getUserName() + "'s turn.\n");
        }
        //removeCenter();
        //restBomb = mineCount;
        //new MyFrame(row,col,mineCount);
        //gameProgressText.dispose();


        readPanel.setVisible(true);
        readPanel.setFocusable(true);
        //.borderLayout = new BorderLayout();
        readPanel.setLayout(new BorderLayout());
        readPanel.setBackground(null);
        readPanel.setSize(GridComponent.gridSize * col, GridComponent.gridSize * row);

        readPanel.setHead();

        readPanel.buttonPanel.setLayout(new GridLayout(readPanel.row, readPanel.col));


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //JButton button = new JButton(chessboard[i][j] + "");
                //button.setBackground(Color.GRAY);
                //button.setBounds(j * GridComponent.gridSize, i * GridComponent.gridSize, GridComponent.gridSize-1, GridComponent.gridSize-1);
                MyButton button = new MyButton();
                button.setVisible(true);
                button.setOpaque(true);
                button.setBackground(null);
                readPanel.buttonPanel.add(button);
                readPanel.b[i][j] = button;


            }
        }

        readPanel.north.add(readPanel.restMine);
        readPanel.north.add(readPanel.restart);
        readPanel.north.add(readPanel.time);
        readPanel.add(readPanel.north, BorderLayout.NORTH);
        readPanel.add(readPanel.buttonPanel, BorderLayout.CENTER);

        readPanel.timer = new Timer(1000,this);
        readPanel.timer.start();
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == timer) {
                    if (e.getSource() == timer) {
                        if (MyFrame.sOrd == 1) {
                            spend++;
                        } else {
                            spend--;
                            if (spend == 0) {
                                nextTurn();
                            }
                        }
                        time.setText("时间：" + spend + "s");
                        timer.start();
                    }
                }
            }
        };
        timer.addActionListener(actionListener);







        for (int i = 0; i < readPanel.row; i++) {
            for (int j = 0; j < readPanel.col; j++) {
                MyButton button = readPanel.b[i][j];
                if (readPanel.chessboard[i][j] == -1) {
                    button.setIcon(null);
                    button.setEnabled(true);
                    button.setBackground(null);
                    button.setOpaque(true);
                    button.setText(null);
                } else if (readPanel.chessboard[i][j] == -2) {
                    button.setIcon(readPanel.Flag);
                    //button.setEnabled(false);
                    button.setOpaque(true);
                    button.setBackground(Color.GREEN);
                    button.setText(null);
                } else if (readPanel.chessboard[i][j] == -3) {
                    button.setIcon(readPanel.Bomb);
                    //button.setEnabled(false);
                    button.setOpaque(true);
                    button.setBackground(Color.RED);
                    button.setText(null);
                } else if (readPanel.chessboard[i][j] >= 0) {
                    if (readPanel.gridstatus[i][j] == 0) {
                        button.setIcon(null);
                        button.setEnabled(true);
                        button.setBackground(null);
                        button.setOpaque(true);
                        button.setText(null);
                    } else if (readPanel.gridstatus[i][j] == 1) {
                        button.setIcon(null);
                        button.setEnabled(false);
                        button.setOpaque(true);
                        button.setBackground(Color.LIGHT_GRAY);
                        button.setText(readPanel.chessboard[i][j] + "");

                    }
                }
            }
        }


    }


    //设置窗口最上边的东西
    public void setHead() {
        north.add(restMine);
        north.add(restart);
        north.add(time);
        this.add(north, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer){
           if (MyFrame.sOrd == 1){
                spend ++;
            }else{
                spend --;
                if (spend == 0){
                    nextTurn();
                }
            }
            time.setText("时间：" + spend + "s");
            timer.start();
        }
    }
}