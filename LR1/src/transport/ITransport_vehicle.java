package transport;
public interface ITransport_vehicle {
    String getMark();
    void setMark(String mark);
    String[] getNames();
    void setName(String name, String name2) throws NoSuchModelNameException, DuplicateModelNameException;
    double getPrice(String name) throws NoSuchModelNameException;
    void setPrice(String name, double price) throws NoSuchModelNameException, ModelPriceOutOfBoundsException;
    double[] getPrices();
    void addModel(String name, double price) throws DuplicateModelNameException, ModelPriceOutOfBoundsException;
    void removeModel(String name) throws NoSuchModelNameException;
    int modelsLength();
}