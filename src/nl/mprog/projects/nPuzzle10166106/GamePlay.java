/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      GamePlay.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;

import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.app.*;


public class GamePlay extends ActionBarActivity
{
	// amount of time (in seconds) displaying full screen image before divided in pieces
	private static final int S = 3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
  
        // find our ImageView in the layout
        ImageView img = (ImageView)findViewById(R.id.image);
        
        // retrieve the set of data passed to us by the intent
        Bundle extras = getIntent().getExtras();
        
        // and retrieve the imageToDisplay ID from the extras bundle
        int resource = (int)extras.getLong("imageToDisplay");
        
        // set the ImageView to display the specified resource ID
        img.setImageResource(resource);

        // get display metrics in pixels
        final int SCREEN_WIDTH = this.getResources().getDisplayMetrics().widthPixels;
        final int SCREEN_HEIGHT = this.getResources().getDisplayMetrics().heightPixels;
        
        Bitmap img_scaled = Bitmap.createScaledBitmap(img, SCREEN_WIDTH, SCREEN_HEIGHT, false);
        
        // sleep for S seconds
        SystemClock.sleep(S * 1000);
    }
    
    
}
