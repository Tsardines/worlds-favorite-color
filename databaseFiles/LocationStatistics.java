package databaseFiles;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class LocationStatistics{

    private double longitude;
    private double latitude;

    private int entries;
    private int[] avgRGB;
    private Map<String, Integer> amts = new HashMap<>();

    public LocationStatistics(double longitude, double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int[] getAvgRGB(){
        return avgRGB;
    }

    public int getEntries(){
        return entries;
    }

    public void evalAvg(int[] newRGB){
        updateAmts(newRGB);
        for(int i = 0; i < avgRGB.length; i++)
            avgRGB[i] = ((avgRGB[i] * entries) + newRGB[i]) / (entries + 1);
        entries++;
    }

    private void updateAmts(int[] rgbArr){
        String rgbStr = Arrays.toString(rgbArr);
        if(amts.containsKey(rgbStr))
            amts.put(rgbStr, amts.get(rgbStr) + 1);
        else
            amts.put(rgbStr, 1);  
    }

    public String getFavClr(){
        String mostPop = null;
        String equaPop = null;
        int maxVal = 0;

        for(String str: amts.keySet()){
            if(amts.get(str) > maxVal){
                mostPop = str;
                maxVal = amts.get(str);
                equaPop = null;
            }
            else if(amts.get(str) == maxVal)
                equaPop = str;
        }
        
        return equaPop == null ? mostPop : mostPop + " " + equaPop;
    }

    public int[] toArray(String str){
        String[] strArr = str.split(",");
        int[] intArr = new int[3];

        for(int i = 0; i < intArr.length; i++)
            intArr[i] = Integer.parseInt(strArr[i]);

        return intArr;
    }

}

