package core;

public class LifeCell {
    private final int posX;
    private final int posY;

    public LifeCell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof LifeCell lifeCell)) return false;

        return posX == lifeCell.posX && posY == lifeCell.posY;
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        return result;
    }
}
