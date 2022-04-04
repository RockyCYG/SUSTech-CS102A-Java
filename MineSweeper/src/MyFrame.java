import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

//组装窗口
@SuppressWarnings("all")
public class MyFrame extends JFrame{
    private int row;
    private int col;
    private int mineCount;
    public static int sOrd = 0;   //判断是single  or  double       single时为1，double时为2，初始化时为0
    public static boolean isAI = false;

    JMenu pattern = new JMenu("模式");
    JMenu help = new JMenu("帮助");
    JMenuItem introduce = new JMenuItem("介绍");
    JMenuItem rule = new JMenuItem("规则");
    JMenu SinglePlayer = new JMenu("单人游戏");
    JMenu DoublePlayers = new JMenu("双人游戏");
    JMenu look = new JMenu("查看");

    JMenuItem Easy1 = new JMenuItem("初级");
    JMenuItem Medium1 = new JMenuItem("中级");
    JMenuItem Hard1 = new JMenuItem("高级");
    JMenuItem SelfDefine1 = new JMenuItem("自定义");

    JMenuItem Easy2 = new JMenuItem("初级");
    JMenuItem Medium2 = new JMenuItem("中级");
    JMenuItem Hard2 = new JMenuItem("高级");
    JMenuItem SelfDefine2 = new JMenuItem("自定义");

    JMenuItem AI = new JMenuItem("人机模式");

    JMenuItem seeBomb = new JMenuItem("开天眼");
    JMenuItem closeBomb = new JMenuItem("关天眼");

    JMenuItem heroRank = new JMenuItem("英雄榜");

    GamePanel gamePanel;//记录当前的GamePanel
    GamePanel lastPanel;//记录上一次的GamePanel
    GamePanel readPanel;//记录读取的GamePanel


    JMenu saveAndRead = new JMenu("存档与读档");

    JMenuItem save = new JMenuItem("存档");
    JMenuItem read = new JMenuItem("读档");

    JMenu skin = new JMenu("皮肤");

    JMenuItem skin1 = new JMenuItem("皮肤1");
    JMenuItem skin2 = new JMenuItem("皮肤2");
    JMenuItem skin3 = new JMenuItem("皮肤3");
    JMenuItem skin4 = new JMenuItem("皮肤4");
    JMenuItem skin5 = new JMenuItem("皮肤5");



