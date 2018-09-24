
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class WetterModell extends AbstractListModel{

    private ArrayList<WetterWert> list = new ArrayList();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM - HH:mm:ss");
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int i) {
        return list.get(i);
    }
    
    public void add(WetterWert w){
        list.add(w);
        fireIntervalAdded(this, list.size()-1, list.size()-1);
    }
    
    public void save(File f)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f)))
        {
            for (WetterWert w : list) 
            {
                bw.append(""+w.getZeitpunkt()+",");
                bw.append(""+w.getTemperatur()+",");
                bw.append(""+w.getLuftfeuchtigkeit());
                bw.newLine();
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void load(File f)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(f)))
        {
            String line ="";
            while((line=br.readLine())!=null)
            {
                WetterWert w = new WetterWert(line);
                add(w);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
 
    }
    
}
