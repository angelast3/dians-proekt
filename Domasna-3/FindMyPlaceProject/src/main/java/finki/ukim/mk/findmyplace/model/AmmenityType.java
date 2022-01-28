package finki.ukim.mk.findmyplace.model;

public enum AmmenityType {
    Cafe(0),
    Bar(1);
    private final int id;

    int getId() {
        return id;
    }

    AmmenityType(int id) {
        this.id = id;
    }
}
