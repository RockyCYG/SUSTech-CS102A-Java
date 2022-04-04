import javax.sound.sampled.*;
import java.io.*;

public class Music {
    public static Clip backGroundMusic;//背景乐
    public static AudioInputStream audioInputStream;
    public Music() {
    }
    public static void loop(){
        try {
            backGroundMusic=AudioSystem.getClip();
            File file=new File("D:\\java\\MineSweeper\\src\\荷塘月色.wav");
            FileInputStream fileInputStream =new FileInputStream(file);
            InputStream input =new BufferedInputStream(fileInputStream);
                audioInputStream=AudioSystem.getAudioInputStream(input);//获取输入流
            backGroundMusic.open(audioInputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        backGroundMusic.loop(Clip.LOOP_CONTINUOUSLY);//开始播放
    }

    public static void stop() {
        if(audioInputStream!=null)
            backGroundMusic.close();
    }
}
