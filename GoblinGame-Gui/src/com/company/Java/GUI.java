package com.company.Java;

import com.company.Java.Land.Land;
import com.company.Java.Land.Location;
import com.company.Java.Land.Paths;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

import static com.company.Java.Main.height;
import static com.company.Java.Main.width;

public class GUI {
    private String title = "new frame";
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public GUI(String title, HashMap<Location,Land> worldMap){
       // JFrame frame = new JFrame();
        //JPanel panel = new JPanel();

        setTitle(title);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(5,5));


        //HashMap<Location,JLabel> guiMap = getIconMap(worldMap);


        PrintFrame(worldMap);




    }

    public HashMap<Location,JLabel> getIconMap(HashMap<Location,Land> worldMap){


      //  Paths p = new Paths();


        HashMap<Location,JLabel> guiMap = new HashMap<>();

        for(Location l:worldMap.keySet()){

            String path= worldMap.get(l).getPath();

            /*

            switch (worldMap.get(l).getType()) {
                case GRASS:
                    path = p.getGraPathNormal();
                    break;
                case HUT:
                    path = p.getHutPathNormal();
                    break;
                case CASTLE:
                    path = p.getCasPathNormal();
                    break;

            }
*/
            JLabel label = new JLabel();


            Image image= new ImageIcon(path).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
            //ImageIcon imageIcon = new ImageIcon(image);




           // label.setIcon(new ImageIcon(image));
                label.setText(l.toString()+" "+worldMap.get(l).getTypeEnum());
            guiMap.put(l,label);
        }

        return guiMap;
    }

    public void PrintFrame(HashMap<Location,Land> worldMap){

        HashMap<Location,JLabel> guiMap = getIconMap(worldMap);
        panel.removeAll();




                for(int y=0;y<height;y++){
                    for(int x=0;x<width;x++){
                Location loBuf = new Location(x,y);
                for(Location l: guiMap.keySet()){
                    if(loBuf.Same(l)){
                        System.out.println(x+" "+y+ " " +l);
                        panel.add(guiMap.get(l));
                    }
                }

            }

        }






        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(getTitle());
        frame.pack();
        frame.setSize(1200,800);

        frame.setVisible(true);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}

