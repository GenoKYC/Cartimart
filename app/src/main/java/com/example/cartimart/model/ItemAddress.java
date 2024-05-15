package com.example.cartimart.model;

public class ItemAddress {

    private String address_name;

    private int contact_number;

    private String location;

    private String blk_address;


    public ItemAddress(String address_name, int contact_number, String location,String blk_address){
        this.address_name = address_name;
        this.contact_number = contact_number;
        this.location = location;
        this.blk_address = blk_address;
    }

    public ItemAddress() {

    }

    public String getAddress_name() {return address_name;}

    public void setAddress_name(String address_name){this.address_name = address_name;}

    public int getContact_number() {return contact_number;}

    public void setContact_number(int contact_number){this.contact_number = contact_number;}

    public String getLocation() {return location;}

    public void setLocation(String location){this.location = location;}

    public String getBlk_address() {return blk_address;}

    public void setBlk_address(String blk_address){this.blk_address = blk_address;}

}
