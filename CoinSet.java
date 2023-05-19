import java.util.ArrayList;

/**
   A set of coins.
*/
public class CoinSet
{  
   private ArrayList<Coin> set;

   /**
      Constructs a CoinSet object.
   */
   public CoinSet()
   {  
      set = new ArrayList<Coin>();
   }
   //ADD REMAINING CODE HERE

   /**
    * Add coin to an arrayList
    * @param coin
    */
   public void addCoin(Coin coin){
      set.add(coin);
   }

   /**
    * Remove coin of said coin
    * @param coin
    */
   public void removeCoin(Coin coin) {
      set.remove(coin);
   }

   /**
    * Remove coin at said index
    * @param index
    */
   public void removeCoin(int index){
      set.remove(index);
   }

   /**
    *
    * @return the arraylist of the coins
    */
   public ArrayList<Coin> getSet() {
      return set;
   }

   public double sum(){
      double sum = 0;
      for (Coin c : this.set) {
         sum += c.getValue();
      }
      return sum;
   }

   public void addCoinSet(CoinSet coinset){
      for (int i = 0; i < coinset.getSet().size(); i++) {
               this.addCoin(coinset.getSet().get(i));
               coinset.removeCoin(i);
         }
      }
   }
