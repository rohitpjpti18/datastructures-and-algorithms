# Pascal's Triangle | [Leetcode](https://leetcode.com/problems/pascals-triangle/)


&larr; [Back to Interview Preparation](../../InterviewPreparation.md)

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

**Example 1**

```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```
**Example 2**

```
Input: numRows = 1
Output: [[1]]
```

**Constraints:**

- `1 <= numRows <= 30`

## JAVA

### Generate all the the rows
```java 
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
```

### Generate only given row
```java 
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
```


&larr; [Back to Interview Preparation](../../InterviewPreparation.md)