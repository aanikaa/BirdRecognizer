package com.example.calineczka.birdrecognizer;

import java.util.ArrayList;

 class BirdInventory {

   ArrayList<Bird> createDatabase(){
        ArrayList<Bird> birds = new ArrayList<>();
        birds.add(new Bird("Rudzik", 0, 0, 1, 1, 1));
        birds.add(new Bird("Sikorka bogatka", 0, 3, 0, 1, 1));
        birds.add(new Bird("Sikorka modra", 0, 3, 0, 1, 1));
        birds.add(new Bird("Gil", 0, 0, 1, 1, 1));
        birds.add(new Bird("Kowalik", 0, 3, 0, 0, 1));
        birds.add(new Bird("Wróbel", 0, 0, 1, 1, 1));
        birds.add(new Bird("Zięba", 0, 0, 1, 1, 1));
        birds.add(new Bird("Słowik rdzawy", 1, 0, 1, 1, 0));
        birds.add(new Bird("Jemiołuszka", 1, 3, 0, 0, 1));
        birds.add(new Bird("Kos", 1, 0, 0, 1, 0));
        birds.add(new Bird("Szpak", 1, 1, 1, 1, 0));
        birds.add(new Bird("Drozd śpiewak", 1, 0, 1, 1, 2));
        birds.add(new Bird("Dzięcioł duży", 1, 3, 0, 0, 1));
        birds.add(new Bird("Sierpówka", 2, 2, 0, 0, 0));
        birds.add(new Bird("Gołąb miejski", 2, 2, 0, 0, 1));
        birds.add(new Bird("Kwiczoł", 2, 3, 1, 1, 2));
        birds.add(new Bird("Kawka", 2, 1, 0, 0, 0));
        birds.add(new Bird("Wrona siwa", 2, 1, 0, 0, 1));
        birds.add(new Bird("Sroka", 2, 1, 0, 2, 1));
        birds.add(new Bird("Mewa śmieszka", 2, 1, 1, 1, 1));
        birds.add(new Bird("Kaczka krzyżówka", 2, 2,0, 0, 1));
        birds.add(new Bird("Sójka", 2, 3, 1, 1, 1));
        return birds;
    }

}
