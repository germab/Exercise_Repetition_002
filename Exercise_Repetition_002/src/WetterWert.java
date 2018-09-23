
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class WetterWert {
    private int temperatur;
    private int luftfeuchtigkeit;
    private LocalDateTime zeitpunkt;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM - HH:mm:ss");

    public WetterWert(int temperatur, int luftfeuchtigkeit, LocalDateTime zeitpunkt) {
        this.temperatur = temperatur;
        this.luftfeuchtigkeit = luftfeuchtigkeit;
        this.zeitpunkt = zeitpunkt;
    }
    
    public String toString(){
        return String.format("%s - %d° - %d",zeitpunkt.format(dtf),temperatur,luftfeuchtigkeit)+"%\n";
    }   
}
