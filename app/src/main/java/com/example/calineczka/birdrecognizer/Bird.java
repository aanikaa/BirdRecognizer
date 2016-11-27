package com.example.calineczka.birdrecognizer;

/**
 * Created by aanikaa
 */

class Bird {


    private int size;
    private int moving;
    private int silv;
    private int body;
    private int plump;
    private String name;

    Bird(String name, int size, int moving, int silv, int body, int plump){
        this.name = name;
        this.size = size;
        this.moving = moving;
        this.silv = silv;
        this.body = body;
        this.plump = plump;

    }
    String getName(){ return name; }

    int getSize() {return size;}

    int getMoving() {
        return moving;
    }

    int getSilv() {
        return silv;
    }

    int getBody() {
        return body;
    }

    int getPlump() {
        return plump;
    }



}
