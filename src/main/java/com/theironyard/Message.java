package com.theironyard;

import javax.persistence.*;
/**
 * Created by BennettIronYard on 11/9/15.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    Integer id;

    String text;

    public Message() {

    }//"this is a blank constructor"

   /* public Message(String text) { //constructors
        //this.id = id;
        this.text = text;
    }
    */
    /*
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    */
}
