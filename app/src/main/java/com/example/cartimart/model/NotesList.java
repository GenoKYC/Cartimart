package com.example.cartimart.model;

public class NotesList {

    public String listTitle;
    public String content;
    public String fullname;
    public NotesList(){
        this.listTitle = listTitle;
        this.fullname = fullname;
        this.content = content;
    }

    public NotesList(String listTitle, String content, String fullname) {
        this.listTitle = listTitle;
        this.fullname = fullname;
        this.content = content;
    }

    public String getListTitle(){
        return listTitle;
    }

    public String getContent() {
        return content;
    }

    public String getFullname() {
        return fullname;
    }

    public void setListTitle(String listTitle){this.listTitle = listTitle;}

    public void setContent(String content) {
        this.content = content;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    //    public String getNotesListview(){
//        return notesListview;
//    }
//
//    public void setNotesListview(String notesListview){this.notesListview = notesListview;}
}
