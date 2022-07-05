package problems.array;

import java.util.*;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);

        int counter = 0;
        result.add(temp);
        
        for(int i = 1; i<numRows; i++){
            List<Integer> newTemp = new ArrayList<>();
            newTemp.add(1);
            for(int a = 0; a<counter; a++){
                newTemp.add(temp.get(a) + temp.get(a+1));
            }
            counter++;
            newTemp.add(1);
            result.add(newTemp);
            temp = newTemp;
        }
        
        return result;
    }

    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);

        int counter = 0;
        
        for(int i = 1; i<rowIndex; i++){
            List<Integer> newTemp = new ArrayList<>();
            newTemp.add(1);
            for(int a = 0; a<counter; a++){
                newTemp.add(temp.get(a) + temp.get(a+1));
            }
            counter++;
            newTemp.add(1);
            temp = newTemp;
        }
        
        return temp;
    }
}
