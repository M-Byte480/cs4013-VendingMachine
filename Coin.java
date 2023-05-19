/**
   A coin with a monetary value.
*/
public class Coin
{
   private double value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin.
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   //ADD REMAINING CODE HERE

   /**
    *
    * @return value of coin
    */
   public double getValue() {
      return value;
   }

   @Override
   public String toString() {
      return name;
   }
}