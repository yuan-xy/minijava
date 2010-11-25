package frame;

/**
 * A value that is temporarily held in a register
 *
 */
public class Temp  {
   private static int count;
   private int num;
   public String toString() {return "t" + num;}
   public Temp() { 
     num=count++;
   }
}

