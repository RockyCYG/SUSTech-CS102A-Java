import javax.sound.sampled.*;
import java.io.*;

public class FlagWrong {
    public static Clip flagmusic;//背景乐
    public static AudioInputStream audioInputStream;
    public static void play() {
        try {
            flagmusic = AudioSystem.getClip();
            File file=new File("D:\\java\\MineSweeper\\src\\插旗错误.wav");
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


