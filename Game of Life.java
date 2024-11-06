import java.util.HashMap;
import java.util.Map;

public class GameOfLife {
    public static void main(String[] args){

        for(int i = 0; i < n; i++){
            goNextState();
            countRepeatedStates();
        }

        printState();
    }

    public static int[][] state = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}};
    public static int n = 103;
    public static HashMap<String, Integer> count = new HashMap<>();


    public static int len1=state.length;
    public static int len2=state[0].length;

    public static int returnAlive(int x, int y){

        int count = 0;
        for(int i = x-1; i <= x+1; i++){
            for(int j = y-1; j <= y+1; j++){

                if(state[((i + 5) % len1)][(j+5) % len2] == 1 &&  !(i == x && j == y)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void goNextState(){

        int[][] nextCellState = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){

                int num = returnAlive(i, j);

                if(state[i][j] == 1){
                    if(num < 2 || num > 3){
                        nextCellState[i][j] = 0;
                    } else{
                        nextCellState[i][j] = 1;
                    }
                } else{
                    if(num == 3){
                        nextCellState[i][j] = 1;
                    } else{
                        nextCellState[i][j] = 0;
                    }
                }
            }
        }
        state = nextCellState;
    }

    public static void countRepeatedStates(){

        StringBuffer sb = new StringBuffer();
        for (int[] arr : state) {
            for (int j = 0; j < len2; j++) {
                sb.append(arr[j]);
            }
        }
        String stateStr = sb.toString();

        if(count.containsKey(stateStr)){
            count.put(stateStr, count.get(stateStr) + 1);
        }
        else{
            count.put(stateStr, 1);
        }
    }


    public static String getStateStr(){

        StringBuffer str= new StringBuffer();
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                str.append(state[i][j]);
            }
        }

        return str.toString();
    }

    public static boolean checkStateStr(String str) {

        int len=str.length();
        for (int i = 0; i < len; i++) {

            if (str.charAt(i)=='1') {
                return true;
            }
        }

        return false;
    }

    public static void printState(){

        int maxValue = 0;
        int flag = 0;
        for(int number : count.values()){
            maxValue = Math.max(maxValue, number);
        }

        System.out.println(maxValue);

        for(Map.Entry<String, Integer> map : count.entrySet()){
            if(map.getValue() == maxValue){
                flag++;
                for(int i = 0; i < len1; i++){
                    for(int j = 0; j < len2; j++){
                        if(flag == 3) {
                            System.out.print(map.getKey().charAt(i * len1 + j));
                        }
                    }
                    if(flag == 3) {
                        System.out.println();
                    }
                }
            }
        }
    }

}
