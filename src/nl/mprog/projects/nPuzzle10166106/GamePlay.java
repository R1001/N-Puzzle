/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      GamePlay.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;


import java.util.ArrayList;
import java.util.Collections;

import android.support.v7.app.ActionBarActivity;
import android.os.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.graphics.*;


public class GamePlay extends ActionBarActivity implements OnClickListener
{
	private final long startTime = 4000;
	private final long interval = 1000;
	private TextView timertext;
	final int EASY = 3;
	
	private ArrayList<Bitmap> tileList;
	private ArrayList<ImageView> viewList;
	 
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
    	
    	// declare Bitmap and ImageView
		Bitmap tile = null;
		ImageView imgtile;
		
		// create new array lists for ImageViews and Bitmaps
		viewList = new ArrayList<ImageView>();
		tileList = new ArrayList<Bitmap>();
		
    	// iterate over rows
    	for (int i = 0; i < level; i++)
    	{
    		// add rows to table
    		tr[i] = new TableRow(this);
    		table.addView(tr[i]);
    		
    		// iterate over columns
    		for (int j = 0; j < level; j++)
    		{	
    		    // create new ImageView to display tiles
    		    imgtile = new ImageView(this);

    		    // add ImageView to array list
    			viewList.add(imgtile);
    			
    			// set number as a tag to the ImageView
    			imgtile.setTag(viewList.size() - 1);
    			
    			// set OnClickListener to ImageView
    			imgtile.setOnClickListener(this);
    			
    			// add ImageView with tile to TableRow
    			tr[i].addView(imgtile);
    			
    			// set padding on the left of and below the tile
    			imgtile.setPadding(0, 0, 3, 3);
    			
    			// create n-1 tiles and create a blank tile too
    			if (!(i == level - 1 && j == level - 1))
    			{
    				// create bitmap tile
    				tile = Bitmap.createBitmap(bitmap, x,y, tilewidth, tileheight);
    				
    				// add Bitmap to array list
    				tileList.add(tile);
    			}
    			
    			// update x coordinate
    			x += tilewidth;
    		}
    		
    		// set x coordinate to begin of the row and update y coordinate (go to next row)
    		x = 0;
    		y += tileheight;
    	}
    	
    	// reverse bitmap tiles to shuffle the loaded bitmap
    	Collections.reverse(tileList);
    	
    	// put bitmap tiles from array list to corresponding ImageViews
    	for (int i = 0; i < viewList.size() - 1; i++)
    	{
    		ImageView iv = viewList.get(i);
    		iv.setImageBitmap(tileList.get(i));
    	}
    }

	@Override
	public void onClick(View v) 
	{
		// swap tiles when clicked
		swap(v, EASY);
	}
	
	public void swap(View v, int level)
	{
		// convert tag to index integer
		int indexClickedTile = (Integer) v.getTag();
		
		// update index of blank tile
		int indexBlankTile = level*level - 1;
		
		// check if clicked tile is right next to the blank tile
		if (indexClickedTile == indexBlankTile -+ level || indexClickedTile == indexBlankTile -+ 1)
		{
			// make view invisible
			v.setVisibility(View.INVISIBLE);
				
			// declare bitmap tile for clicked bitmap
			Bitmap clickedBitmap;
				
			// replace clicked bitmap tile to blank tile
			ImageView blank = viewList.get(indexBlankTile);
			clickedBitmap = tileList.get(indexClickedTile);
			blank.setImageBitmap(clickedBitmap);
			
			// update index of blank tile
			indexBlankTile = (Integer) v.getTag();
		}
		
		// test toast
		Toast.makeText(this,"index: " + indexClickedTile, Toast.LENGTH_SHORT).show();
	}
}

