package com.example.cartimart.model;

public class CategoryItem {

    private int id;

    private int category_id;

    private String citem_name = "";

    private int image_url;

    private String created_at;

    public CategoryItem(int id, int category_id, String citem_name, int image_url, String created_at){
        this.id = id;
        this.category_id = category_id;
        this.citem_name = citem_name;
        this.image_url = image_url;
        this.created_at = created_at;
    }

    public int getCId(){
        return id;
    }

    public void setCId(int id){this.id = id;}


    public int getCategory_id(){
        return category_id;
    }

    public void setCategory_id(int category_id){this.category_id = category_id;}


    public String getCitem_name(){
        return citem_name;
    }

    public void setCitem_name(String citem_name){this.citem_name = citem_name;}


    public int getImage_url(){
        return image_url;
    }

    public void setImage_url(int image_url){this.image_url = image_url;}

    public String getCreated_at(){ return created_at;}

    public void setCreated_at(String created_at){this.created_at = created_at;}
}
