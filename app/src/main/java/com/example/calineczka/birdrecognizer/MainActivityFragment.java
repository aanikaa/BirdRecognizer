package com.example.calineczka.birdrecognizer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivityFragment extends Fragment {

    final int NUMBER_OF_QUESTIONS = 5;

    LinearLayout fragmentLinearLayout;

    TextView questionTextView;
    RadioGroup radioGroup;

    Questionnaire questionnaire;
    BirdInventory birdInventory;
    SearchEngine searchEngine;

    List<Bird> birdsDatabase;
    ArrayList<String> questions;
    HashMap<Integer, String[]> answers;
    List<Bird> birdsRecognized;

    int[] results;
    String[] values;

    int totalAnswers;
    String message;
    private boolean dialogOnScreen = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        fragmentLinearLayout = (LinearLayout) view.findViewById(R.id.fragmentLinearLayout);
        questionTextView = (TextView) view.findViewById(R.id.questionTextView);

        radioGroup = (RadioGroup) view.findViewById(R.id.answerRadioGroup);

        radioGroup.setOnCheckedChangeListener(answerButtonListener);



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        questionnaire = new Questionnaire();
        birdInventory = new BirdInventory();
        questions = questionnaire.createQuestionnaire();
        answers = questionnaire.createAnswers(questions);
        values = new String[4];
        results = new int[5];
        birdsDatabase = birdInventory.createDatabase();
        totalAnswers = 0;
        updateFragment();
        searchEngine = new SearchEngine();
    }

    void updateQuestion(int numberOfQuestion) {
        questionTextView.setText(questions.get(numberOfQuestion));
    }

    void updateAnswers(int numberOfQuestion) {
        values = answers.get(numberOfQuestion);
        ((RadioButton) radioGroup.getChildAt(0)).setText(values[0]);
        ((RadioButton) radioGroup.getChildAt(1)).setText(values[1]);
        ((RadioButton) radioGroup.getChildAt(2)).setText(values[2]);
        ((RadioButton) radioGroup.getChildAt(3)).setText(values[3]);
    }

    private RadioGroup.OnCheckedChangeListener answerButtonListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radioButton);
            results[totalAnswers] = index;

            totalAnswers++;
            if(totalAnswers<NUMBER_OF_QUESTIONS) {
                updateFragment();
               radioButton.setChecked(false);
            }
            else
                showResult();

        }
    };

    private void updateFragment() {
        updateQuestion(totalAnswers);
        updateAnswers(totalAnswers);
    }

    private void showResult() {
        birdsRecognized = searchEngine.searchBirds(birdsDatabase, results);
        message = "";
        for (Bird bird : birdsRecognized) {
            message+=bird.getName()+"\n";
        }
        ResultsDialogFragment resultFragment = new ResultsDialogFragment(message);
        resultFragment.show(getFragmentManager(), "Rozpoznane ptaki");
    }


    public void setDialogOnScreen(boolean visible){
        dialogOnScreen = visible;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