    public MyFrame(int row, int col,int mineCount) {
        Music.loop();
        repaint();
        this.row = row;
        this.col = col;
        this.mineCount = mineCount;

        this.setTitle("2021 CS102A Project MineSweeper");
        this.setBounds(600, 0, col * GridComponent.gridSize + 20, row * GridComponent.gridSize + 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //time.setVisible(true);


        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(pattern);
        menuBar.add(help);
        menuBar.add(saveAndRead);
        menuBar.add(look);
        menuBar.add(skin);

        SinglePlayer.add(Easy1);
        SinglePlayer.add(Medium1);
        SinglePlayer.add(Hard1);
        SinglePlayer.add(SelfDefine1);
        DoublePlayers.add(Easy2);
        DoublePlayers.add(Medium2);
        DoublePlayers.add(Hard2);
        DoublePlayers.add(SelfDefine2);


        pattern.add(SinglePlayer);
        pattern.add(DoublePlayers);
        pattern.add(AI);

        help.add(introduce);
        help.add(rule);
        help.add(seeBomb);
        help.add(closeBomb);

        saveAndRead.add(save);
        saveAndRead.add(read);

        look.add(heroRank);

        skin.add(skin1);
        skin.add(skin2);
        skin.add(skin3);
        skin.add(skin4);
        skin.add(skin5);



        //ScoreBoard scoreBoard = new ScoreBoard();
        //scoreBoard.setVisible(true);
        //setHeader();

        //this.setProgressText();
        //
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == introduce) {
                    JOptionPane.showMessageDialog(null, "      扫雷最原始的版本可以追溯到1973年一款名为\n“方块”的游戏。" +
                            "不久，“方块”被改写成了游戏\n“Rlogic”。在“Rlogic”里，玩家的任务是作为美\n国海军陆战队队员，为指挥中心探出一条没有地雷\n的安全路线，如果路全被地雷堵死就算输。两年后\n，汤姆·安德森在“Rlogic”的基础上又编写出了\n游戏“地雷”，由此奠定了现代扫雷游戏的雏形。\n" +
                            "1981年，微软公司的罗伯特·杜尔和卡特·约翰逊两\n位工程师在Windows3.1系统上加载了该游戏，扫雷\n游戏才正式在全世界推广开来。\n", "介绍", JOptionPane.PLAIN_MESSAGE);
                }
                if (e.getSource() == rule) {
                    JOptionPane.showMessageDialog(null, "左键单击：在判断出不是雷的方块上按下左键，可以打开该方块。如果方块上出现数字，则该数字表示其周围3×3区域中的地雷数（一般为8个格子，对于边块为5个格子，对于角块为3个格子。所以扫雷中最大的数字为8）；如果方块上为空（相当于0），则可以递归地打开与空相邻的方块；如果不幸触雷，则游戏结束。\n" +
                            "右键单击：在判断为地雷的方块上按下右键，可以标记地雷（显示为小红旗）。重复一次或两次操作可取消标记（如果在游戏菜单中勾选了“标记(?)”，则需要两次操作来取消标雷）。\n" +
                            "双击：同时按下左键和右键完成双击。当双击位置周围已标记雷数等于该位置数字时操作有效，相当于对该数字周围未打开的方块均进行一次左键单击操作。地雷未标记完全时使用双击无效。若数字周围有标错的地雷，则游戏结束，标错的地雷上会显示一个“ ×”。", "规则", JOptionPane.PLAIN_MESSAGE);
                }

                //单人
                if (e.getSource() == Easy1) {
                    isAI = false;
                    sOrd = 1;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel(9, 9, 10);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    gamePanel.setVisible(true);
                    lastPanel = gamePanel;
                }
                if (e.getSource() == Medium1) {
                    isAI = false;
                    sOrd = 1;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel(16, 16, 40);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                }
                if (e.getSource() == Hard1) {
                    isAI = false;
                    sOrd = 1;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel(16, 30, 99);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                }
                if (e.getSource() == SelfDefine1) {
                    isAI = false;
                    sOrd = 1;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    String r = JOptionPane.showInputDialog("请输入行数(9-24)");
                    String c = JOptionPane.showInputDialog("请输入列数(9-30)");
                    String m = JOptionPane.showInputDialog("请输入雷数(10-360)");
                    int row = Integer.parseInt(r);
                    int col = Integer.parseInt(c);
                    int mineCount = Integer.parseInt(m);
                    while (mineCount > 0.5 * row * col) {
                        JOptionPane.showMessageDialog(null, "您设置的雷数过多，请重新设置！", "提示", JOptionPane.WARNING_MESSAGE);
                        m = JOptionPane.showInputDialog("请输入雷数(10-360)");
                        mineCount = Integer.parseInt(m);
                    }
                    gamePanel = new GamePanel(row, col, mineCount);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }

                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                }


