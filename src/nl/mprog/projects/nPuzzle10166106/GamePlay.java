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
	private final long startTime = 4000;
	private final long interval = 1000;
	private TextView timertext;
	final int EASY = 3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
  
        // find our ImageView in the layout
        final ImageView img = (ImageView) findViewById(R.id.image);
        
        // retrieve the set of data passed to us by the intent
        Bundle extras = getIntent().getExtras();
        
        // and retrieve the imageToDisplay ID from the extras bundle
        int resource = (int)extras.getLong("imageToDisplay");

        // load bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resource);
        
        // put bitmap in ImageView
        img.setImageBitmap(bitmap);
     
        // get width and height of bitmap
        final int BITMAP_WIDTH = bitmap.getWidth();
        final int BITMAP_HEIGHT = bitmap.getHeight();
        
        // create a scaled bitmap
        final Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, BITMAP_WIDTH, BITMAP_HEIGHT, true);
        
        // find our relative id
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.relative);
        
        // find our timertext id
        timertext = (TextView) findViewById(R.id.timer);
        
        // start new CounTdownTimer
        CountDownTimer countdown = new CountDownTimer(startTime, interval)
        {
        	public void onTick(long millisUntilFinished)
        	{
        		timertext.setText(" " + millisUntilFinished / 1000);
        	}
        	
        	public void onFinish()
        	{
        		timertext.setText("Start!");
        		rl.removeView(img);
        		createTiles(bitmapScaled, BITMAP_WIDTH, BITMAP_HEIGHT, EASY);
        	}	
        }.start();
    }

    protected void createTiles(Bitmap bitmap, int bitmap_width, int bitmap_height, int level)
    {
    	// find our table id
    	TableLayout table = (TableLayout) findViewById(R.id.table);
   
    	// get width and height of screen
    	// int SCREEN_WIDTH = getResources().getDisplayMetrics().widthPixels;
    	// int SCREEN_HEIGHT = getResources().getDisplayMetrics().heightPixels;
   
    	// define bitmap coordinates
    	int x = 0;
    	int y = 0;
    
    	// define TableRow array
    	TableRow tr[] = new TableRow[EASY];
    	
    	// iterate over rows
    	for (int i = 0; i < EASY; i++)
    	{
    		// add rows to table
    		tr[i] = new TableRow(this);
    		table.addView(tr[i]);
    	
    		// iterate over columns
    		for (int j = 0; j < EASY; j++)
    		{	
    			// create bitmap tile
    			Bitmap tile = Bitmap.createBitmap(bitmap, x,y, bitmap_width/level, bitmap_height/level);
    			// Bitmap tile = Bitmap.createScaledBitmap(tiles[i][j], SCREEN_WIDTH/EASY, BITMAP_HEIGHT/EASY, true);
    		
    			// create new ImageView to display tiles
    			ImageView imgtile = new ImageView(this);
    		
    			// put bitmap tile in ImageView
    			imgtile.setImageBitmap(tile);
    		
    			// add ImageView with tile to TableRow
    			tr[i].addView(imgtile);
    		
    			// TO DO: update x and y coordinate
    			
    		
    		
    		}
    	}
    }
}

