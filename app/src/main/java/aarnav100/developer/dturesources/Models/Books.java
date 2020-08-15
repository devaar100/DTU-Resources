package aarnav100.developer.dturesources.Models;

public class Books {
    private String url;
    private String name;
    private String booktype;

    public Books() {
    }

    public Books(String url, String name, String booktype) {
        this.url = url;
        this.name = name;
        this.booktype = booktype;
    }

    public String getBooktype() {
        return booktype;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setBooktitle(String name) {
        this.name = name;
    }
}
