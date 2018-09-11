package vn.linh.androidsectionedgridrecyclerview.model;

public class ItemImage implements RecyclerViewItem{
    private String title;
    private String message;

    public ItemImage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}