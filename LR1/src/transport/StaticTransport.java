package transport;
public class StaticTransport {
    public static double avgPrice(ITransport_vehicle vehicle) {
        double[] prices = vehicle.getPrices();
        double sum = 0.0;
        for (double price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }
    public static void printAllModels(ITransport_vehicle vehicle) {
        String[] names = vehicle.getNames();
        double[] prices = vehicle.getPrices();

        System.out.println("Models for " + vehicle.getMark() + ":");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Model: " + names[i] + ", Price: " + prices[i]);
        }
    }
}
