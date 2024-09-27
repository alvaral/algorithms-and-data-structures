package whiteboard;

// This class is for make problems 
import java.util.Arrays;
import java.util.List;

/*
Within the Amazon Gaming Distribution System, a logistics coordinator is faced with the task 
of efficiently distributing a collection of n computer games among k different children. Each game is 
characterised by its size, denoted by gameSize[i] for 1 ≤ i ≤ n. To facilitate the distribution process, 
the coordinator opts to utilise pen drives, ordering k pen drives with identical storage capacities. Each 
child can receive a maximum of 2 games, and every child must receive at least one game, also no game 
should be left unassigned. 

Considering the impracticality of transferring large game files over the internet, the strategy involves 
determining the minimum storage capacity required for the pen drives. A pen drive can only store games if 
the sum of their sizes does not exceed the pen drive's storage capacity. What is the minimum storage 
capacity of pen drives that you must order to be able to give these games to the children? 

Example: 
n = 4
gameSize[] = [9, 2, 4, 6] 
k = 3 
We note that we will need pen drives of the size of at least 9 units, to store the first game. 
This also turns out to be the minimum size of pen drives that should be ordered to give the games 
to these children. We can use the first pen drive to store the game of size 9, the 2nd one to store 
the second and third games, and the 3rd pen drive to store the fourth game. Hence, the minimum capacity 
of pen drives required is 9 units. 

parameters: List<Integer> gameSize, int k
 */
public class WhiteboardClass {

    public static int getMinPendriveCapacity(List<Integer> gamesize, int k) {

        // n computer games
        // give k childs 1 pendrive each (storing 1 or 2 games)
        // min capacity  of the pendrives to store all the games
        // high games per pendrive -> 2
        // binary search -> high: sum of all units (but every kid should have a game);  low: heaviest game
        // initialize variables
        int high = 0;
        int low = 0;
        for (int i : gamesize) {
            if (low < i) {
                low = i;
            }
            high += i;
        }

        // binary search from low to high-
        while (low < high) {
            int mid = (low + high) / 2;

            if (canBeDistributed(mid, k, gamesize)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static boolean canBeDistributed(int capacity, int kids, List<Integer> gamesize) {

        int kidsWithGames = 1; // we start with the first kid
        int currentCapacity = 0;

        for (int i = 0; i < gamesize.size(); i++) {
            if (currentCapacity + gamesize.get(i) <= capacity) {
                // if the current capacity and can add another game
                // we move to the next capacity without increasing kidwithgame

                currentCapacity = gamesize.get(i); // update current capcity
            } else {
                // if the pendrive cant have another game, 
                // I give it to the next kid
                kidsWithGames++;
                currentCapacity = gamesize.get(i);// update current capcity
                if (kidsWithGames > kids) {
                    // if there are more kidswithgames, we need more storage
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Caso de prueba 1
        List<Integer> gameSize1 = Arrays.asList(9, 2, 4, 6);
        int k1 = 3;
        int resultado1 = getMinPendriveCapacity(gameSize1, k1);
        System.out.println("Test 1 - Esperado: 9, Obtenido: " + resultado1);

        // Caso de prueba 2
        List<Integer> gameSize2 = Arrays.asList(1, 2, 3, 4);
        int k2 = 2;
        int resultado2 = getMinPendriveCapacity(gameSize2, k2);
        System.out.println("Test 2 - Esperado: 5, Obtenido: " + resultado2);

        // Caso de prueba 3
        List<Integer> gameSize3 = Arrays.asList(7, 8, 9, 10);
        int k3 = 4;
        int resultado3 = getMinPendriveCapacity(gameSize3, k3);
        System.out.println("Test 3 - Esperado: 10, Obtenido: " + resultado3);

        // Caso de prueba 4 (caso con todos los juegos del mismo tamaño)
        List<Integer> gameSize4 = Arrays.asList(5, 5, 5, 5);
        int k4 = 2;
        int resultado4 = getMinPendriveCapacity(gameSize4, k4);
        System.out.println("Test 4 - Esperado: 10, Obtenido: " + resultado4);

    }
}
