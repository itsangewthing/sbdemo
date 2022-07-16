package sbboot.sbdemo;

public class Photo {
    // raw data
    private String id;
    private String fileName;

    public Photo(String id, String fileName) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Photo (String id) {
        this.id = id;
        this.fileName = fileName;
    }
}
