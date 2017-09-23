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
}
