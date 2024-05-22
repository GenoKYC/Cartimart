package com.example.cartimart.model;

import java.io.Serializable;

public class Cart implements Serializable
{
    private int id;

    private String usern;
    private String item_name;
    private double item_price;
    private int item_qty;
    private double item_subtotal;
    private String created_at;

    private int img_view;

    public Cart(int pid, String usern, String pitem_name, double pitem_prc, int pitem_qty, double pitem_subtotal){
        this.id = pid;
        this.usern = usern;
        this.item_name = pitem_name;
        this.item_price = pitem_prc;
        this.item_qty = pitem_qty;
        this.item_subtotal = pitem_subtotal;
        this.created_at = created_at;
    }

    public int getId(){return id; }

    public void setId(int id){this.id = id;}

    public String getUsern(){return usern;}

    public void setUsern(String usern){this.usern = usern;}

    public String getItem_name(){return item_name; }

    public void setItem_name(String item_name){this.item_name = item_name;}

    public double getItem_price(){return item_price;}

    public void setItem_price(double item_price){this.item_price = item_price;}

    public int getItem_qty(){return item_qty;}

    public void setItem_qty(int item_qty){this.item_qty = item_qty;}

    public double getItem_subtotal(){return  item_subtotal;}

    public void setItem_subtotal(double item_subtotal){this.item_subtotal = item_subtotal;}

    public String getCreated_at(){return created_at;}

    public void setCreated_at(String created_at){this.created_at = created_at;}

    public int getImg_view(){
        return img_view;
    }

    public void setImage_url(int img_view){this.img_view = img_view;}
}

// add getter and setter below
//Done



