package aarnav100.developer.dturesources.Models;


public class PostBlog {



   private String Title;
   private String ImageUrl;
   private String Descript;

    public PostBlog(String title, String imageUrl, String descript) {
        Title = title;
        ImageUrl = imageUrl;
        Descript = descript;
    }

    public PostBlog() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDescript() {
        return Descript;
    }

    public void setDescript(String descript) {
        Descript = descript;
    }
}
