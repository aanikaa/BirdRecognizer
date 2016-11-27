package com.example.calineczka.birdrecognizer;

import java.util.Iterator;
import java.util.List;

 class SearchEngine {
     final int NUMBER_OF_QUESTIONS = 5;
     int answer =0;
    public List<Bird> searchBirds(List<Bird> birdsResult, int[] result){

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            answer= result[i];
            switch (i) {
                case 0:
                    for(Iterator<Bird> it = birdsResult.iterator(); it.hasNext();){
                        Bird bird = it.next();
                        if(answer!=bird.getSize() && answer<3){
                            it.remove();
                        }
                    }
                    break;
                case 1:
                    for(Iterator<Bird> it = birdsResult.iterator();it.hasNext();){
                        Bird bird = it.next();
                        if(bird.getMoving()!=answer){
                            it.remove();
                        }
                    }
                    break;
                case 2:
                    for(Iterator<Bird> it = birdsResult.iterator();it.hasNext();){
                        Bird bird = it.next();
                        if((bird.getSilv()!=answer) && answer<3){
                            it.remove();
                        }
                    }
                    break;
                case 3:
                    for(Iterator<Bird> it = birdsResult.iterator();it.hasNext();){
                        Bird bird = it.next();
                        if((bird.getBody()!=answer) && answer<3){
                            it.remove();
                        }
                    }
                    break;
                case 4:
                    for(Iterator<Bird> it = birdsResult.iterator();it.hasNext();){
                        Bird bird = it.next();
                        if((bird.getPlump()!=answer) && answer<3){
                            it.remove();
                        }
                    }
                    break;

            }
        }
        return birdsResult;
    }

}
