package databaseFiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static int entries;
    private static double[] avgRGB;
    private static HashMap<double[], Integer> amts = new HashMap<>();

    public static double[] getAvgRGB(){
        return avgRGB;
    }

    public static int getEntries(){
        return entries;
    }

    public static void evalAvg(double[] newRGB){
        updateAmts(newRGB);
        double[] avg = new double[3];
        for(int i = 0; i < avg.length; i++)
            avgRGB[i] = ((avgRGB[i] * entries) + newRGB[i]) / (entries + 1);
        entries++;
    }

    private static void updateAmts(double[] arr){
        if(amts.containsKey(arr))
            amts.put(arr, amts.get(arr) + 1);
        else
            amts.put(arr, amts.get(arr));  
    }


    public static void main(String[] args){
        entries = 1;

        //Yellow
        avgRGB = new double[]{255, 229, 0};
        for(int i = 0; i < 2; i++)    
            avgRGB = new double[]{255, 229, 0};
        
        //Pink    
        for(int i = 0; i < 2; i++)   
            evalAvg(new double[]{252, 87, 166});

        //Cyan    
        for(int i = 0; i < 7; i++)    
            evalAvg(new double[]{30, 235, 235});
        
        //White    
        for(int i = 0; i < 2; i++)        
            evalAvg(new double[]{255, 255, 255});
         
        //Green    
        for(int i = 0; i < 14; i++)    
            evalAvg(new double[]{28, 171, 77});

        //Purple
        for(int i = 0; i < 14; i++)
            evalAvg(new double[]{122, 54, 233});
        
        //Blue
        for(int i = 0; i < 15; i++)
            evalAvg(new double[]{25, 45, 218});

        //Red
        for(int i = 0; i < 8; i++)
            evalAvg(new double[]{245, 46, 54});

        //Orange
        for(int i = 0; i < 5; i++)
            evalAvg(new double[]{249, 131, 34});

        //Black
        for(int i = 0; i < 7; i++)
            evalAvg(new double[]{0, 0, 0});    

        System.out.println(Arrays.toString(avgRGB));

        System.out.println(amts);
    }

}