
package sonido;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author estudios
 */
public class Sonido {
    boolean repro=false;
    Clip clip;
/**
 * Método que reproduce un archivo de audio
 */   
    public void ReproducirSonido() {
        if(repro==false){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\estudios\\Documents\\NetBeansProjects\\sonido\\marcianito.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            repro=true;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
        }
        else{
            repro=false;
            clip.close();
        }
    }

    
    
}