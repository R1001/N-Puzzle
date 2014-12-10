/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      YouWin.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.Intent;


public class YouWin extends ActionBarActivity implements OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youwin);
        
        // retrieve the set of data passed to us by the intent
        Bundle extras = getIntent().getExtras();
        int moves = (int)extras.getLong("AmountOfMoves");
        
        // set Button and onClickListener
        Button newgame = (Button) findViewById(R.id.buttonNewGame);
        newgame.setOnClickListener(this);
        
        // pass moves into TextView
        TextView movesText = (TextView) findViewById(R.id.numbermoves);
        movesText.setText(String.valueOf(moves));
    }

	@Override
	public void onClick(View v) {
		// create the intent to open our ImageSelection activity
	    Intent imageSelection = new Intent(this, ImageSelection.class);
	        	
	    // start ImageSelection activity
	    startActivity(imageSelection);
	}
}