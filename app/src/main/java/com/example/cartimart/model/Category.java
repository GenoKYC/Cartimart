package com.example.cartimart.model;

public class Category {
    private int id;
    private String category_name;
    private int img_url;

    private String created_at;


    public Category(int id, String category_name, int img_url, String created_at){
        this.id = id;
        this.category_name = category_name;
        this.img_url = img_url;
        this.created_at = created_at;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){this.id = id;}

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getImg_url() {
        return img_url;
    }

    public void setImg_url(int img_url) {
        this.img_url = img_url;
    }

    public String getCreated_at(){
        return created_at;
    }

    public void setCreated_at(String created_at){this.created_at = created_at;}
}
