package Onebank;
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int Ci = sc.nextInt();
        int Cd = sc.nextInt();
        int Cs = sc.nextInt();
        int [][]dp = new int[s1.length()][s2.length()];
        for(int []x:dp){
            Arrays.fill(x,-1);
        }
        System.out.println(find(s1,s2,s1.length()-1,s2.length()-1,Ci,Cd,Cs,dp));
    }
    public static int find(String s1,String s2,int i,int j,int Ci,int Cd,int Cs,int [][]dp){
        if(j<0){
            return (i+1)*Cd;
        }
        if(i<0){
            return (j+1)*Ci;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = find(s1,s2,i-1,j-1,Ci,Cd,Cs,dp);
        }else{
            int insert = Ci+find(s1,s2,i,j-1,Ci,Cd,Cs,dp);
            int delete = Cd+find(s1,s2,i-1,j,Ci,Cd,Cs,dp);
            int replace = Cs+find(s1,s2,i-1,j-1,Ci,Cd,Cs,dp);
            return dp[i][j] = Math.min(insert,Math.min(delete,replace));
        }
    }
}
