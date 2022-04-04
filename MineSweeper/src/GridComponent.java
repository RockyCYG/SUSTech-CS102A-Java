import javax.swing.*;

//每个小格子的信息
public class GridComponent extends JComponent {
    private int row;
    private int col;
    public static int gridSize = 45;
    public GridComponent(int x, int y) {
        this.setSize(gridSize, gridSize);
        this.row = x;
        this.col = y;
    }
}
