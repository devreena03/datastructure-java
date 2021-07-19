package array;

import java.util.ArrayList;
import java.util.List;

public class MatrixOperation {
	
	List<Integer> res;
	
//			[[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]
//			[[9, 10, 9]]
//			[[3],[2]]
//			[[1,2,3],[4,5,6],[7,8,9]]
//			[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//			[[3]]
//			[[1,2,3,4,6,5,6],[5,6,7,8,7,8,9]]
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	 int n = matrix.length;
         int m = matrix[0].length;
         res = new ArrayList<>();      
        
         spiral(matrix, 0, n-1, 0, m-1);
         return res;
     }
     
     private void spiral(int[][] arr, int start_i, int end_i, int start_j,int end_j){
         
         if(start_i>end_i || start_j>end_j) return;
         
          if(start_i==end_i){
             for(int j=start_j; j<=end_j; j++){
                 res.add(arr[start_i][j]); 
             }  
             return;
         }
         
         if(start_j==end_j){
             for(int i=start_i; i<=end_i; i++){
                 res.add(arr[i][start_j]); 
             } 
             return;
         }  
         
         int i = start_i;
         int j = start_j;
         
         while(j<end_j)
             res.add(arr[i][j++]);
         
         while(i<end_i)
             res.add(arr[i++][j]);
         
         while(j>start_j)
             res.add(arr[i][j--]);
         
         while(i>start_i)
             res.add(arr[i--][j]);
         
         spiral(arr, start_i+1, end_i -1, start_j +1, end_j-1);
    }

}
