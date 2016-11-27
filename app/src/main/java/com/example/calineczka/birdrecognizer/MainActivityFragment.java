package com.example.calineczka.birdrecognizer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivityFragment extends Fragment {

    final int NUMBER_OF_QUESTIONS = 5;

    LinearLayout fragmentLinearLayout;
    LinearLayout[] answersLinearLayouts;

    TextView questionTextView;
    TextView answerTextView1;
    TextView answerTextView2;
    TextView answerTextView3;
    TextView answerTextView4;

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

        answersLinearLayouts = new LinearLayout[4];
        answersLinearLayouts[0] = (LinearLayout) view.findViewById(R.id.answersLinearLayout1);
        answersLinearLayouts[1] = (LinearLayout) view.findViewById(R.id.answersLinearLayout2);
        answersLinearLayouts[2] = (LinearLayout) view.findViewById(R.id.answersLinearLayout3);
        answersLinearLayouts[3] = (LinearLayout) view.findViewById(R.id.answersLinearLayout4);

        answerTextView1 = (TextView) view.findViewById(R.id.answerTextView1);
        answerTextView2 = (TextView) view.findViewById(R.id.answerTextView2);
        answerTextView3 = (TextView) view.findViewById(R.id.answerTextView3);
        answerTextView4 = (TextView) view.findViewById(R.id.answerTextView4);

        int i=0;
        for (LinearLayout row : answersLinearLayouts) {
           Button answerButton = (Button) row.getChildAt(0);
            answerButton.setOnClickListener(answerButtonListener);
            answerButton.setText(String.valueOf(i));
            i++;
        }


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
        answerTextView1.setText(values[0]);
        answerTextView2.setText(values[1]);
        answerTextView3.setText(values[2]);
        answerTextView4.setText(values[3]);
    }

    private View.OnClickListener answerButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Button answerButton = ((Button) v);
            int index = Integer.parseInt(answerButton.getText().toString());
            results[totalAnswers] = index;

            totalAnswers++;
            if(totalAnswers<NUMBER_OF_QUESTIONS)
                updateFragment();
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

