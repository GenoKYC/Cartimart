package com.example.cartimart.model;

public class CartView {

   private int id;

   private String carti_name;

   private int carti_qty;

   private double carti_subtotal;


   public CartView(int id, String carti_name, int carti_qty, double carti_subtotal){
        this.id = id;
        this.carti_name = carti_name;
        this.carti_qty = carti_qty;
        this.carti_subtotal = carti_subtotal;
   }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}


    public String getCarti_name(){return carti_name;}

    public void setCarti_name(String carti_name){this.carti_name = carti_name;}


    public int getCarti_qty(){return  carti_qty;}

    public void setCarti_qty(int carti_qty){this.carti_qty = carti_qty;}


    public double getCarti_subtotal(){return carti_subtotal;}

    public void setCarti_subtotal(char carti_subtotal){this.carti_subtotal = carti_subtotal;}

}
