package jp.ac.jec.cm0101.hotpage.models;

public class ArticleModel {
    private String title, body, imageUrl, pageUrl;

    public ArticleModel(String title, String body, String image_url, String page_url) {
        this.title = title;
        this.body = body;
        this.imageUrl = image_url;
        this.pageUrl = page_url;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }
}
