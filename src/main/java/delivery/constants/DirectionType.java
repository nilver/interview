package delivery.constants;

public enum DirectionType {

    NORTE(0),ESTE(1), SUR(2), OESTE(3);
    private int position;

    DirectionType(int position) {

    }
    public int getPosition() {
        return position;
    }
}
