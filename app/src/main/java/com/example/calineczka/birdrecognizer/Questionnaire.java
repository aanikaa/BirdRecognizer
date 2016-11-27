
package com.example.calineczka.birdrecognizer;

import java.util.ArrayList;
import java.util.HashMap;


class Questionnaire {

    ArrayList<String> questions;
     ArrayList<String> createQuestionnaire() {
        questions = new ArrayList<>();
        questions.add("Rozmiar");
        questions.add("Sposób poruszania się");
        questions.add("Sylwetka");
        questions.add("Długość ogona względem ciała");
        questions.add("Ubarwienie");
        return questions;
    }


    HashMap<Integer, String[]> createAnswers(ArrayList<String> questions) {
        HashMap<Integer, String[]> answers = new HashMap<>();
        for (String question : questions) {
            int k = questions.indexOf(question);
            switch (k) {
                case 0:
                    String[] answerTable = new String[4];
                    answerTable[0] = "do wielkości wróbla";
                    answerTable[1] = "do wielkości kosa";
                    answerTable[2] = "większy od kosa";
                    answerTable[3] = "nie mam pewności";
                    answers.put(k, answerTable);
                    break;
                case 1:
                    answerTable = new String[4];
                    answerTable[0] = "skoki na obu łapkach";
                    answerTable[1] = "żwawe lub spokojne kroczenie";
                    answerTable[2] = "wolny, chwiejny chód";
                    answerTable[3] = "ruch pośród gałęzi, na pniu";
                    answers.put(k, answerTable);
                    break;
                case 2:
                    answerTable = new String[4];
                    answerTable[0] = "krępa";
                    answerTable[1] = "przeciętna";
                    answerTable[2] = "bardzo smukła";
                    answerTable[3] = "nie mam pewności";
                    answers.put(k, answerTable);
                    break;
                case 3:
                    answerTable = new String[4];
                    answerTable[0] = "krótki";
                    answerTable[1] = "średniej długości";
                    answerTable[2] = "równy lub dłuższy od długości ciała";
                    answerTable[3] = "nie mam pewności";
                    answers.put(k, answerTable);
                    break;
                case 4:
                    answerTable = new String[4];
                    answerTable[0] = "jednobarwne";
                    answerTable[1] = "wielobarwne";
                    answerTable[2] = "nakrapiane lub pręgowane";
                    answerTable[3] = "nie mam pewności";
                    answers.put(k, answerTable);
                    break;
            }
        }
        return answers;
    }
}

