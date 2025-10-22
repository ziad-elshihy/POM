package drivers;

public enum Browser {
EDGE {
    @Override
    public AbstractDriver getAbstractDriver() {
        return new EdgeFactory();
    }
},
CHROME {
    @Override
    public AbstractDriver getAbstractDriver() {
        return new ChromeFactory();
    }
};

    public abstract AbstractDriver getAbstractDriver();
}
