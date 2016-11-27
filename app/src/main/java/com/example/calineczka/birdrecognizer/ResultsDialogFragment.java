package com.example.calineczka.birdrecognizer;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ResultsDialogFragment extends DialogFragment {
    private String message;

    public ResultsDialogFragment(String message){
        this.message = message;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(message!="")
            builder.setMessage(message);
        else
            builder.setMessage(R.string.noMatches);
        builder.setPositiveButton(R.string.restart, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getFragment().onStart();
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getFragment().onDestroyView();
            }
        });
        return builder.create();
    }
    private MainActivityFragment getFragment(){
        return (MainActivityFragment) getFragmentManager().findFragmentById(R.id.fragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivityFragment fragment = getFragment();
        if(fragment!=null)
            fragment.setDialogOnScreen(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MainActivityFragment fragment = getFragment();
        if(fragment!=null)
            fragment.setDialogOnScreen(false);
    }
}
