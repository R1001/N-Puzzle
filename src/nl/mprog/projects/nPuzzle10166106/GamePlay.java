/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      GamePlay.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.*;
import android.view.View;
import android.widget.*;
import android.graphics.*;


public class GamePlay extends ActionBarActivity
{
	private final long startTime = 4000;
	private final long interval = 1000;
	private TextView timertext;
	final int EASY = 3;
	
	private ArrayList<Bitmap> tileList;
	private ArrayList<ImageView> viewList;
	private ImageView[][] viewcache;
	 
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
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resource);
        
        // put bitmap in ImageView
        img.setImageBitmap(bitmap);
     
        // get width and height of bitmap
        final float BITMAP_WIDTH = bitmap.getWidth();
        final int BITMAP_HEIGHT = bitmap.getHeight();
        
        // get screen width and calculate the factor
        final int SCREEN_WIDTH = getResources().getDisplayMetrics().widthPixels;
        final int scaledHeight = (int)((SCREEN_WIDTH/BITMAP_WIDTH)*BITMAP_HEIGHT);
        
        // create a scaled bitmap
        final Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, SCREEN_WIDTH, scaledHeight, true);
        
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
        		rl.removeView(timertext);
        		rl.removeView(img);
        		bitmap.recycle();
        		createTiles(bitmapScaled, SCREEN_WIDTH, scaledHeight, EASY);
        	}	
        }.start();
    }
    
    
    protected void createTiles(Bitmap bitmap, int bitmap_width, int bitmap_height, int level)
    {
    	// find our table id
    	TableLayout table = (TableLayout) findViewById(R.id.table);
    	
    	// define bitmap coordinates
    	int x = 0;
    	int y = 0;
    	
    	// define tile width and height
    	int tilewidth= bitmap_width/level;
    	int tileheight = bitmap_height/level;
    	
    	// define TableRow, bitmap tile and ImageView
    	TableRow tr[] = new TableRow[level];
		Bitmap tile = null;
		ImageView imgtile;
		viewList = new ArrayList<ImageView>();
    	// iterate over rows
    	for (int i = 0; i < level; i++)
    	{
    		// add rows to table
    		tr[i] = new TableRow(this);
    		table.addView(tr[i]);
    		
    		// iterate over columns
    		for (int j = 0; j < level; j++)
    		{	
    			// create bitmap tile
    		    tile = Bitmap.createBitmap(bitmap, x,y, tilewidth, tileheight);
    			
    		    // create new ImageView to display tiles
    		    imgtile = new ImageView(this);
    			
    			// put bitmap tile in ImageView
    			imgtile.setImageBitmap(tile);
    			
    			// add ImageView with tile to TableRow
    			tr[i].addView(imgtile);
    			
    			// set padding on the left of and below the tile
    			imgtile.setPadding(0, 0, 3, 3);
    		
    			// update x coordinate
    			x += tilewidth;
    			viewList.add(imgtile);
    			
    			Collections.reverse(viewList);
    			/*
    			 *  create blank tile
    			 */
    			
    			// create new cache array for ImageViews
        		viewcache = new ImageView[level][level];
        		
        		// put ImageViews in array
        		viewcache[i][j] = imgtile;
        		
        		// check position of ImageView to find the tile which has to be blank
        		if (viewcache[i][j] == viewcache[level - 1][level - 1])
        		{
        			viewcache[level - 1][level - 1].setVisibility(View.INVISIBLE);
        		}
    		}
    		// set x coordinate to begin of the row and update y coordinate (go to next row)
    		x = 0;
    		y += tileheight;
    	}
    }
}

