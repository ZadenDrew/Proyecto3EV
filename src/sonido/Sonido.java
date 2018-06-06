/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonido;

import java.awt.event.ActionEvent;
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
    public void ReproducirSonido() {
        if(repro==false){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\estudios\\Documents\\NetBeansProjects\\Proyecto3EV2\\src\\sonido\\Marcianito 100% real bailando cumbia.wmv.wav").getAbsoluteFile());
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