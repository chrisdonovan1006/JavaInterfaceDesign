package com.livebythecode.dvn.javainterfacedesign;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set up the layout
        RelativeLayout rlayout = new RelativeLayout(this);
        rlayout.setBackgroundColor(Color.GREEN);

        // set up the button
        Button redButton = new Button(this);
        redButton.setText("Login");
        redButton.setBackgroundColor(Color.RED);

        // set edit text
        EditText username = new EditText(this);

        // set id values
        redButton.setId(1);
        username.setId(2);

        // add rules to button
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // set rules to edit text
        RelativeLayout.LayoutParams usernameParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // set username position
        usernameParams.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameParams.setMargins(0,0,0,50);

        // set button position
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                200, r.getDisplayMetrics()
        );

        username.setWidth(px);

        // add the button to the view
        rlayout.addView(redButton, buttonParams);
        rlayout.addView(username, usernameParams);

        // set the layout to the app
        setContentView(rlayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
