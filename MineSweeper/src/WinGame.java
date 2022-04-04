import javax.sound.sampled.*;
import java.io.*;

public class WinGame {
    public static Clip flagmusic;//背景乐
    public static AudioInputStream audioInputStream;
    public static void play() {
        try {
            flagmusic = AudioSystem.getClip();
            File file=new File("D:\\java\\MineSweeper\\src\\游戏胜利.wav");
            FileInputStream fileInputStream =new FileInputStream(file);
            InputStream inputStream =new BufferedInputStream(fileInputStream);
            audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            flagmusic.open(audioInputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        flagmusic.start();//开始播放
    }
}

