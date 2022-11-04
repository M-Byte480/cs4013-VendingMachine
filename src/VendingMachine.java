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


   public ArrayList<Product> getProducts() {
      return products;
   }

   private boolean isContain(ArrayList<Product> array, Product product){
      for (int i = 0; (i < array.size()); i++) {
         if(array.get(i).equals(product)){
            return true;
         }
      }
      return false;
   }

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

   public void addCoin(Coin coin){
      currentCoins.addCoin(coin);
      System.out.println("Balance: €" + currentCoins.sum());
   }

   public void buyProduct(Product p){
      if(currentCoins.sum() >= p.getPrice()) {
         coins.addCoinSet(currentCoins);
         products.remove(p);
      }else{
         throw new VendingException("Not enough fund");
      }
   }

   public void addProduct(Product p, int quantity){
      for (int i = 0; i < quantity; i++) {
         products.add(p);
      }
   }

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