                if (e.getSource() == Easy2) {
                    isAI = false;
                    sOrd = 2;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel(9,9,10);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                    //myFrame.setBounds(300, 0, 9 * GridComponent.gridSize + 20, 9 * GridComponent.gridSize + 200);
                }
                if (e.getSource() == Medium2) {
                    isAI = false;
                    sOrd = 2;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel(16,16,40);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                    //myFrame.setBounds(300, 0, 16 * GridComponent.gridSize + 20, 16 * GridComponent.gridSize + 200);
                }
                if (e.getSource() == Hard2) {
                    isAI = false;
                    sOrd = 2;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel(16,30,99);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                    //myFrame.setBounds(300, 0, 30 * GridComponent.gridSize + 20, 16 * GridComponent.gridSize + 200);
                }
                //先放在这
                if (e.getSource() == SelfDefine2) {
                    isAI = false;
                    sOrd = 2;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    String r = JOptionPane.showInputDialog("请输入行数(9-24)");
                    String c = JOptionPane.showInputDialog("请输入列数(9-30)");
                    String m = JOptionPane.showInputDialog("请输入雷数(10-360)");
                    int row = Integer.parseInt(r);
                    int col = Integer.parseInt(c);
                    int mineCount = Integer.parseInt(m);
                    while (mineCount > 0.5 * row * col) {
                        JOptionPane.showMessageDialog(null, "您设置的雷数过多，请重新设置！", "提示", JOptionPane.WARNING_MESSAGE);
                        m = JOptionPane.showInputDialog("请输入雷数(10-360)");
                        mineCount = Integer.parseInt(m);
                    }
                    gamePanel = new GamePanel(row, col, mineCount);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }

                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                    //myFrame.setBounds(300, 0, col * GridComponent.gridSize + 20, row * GridComponent.gridSize + 200);


                }


                //开透视
                if (e.getSource() == seeBomb) {
                    isAI = false;
                    if (gamePanel == null){
                        JOptionPane.showMessageDialog(null,"请先开始游戏！","提示",JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        gamePanel.seeBombs();
                    }
                }

                //关透视
                if (e.getSource() == closeBomb) {
                    isAI = false;
                    if (gamePanel == null){
                        JOptionPane.showMessageDialog(null,"请先开始游戏！","提示",JOptionPane.WARNING_MESSAGE);
                    }else {
                        gamePanel.closeBombs();
                    }
                }



                if (e.getSource() == save) {
                    isAI = false;
                    if (gamePanel == null) {
                        JOptionPane.showMessageDialog(null, "请先开始游戏！", "提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                        gamePanel.saveGame();
                    }
                }


                if (e.getSource() == read) {
                    isAI = false;
                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    gamePanel = new GamePanel();
                    readPanel = gamePanel.readGame();
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }
                    gamePanel.validate();
                    gamePanel.repaint();
                    add(readPanel);
                    gamePanel = readPanel;

                    lastPanel = gamePanel;
                }
                if (e.getSource() == heroRank){
                    GamePanel p = new GamePanel();
                    p.readHero();
                }

                if (e.getSource() == skin1) {
                    try {
                        UIManager.setLookAndFeel(MyLookAndFeel.SYS_METAL);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (InstantiationException instantiationException) {
                        instantiationException.printStackTrace();
                    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                        unsupportedLookAndFeelException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                if (e.getSource() == skin2) {
                    try {
                        UIManager.setLookAndFeel(MyLookAndFeel.SYS_CDE_MOTIF);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (InstantiationException instantiationException) {
                        instantiationException.printStackTrace();
                    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                        unsupportedLookAndFeelException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                if (e.getSource() == skin3) {
                    try {
                        UIManager.setLookAndFeel(MyLookAndFeel.SYS_NIMBUS);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (InstantiationException instantiationException) {
                        instantiationException.printStackTrace();
                    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                        unsupportedLookAndFeelException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                if (e.getSource() == skin4) {
                    try {
                        UIManager.setLookAndFeel(MyLookAndFeel.SYS_WINDOWS);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (InstantiationException instantiationException) {
                        instantiationException.printStackTrace();
                    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                        unsupportedLookAndFeelException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                if (e.getSource() == skin5) {
                    try {
                        UIManager.setLookAndFeel(MyLookAndFeel.SYS_WINDOWS_CLASSIC);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (InstantiationException instantiationException) {
                        instantiationException.printStackTrace();
                    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                        unsupportedLookAndFeelException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }








                if (e.getSource() == AI) {
                    sOrd = 2;
                    isAI = true;

                    if (lastPanel != null) {
                        remove(lastPanel);
                    }
                    String r = JOptionPane.showInputDialog("请输入行数(9-24)");
                    String c = JOptionPane.showInputDialog("请输入列数(9-30)");
                    String m = JOptionPane.showInputDialog("请输入雷数(10-360)");
                    int row = Integer.parseInt(r);
                    int col = Integer.parseInt(c);
                    int mineCount = Integer.parseInt(m);
                    while (mineCount > 0.5 * row * col) {
                        JOptionPane.showMessageDialog(null, "您设置的雷数过多，请重新设置！", "提示", JOptionPane.WARNING_MESSAGE);
                        m = JOptionPane.showInputDialog("请输入雷数(10-360)");
                        mineCount = Integer.parseInt(m);
                    }
                    gamePanel = new GamePanel(row, col, mineCount);
                    if (lastPanel != null) {
                        if (lastPanel.gameProgressText != null) {
                            lastPanel.getGameProgressText().dispose();
                        }
                    }

                    add(gamePanel);
                    gamePanel.validate();
                    gamePanel.repaint();
                    lastPanel = gamePanel;
                }

            }
        };
        introduce.addActionListener(listener);
        rule.addActionListener(listener);

        Easy1.addActionListener(listener);
        Medium1.addActionListener(listener);
        Hard1.addActionListener(listener);
        SelfDefine1.addActionListener(listener);

        Easy2.addActionListener(listener);
        Medium2.addActionListener(listener);
        Hard2.addActionListener(listener);
        SelfDefine2.addActionListener(listener);

        seeBomb.addActionListener(listener);
        closeBomb.addActionListener(listener);

        save.addActionListener(listener);
        read.addActionListener(listener);

        heroRank.addActionListener(listener);
        AI.addActionListener(listener);

        skin1.addActionListener(listener);
        skin2.addActionListener(listener);
        skin3.addActionListener(listener);
        skin4.addActionListener(listener);
        skin5.addActionListener(listener);



        seeBomb.setAccelerator(KeyStroke.getKeyStroke('D', InputEvent.CTRL_MASK));
        closeBomb.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.CTRL_MASK));
        heroRank.setAccelerator(KeyStroke.getKeyStroke('M',InputEvent.CTRL_MASK));
        AI.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
        read.setAccelerator(KeyStroke.getKeyStroke('H',InputEvent.CTRL_MASK));





        this.setVisible(true);
    }
}
