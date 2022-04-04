import javax.sound.sampled.*;
import java.io.*;

public class BombMusic {
    public static Clip bombmusic;//背景乐
    public static AudioInputStream audioInputStream;
    public static void play() {
        try {
            bombmusic = AudioSystem.getClip();
            File file=new File("D:\\java\\MineSweeper\\src\\踩雷.wav");
            FileInputStream fileInputStream =new FileInputStream(file);
            InputStream inputStream =new BufferedInputStream(fileInputStream);
                audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            bombmusic.open(audioInputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        bombmusic.start();//开始播放
    }
}


