package databaseFiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static int entries;
    private static int[] avgRGB;
    private static HashMap<String, Integer> amts = new HashMap<>();

    public static int[] getAvgRGB(){
        return avgRGB;
    }

    public static int getEntries(){
        return entries;
    }

    public static void evalAvg(int[] newRGB){
        updateAmts(newRGB);
        int[] avg = new int[3];
        for(int i = 0; i < avg.length; i++)
            avgRGB[i] = ((avgRGB[i] * entries) + newRGB[i]) / (entries + 1);
        entries++;
    }

    private static void updateAmts(int[] rgbArr){
        String rgbStr = Arrays.toString(rgbArr);
        if(amts.containsKey(rgbStr))
            amts.put(rgbStr, amts.get(rgbStr) + 1);
        else
            amts.put(rgbStr, 1);  
    }


    public static void main(String[] args){
        entries = 1;

        //Yellow
        avgRGB = new int[]{255, 229, 0};
        for(int i = 0; i < 2; i++)    
            evalAvg(new int[]{255, 229, 0});
        
        //Pink    
        for(int i = 0; i < 2; i++)   
            evalAvg(new int[]{252, 87, 166});

        //Cyan    
        for(int i = 0; i < 7; i++)    
            evalAvg(new int[]{30, 235, 235});
        
        //White    
        for(int i = 0; i < 2; i++)        
            evalAvg(new int[]{255, 255, 255});
         
        //Green    
        for(int i = 0; i < 14; i++)    
            evalAvg(new int[]{28, 171, 77});

        //Purple
        for(int i = 0; i < 14; i++)
            evalAvg(new int[]{122, 54, 233});
        
        //Blue
        for(int i = 0; i < 15; i++)
            evalAvg(new int[]{25, 45, 218});

        //Red
        for(int i = 0; i < 8; i++)
            evalAvg(new int[]{245, 46, 54});

        //Orange
        for(int i = 0; i < 5; i++)
            evalAvg(new int[]{249, 131, 34});

        //Black
        for(int i = 0; i < 7; i++)
            evalAvg(new int[]{0, 0, 0});    

        System.out.println(Arrays.toString(avgRGB));

        System.out.println(amts);
    }

}