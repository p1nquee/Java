package transport;
import java.util.Date;
import java.util.Objects;

public class Motorcycle implements ITransport_vehicle{
    private class Model{
        String name = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
    private int size = 0;
    private Model head;
    private String mark;
    private Model[] models;
    private long lastModified;
    {
        lastModified = System.currentTimeMillis();
    }
    // Дописать конструктор с параметрами
    public Motorcycle(){
        head = new Model();
        head.prev = head;
        head.next = head;
    }
    public Motorcycle(String mark, int size) throws DuplicateModelNameException {

        head = new Model();
        head.prev = head;
        head.next = head;
        this.mark = mark;
        this.models = new Model[size];
        for (int i = 0; i < size; i++) {
            String modelName = mark + (i + 1);
            double modelPrice = 1000 * (i + 1);
            addModel(modelName, modelPrice);
        }
    }
    public int getSize(){
        return size;
    }
    public long getLastModified(){
        return lastModified;
    }
    @Override
    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (price < 1) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        Model current = head.next;


        while(current != head){
            if(current.getName().equals(name)){
                throw new DuplicateModelNameException(name);
            }

            current = current.next;
        }

        Model newModel = new Model();

        newModel.setName(name);
        newModel.setPrice(price);
        newModel.next = head;
        newModel.prev = head.prev;
        head.prev.next = newModel;
        head.prev = newModel;
        size++;
        lastModified = System.currentTimeMillis();
    }



    @Override
    public int modelsLength() {
        return size;
    }

    public void removeModel(String name) throws NoSuchModelNameException{
        Model current = head.next;
        while (current != head) {
            if (current.getName().equals(name)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                lastModified = System.currentTimeMillis();
                return;
            }

            current = current.next;
        }
        throw new NoSuchModelNameException(name);
    }
    @Override
    public double[] getPrices(){
        double[] prices = new double[size];
        Model current = head.next;
        int index = 0;
        while (current != head){
            prices[index] = current.getPrice();
            current = current.next;
            index++;
        }
        return prices;
    }
    //проверка на имя (дубликат)
    public void setName(String name, String name2) throws NoSuchModelNameException, DuplicateModelNameException {
        Model current = head.next;
        while(current != head){
            if(current.getName().equals(name)){
                throw new DuplicateModelNameException(name);
            }
            current = current.next;
        }
        while (current != head) {
            if (current.getName().equals(name)) {
                current.setName(name2);
                return;
            }
            current = current.next;
        }
        throw new NoSuchModelNameException(name);
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark=mark;

    }
    @Override
    public double getPrice(String name) throws NoSuchModelNameException{
        Model current = head.next;
        while(current != head){
            if(current.getName().equals(name)){
                return current.getPrice();
            }
            current = current.next;
        }
        throw new NoSuchModelNameException(name);
    }
    @Override
    public String[] getNames(){
        String[] names = new String[size];
        Model current = head.next;
        for(int i = 0; i < size; i++){
            names[i] = current.getName();
            current = current.next;
        }
        return names;
    }
    @Override
    public void setPrice(String name, double price) throws NoSuchModelNameException{
        if (price < 1) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        Model current = head.next;
        while(current != head){
            if(current.getName().equals(name)){
                current.setPrice(price);
                return;
            }
            current = current.next;
        }
        throw new NoSuchModelNameException(name);
    }
}