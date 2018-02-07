package pl.virtual.library.dropbox.application.command;

public class Ebook {
    private String name;
    private String id;
    private String size;
    private String path_lower;

    //TOdo mapowanie jsona musi byc takie same jak w otrzymywanym json (nie pathlower/ tylko path_lower)
    public Ebook(String name, String id, String size, String path_lower) {
        this.name = name;
        this.id = id;
        this.size = size;
        this.path_lower = path_lower;
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
        return path_lower;
    }

    public void setPathLower(String path_lower) {
        this.path_lower = path_lower;
    }

    @Override
    public String toString() {
        return "Ebook{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", size='" + size + '\'' +
            ", path_lower='" + path_lower + '\'' +
            '}';
    }
}
