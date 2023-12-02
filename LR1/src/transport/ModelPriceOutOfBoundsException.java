package transport;

public class ModelPriceOutOfBoundsException extends RuntimeException{
    public ModelPriceOutOfBoundsException(double price){
        super("Введена некорректная цена модели: " + price + ".");
    }
}
