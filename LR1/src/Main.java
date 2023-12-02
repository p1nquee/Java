import transport.*;

public class Main {
    public static void main(String[] args) {
        try {

            Automobile toyota = new Automobile("Toyota", 2);
            Automobile subaru = new Automobile("Subaru", 2);
            Motorcycle motorcycle = new Motorcycle("Motor",2);
            toyota.addModel("Supra", 7000);
            toyota.addModel("Camry", 4000);
            subaru.addModel("Forester", 2500);
            subaru.addModel("Outback", 2700);
            subaru.setPrice("Forester",3000);
          //  subaru.addModel("Outback", 5400);
            //subaru.addModel("Outback2", -5);
            subaru.removeModel("Outback");
            motorcycle.addModel("Yokohama", 1500);
            motorcycle.addModel("Yokohama2", 2500);
            motorcycle.removeModel("Yokohama2");

            motorcycle.addModel("Yokohama3", 3500);

            //motorcycle.removeModel("Yokohama4");
            System.out.println("Средняя стоимость автомобилей Toyota: " + StaticTransport.avgPrice(toyota));
            System.out.println("Средняя стоимость автомобилей Subaru: " + StaticTransport.avgPrice(subaru));
            System.out.println("Средняя стоимость мотоциклов: " + StaticTransport.avgPrice(motorcycle));
            StaticTransport.printAllModels(toyota);
            StaticTransport.printAllModels(subaru);
            StaticTransport.printAllModels(motorcycle);
        } catch (DuplicateModelNameException | NoSuchModelNameException e) {
            e.printStackTrace();
        }

    }
}