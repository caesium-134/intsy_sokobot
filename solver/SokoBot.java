package solver;

/*
 * Compile: javac -cp src src/main/Driver.java
 * Run: java -classpath src main.Driver mapName bot
 * 
 */
public class SokoBot {

  public String solveSokobanPuzzle(int width, int height, char[][] mapData, char[][] itemsData) {
   
    //loop through the map
    //System.out.println("Height: " + height + ", Width: " + width);
    int playerX = -1, playerY = -1;
    
    String moves;
    //how to store the position of each box?


    for(int i = 0; i < height; i++) {
      for(int j = 0; j < width; j++) {
        if(itemsData[i][j] == '@') {
          playerX = i;
          playerY = j;
        }

      }
    }

    //how would i move the player and the boxes
    // - store the current move

    System.out.println("Player pos (x, y) = " + playerX + ", " + playerY);
    
    return "rrrddll"; 
  }

  /*
   * mapData - background (wall, goal, floor)
   * itemsData - starting positions of the boxes and player
   * 
   * 
   * MAP     ITEMS     OUTPUT
   *  .        $       goal in box (*)
   *  .        @       player in goal (+)
   *  .       ' '      empty goal
   * ' '      ' '      empty floor 
   * ' '       @       player on empty floor
   * ' '       $       box on empty flor
   *  #       ' '      wall 
   * 
   * 
   * MAP
   * # - wall
   * $ - box
   * . - goal
   * ' ' - floor 
   * 
   * 
   * ITEMS
   * @ - player
   * ' ' - no item there
   * * - box on goal
   * + - player on goal
   * 
   * 
   * 1.) STORE THE CURRENT STATE OF THE GAME (recent positions of the player and boxes)
   *      - need to store the current indexes of the boxes since nagbabago siya every time the player moves the boxes
   *      - need to store the current player indexes (x, y) since nagbabago siya every time the player moves
   *      - cost 
   *      - heuristic 
   * 2.) FIND ALL POSSIBLE MOVES OF THE GAME
   *     - if mapData[i][j] == ' ' & itemData == '   '
   * 
   * 
   */

   //store index of player
   int playerRow;
   int playerCol;

   //store index of boxes/goals in a 2d array list of int? 
   //index 0 = (row, col)
   //index 1 = (row, col)

   ArrayList<ArrayList<Integer>> boxes = new ArrayList<>();
   ArrayList<Integer> box_row = new ArrayList<>();
   ArrayList<Integer> box_col = new ArrayList<>();

   ArrayList<ArrayList<Integer>> goals = new ArrayList<>();
   ArrayList<Integer> goal_row = new ArrayList<>();
   ArrayList<Integer> goal_col = new ArrayList<>();
 
   for (int i = 0; i < width; i++) {
    for (int j = 0; j < length; j++) {

        //find player
        if (itemsData[i][j] == '@' || itemsData[i][j] == '+') {
            playerRow = i;
            playerCol = j;
        }

        //find goal
        if (mapData[i][j] == '.') {
            goal_row.add(i);
            goal_col.add(j);
            boxes.add(goal_row);
            boxes.add(goal_col);
        }

        //find boxes
        if (mapData[i][j] == '$') {
            box_row.add(i);
            box_col.add(j);
            boxes.add(box_row);
            boxes.add(box_col);
        }
    }
   }

}
