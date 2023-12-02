package transport;

import java.util.Arrays;

public class Automobile implements ITransport_vehicle {
    private String mark;
    private Model[] models;

    public Automobile(String mark, int size) {
        this.mark = mark;
        this.models = new Model[size];
        for (int i = 0; i < size; i++) {
            String modelName = mark + (i + 1);
            double modelPrice = 1000 * (i + 1);
            this.models[i] = new Model(modelName, modelPrice);
        }
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    private class Model {
        private String name;
        private double price;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }
        public void setName(String name){
            this.name=name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    @Override
    public String[] getNames() {
        String[] names = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            if (models[i] != null) {
                names[i] = models[i].getName();
            } else {
                names[i] = "";
            }
        }
        return names;
    }
// дописать исключение по названию
    @Override
    public void setName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        boolean found = false;
        for (Model model : models) {
            if (model != null && model.getName().equals(name)) {
                throw new DuplicateModelNameException(name);
            }
        }
        for (Model model : models) {
            if (model.getName().equals(name)) {
                model.setName(newName);
                found = true;
                break;
            }
        }
            if (!found) {
                throw new NoSuchModelNameException(name);
            }
        }

    @Override
    public double getPrice(String name) throws NoSuchModelNameException {
        for (Model model : models) {
            if (model.getName().equals(name)) {
                return model.getPrice();
            }
        }
        throw new NoSuchModelNameException(name);
    }

    @Override
    public void setPrice(String name, double price) throws NoSuchModelNameException {
        if (price < 1) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        boolean found = false;
        for (Model model : models) {
            if (model.getName().equals(name)) {
                model.setPrice(price);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchModelNameException(name);
        }
    }

    @Override
    public double[] getPrices() {
        double[] prices = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            if (models[i] != null) {
                prices[i] = models[i].getPrice();
            } else {
                prices[i] = 0;
            }
        }
        return prices;
    }

    @Override
    public void addModel(String name, double price) throws DuplicateModelNameException{
        if (price < 1) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        for (Model model : models) {
            if (model != null && model.getName().equals(name)) {
                throw new DuplicateModelNameException(name);
            }
        }
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(name, price);
    }

    @Override
    public void removeModel(String name) throws NoSuchModelNameException {
        for (int i = 0; i < models.length; i++) {
            if (models[i] != null && models[i].getName().equals(name)) {
                System.arraycopy(models, i + 1, models, i, models.length - (i + 1));
                models = Arrays.copyOf(models, models.length - 1);
                return;
            }
        }
        throw new NoSuchModelNameException(name);
    }

    @Override
    public int modelsLength() {
        return models.length;
    }
}
