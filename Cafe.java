/**
 * The Cafe class is a specific type of Building
 * It need to keep track of its inventory, which in this simplified world is just three ingredients and the cups to put them in
 */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for Cafe Class
     * @param name cafe name
     * @param address cafe address
     * @param nFloors cafe number of floors
     * @param nCoffeeOunces ounces of coffee in stock
     * @param nSugarPackets number of sugar packets in stock
     * @param nCreams amount of cream in stock in grams
     * @param nCups number of cups in stock
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Reduce in stock coffee supplies by the requested/sell amount
     * @param size size of coffee requested in ounces
     * @param nSugarPackets number of sugar packets requested
     * @param nCreams amount of cream requested in grams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size > nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || nCups < 1) {
            System.out.println("Stock not enough for " + size + "oz, " + nSugarPackets + " sugar packets, " + nCreams + "g; RESTOCKING...");
            restock(50, 50, 50, 100);
        }
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        nCups-=1;
        System.out.println("Coffee is ready: " + size + "oz, " + nSugarPackets + " sugar(s), " + nCreams + " gram(s) of cream!");
        
    }

    /**
     * Increase amount in stock for each item
     * @param nCoffeeOunces amount of coffee restocked in ounces
     * @param nSugarPackets number of sugar packets restocked
     * @param nCreams amount of cream restocked in grams
     * @param nCups number of cups restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Supplies restocked!");
    }

    /**
     * Print current stock
     */
    public void currentStock() {
        System.out.println("Remaining Stock: " + nCoffeeOunces + "oz, " + nSugarPackets + " sugar packes, "+ nCreams + "g, " + nCups + " cups.");
    }

    /**
     * Main method for testing the Library class.
     */
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 50, 20, 15, 10);
        compassCafe.sellCoffee(12, 2, 3);
        compassCafe.currentStock();
        compassCafe.sellCoffee(12, 2, 18);
        compassCafe.currentStock();
    }
}
