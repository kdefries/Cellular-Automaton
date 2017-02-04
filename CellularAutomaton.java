/* Example of One Dimensional Cellular Automaton
 * Defries, Kevin */

public class CellularAutomaton 
{
  
  private static void initializeGeneration(int[] generation) 
  {
    // for production
    for (int i = 0; i < generation.length; i++) 
    {
      generation[i] = (Math.random() < .5) ? 0 : 1;
    }
  }
  
  public static void produceGeneration(int[] lastGeneration, int[] thisGeneration, int[] updateRule) 
  {
    for (int i = 0; i < thisGeneration.length; i++) 
    {
      int sum = (i - 1 < 0 ? 0 : lastGeneration[i-1]) + (lastGeneration[i]) + 
        (i + 1 >= lastGeneration.length ? 0 : lastGeneration[i+1]);
      thisGeneration[i] = updateRule[sum];
    }
  }
  
  public static void outputGeneration(int[] generation) 
  {
    for (int cell : generation) 
    {
      System.out.print(cell);
    }
    System.out.println();
  }
  
  private static void copyGeneration(int[] thisGeneration, int[] lastGeneration) 
  {
    for (int i = 0; i < thisGeneration.length; i++) 
    {
      lastGeneration[i] = thisGeneration[i];
    }
  }
  
  public static void main(String[] args) 
  {
    int sizeOfGeneration = Integer.parseInt(args[0]);
    int countOfGeneration = Integer.parseInt(args[1]);
    
    int [] lastGeneration = new int[sizeOfGeneration];
    int [] thisGeneration = new int[sizeOfGeneration];
    int [] updateRule = new int[4];
    for (int i = 0; i < 4; i++) 
    {
      updateRule[i] = Integer.parseInt(args[2+i]);
    }
    
    // output initialize and output first generation
    initializeGeneration(thisGeneration);
    outputGeneration(thisGeneration);
    copyGeneration(thisGeneration, lastGeneration);
    
    for (int count = 0; count < countOfGeneration; count++) 
    {
      produceGeneration(lastGeneration, thisGeneration, updateRule);
      outputGeneration(thisGeneration);
      copyGeneration(thisGeneration, lastGeneration);
    }
  }
}
