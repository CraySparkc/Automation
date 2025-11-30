package classes;

public class Box {
    private final int width;
    private final int height;
    private final int depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "BOX{width='" + width + "', height=" + height + "', depth=" + depth + "}\n";
    }
}
