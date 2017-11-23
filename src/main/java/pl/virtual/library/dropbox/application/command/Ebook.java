package pl.virtual.library.dropbox.application.command;

public class Ebook {
    private String name;
    private String id;
    private String size;
    private String pathLower;

    public Ebook(String name, String id, String size, String pathLower) {
        this.name = name;
        this.id = id;
        this.size = size;
        this.pathLower = pathLower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPathLower() {
        return pathLower;
    }

    public void setPathLower(String pathLower) {
        this.pathLower = pathLower;
    }
}
