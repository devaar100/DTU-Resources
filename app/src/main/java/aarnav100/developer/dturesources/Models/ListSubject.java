package aarnav100.developer.dturesources.Models;

public class ListSubject {
    private String subjectDisp;
    private int imgRes;

    public ListSubject(String subject, int imageResource) {
        imgRes=imageResource;
        subjectDisp=subject;
    }

    public int getImgRes()  {return imgRes;}
    public String getKann() {
        return subjectDisp;
    }
}
