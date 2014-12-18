package com.michalmazur.orphanedtexts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ComposeSmsActivity  extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Orphaned Texts does not support sending messages.", Toast.LENGTH_LONG).show();

        this.finish();
    }
}
