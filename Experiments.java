import java.util.*;

public class Experiments{
    public static void main(String[] args) {
        Experiments obj = new Experiments();
        int[][] grid = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int res = obj.equalPairs(grid);
        System.out.println("res: "+res);
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<int[], Integer> hm = new HashMap<>();
        int count = 0;

        for(int[] row: grid){
            hm.put(row, hm.getOrDefault(row, 0)+1);
        }

        for(int i=0; i<n; i++){
            int idx = 0;
            int[] list = new int[n];
            for(int j=0; j<n; j++){
                list[idx++] = grid[j][i];
            }
            for(int[] row : hm.keySet()){
                if(Arrays.equals(row, list)) count += hm.get(row);
            }
        }
        return count;
    }
}