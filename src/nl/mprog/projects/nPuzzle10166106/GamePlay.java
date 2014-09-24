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
import android.os.Bundle;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.app.*;


public class GamePlay extends ActionBarActivity
{
	private Bitmap img = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
  
        Intent intent = getIntent();
        
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.puzzle_0);
        ImageView image = (ImageView) findViewById(R.id.main);
        // get display metrics in pixels
        int SCREEN_HEIGHT = this.getResources().getDisplayMetrics().heightPixels;
        int SCREEN_WIDTH = this.getResources().getDisplayMetrics().widthPixels;
        
        Bitmap image_scaled = Bitmap.createScaledBitmap(img, SCREEN_WIDTH, SCREEN_HEIGHT, false);
        
        
       
        
    }
    
    static final String[] IMAGES = new String[]
    {
    	"puzzle_0",
    	"puzzle_1",
    	"puzzle_2",
    	"puzzle_3",
    	"puzzle_4",
    	"puzzle_5",
    	"puzzle_6",
    	"puzzle_7",
    	"puzzle_8",
    	"puzzle_9"
    };
    

}
