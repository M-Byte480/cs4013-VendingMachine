import java.util.ArrayList;

/**
   A vending machine.
*/
public class VendingMachine
{  
   private ArrayList<Product> products;
   public CoinSet coins;
   public CoinSet currentCoins;

   /**
      Constructs a VendingMachine object.
   */
   public VendingMachine()
   { 
      products = new ArrayList<Product>();
      coins = new CoinSet();
      currentCoins = new CoinSet();
   }
   //ADD REMAINING CODE HERE

   /**
    * @return ArrayList of type Products of the Products
    */
   public ArrayList<Product> getProducts() {
      return products;
   }

   /**
    * @param array   ArrayList to check for product contained
    * @param product Product to check if the arrayList contains
    * @return boolean of if the array list contains said product
    */
   private boolean isContain(ArrayList<Product> array, Product product){
      for (int i = 0; (i < array.size()); i++) {
         if(array.get(i).equals(product)){
            return true;
         }
      }
      return false;
   }

   /**
    *
    * @return array of the product of what the machine containes without any duplicates
    */
   public Product[] getProductTypes(){
      if(products.size() <= 0){
         throw new VendingException("No product in the machine");
      }

      ArrayList<Product> productsArray = new ArrayList<>();
      for (Product p : products) {
         if(!isContain(productsArray, p)){
            productsArray.add(p);
         }
      }
      return productsArray.toArray(new Product[0]);
   }

   /**
    * Add a coin to the machine
    * @param coin
    */
   public void addCoin(Coin coin){
      currentCoins.addCoin(coin);
      System.out.println("Balance: €" + currentCoins.sum());
   }

   /**
    *
    * Buy product if and only if you have enough coins inserted
    * @param p
    */
   public void buyProduct(Product p){
      if(currentCoins.sum() >= p.getPrice()) {
         coins.addCoinSet(currentCoins);
         products.remove(p);
      }else{
         throw new VendingException("Not enough fund");
      }
   }

   /**
    * Add product P to quantity times to the machine
    * @param p
    * @param quantity
    */
   public void addProduct(Product p, int quantity){
      for (int i = 0; i < quantity; i++) {
         products.add(p);
      }
   }

   /**
    * Remove money for the user if he inserted the wrong coins
    * Remove money for the operator if there is no coin inserted
    * @return money removed
    */
   public double removeMoney(){
      double removed;
      if (currentCoins.sum() != 0){
         removed = currentCoins.sum();
         currentCoins = new CoinSet();
      }else{
         removed = coins.sum();
         coins = new CoinSet();
      }
      return removed;
   }
}