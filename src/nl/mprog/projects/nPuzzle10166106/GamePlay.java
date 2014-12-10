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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;


public class GamePlay extends ActionBarActivity implements OnClickListener
{
	private final long startTime = 4000;
	private final long interval = 1000;
	private TextView timertext;
	int EASY = 3;
	int moves = 0;
	int indexBlankTile;
	
	private ArrayList<Bitmap> tileList;
	private ArrayList<ImageView> viewList;
	private ArrayList<Integer> orderedList;
	
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
        new CountDownTimer(startTime, interval)
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
    
    /* SAVING STATE? IS DIT DE GOEDE MANIER? */
    public void onResume()
    {
    	super.onResume();
    	// get saved preferences
    	SharedPreferences prefs = getPreferences(MODE_PRIVATE);
    	prefs.getInt("AmountOfMoves", moves);
    	prefs.getInt("level", EASY);
    	prefs.getInt("tilePosition", R.id.key_bitmap);
    }
    
    public void onPause()
    {
    	super.onPause();
    	
    	// build preferences object
    	SharedPreferences prefs = getPreferences(MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
    	editor.putInt("AmountOfMoves", moves);
    	editor.putInt("level", EASY);
    	editor.putInt("tilePosition", R.id.key_bitmap);
    	
    	editor.commit();
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
    			imgtile.setTag(R.id.key_view_position, viewList.size() - 1);
    			
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
    	
    	// create integer ArrayList
    	orderedList = new ArrayList<Integer>();
    	
    	// put bitmap tiles from array list to corresponding ImageViews and update integer ArrayList
    	int size = viewList.size() - 1;
    	for (int i = 0; i < size; i++)
    	{
    		ImageView imageView = viewList.get(i);
    		imageView.setImageBitmap(tileList.get(i));
    		imageView.setTag(R.id.key_bitmap, size - i);
    		orderedList.add(i);
    	}
    }

	@Override
	public void onClick(View v) 
	{
		// swap tiles when clicked
		swap(v, EASY);
		
		// check winning conditions
		winCheck();
	}
	
	public void swap(View v, int level)
	{
		// convert tag to index integer
		int indexClickedTile = (Integer) v.getTag(R.id.key_view_position);
		
		// check if puzzle has just started
		if (moves == 0)
		{
			// set start index of blank tile
			indexBlankTile = level*level - 1;
		}
		
		// check if clicked tile is right next to the blank tile
		if (indexClickedTile == indexBlankTile - level || indexClickedTile == indexBlankTile + level || indexClickedTile == indexBlankTile - 1 || indexClickedTile == indexBlankTile + 1)
		{
			// check for side grid issues
			for (int i = 1; i <= level - 2; i++)
			{
				// check for blank tile on the left side between the corners
				if (indexBlankTile == level * i && indexClickedTile == indexBlankTile - 1)
				{
					return;
				}
				// check for blank tile on the right side between the corners
				if (indexBlankTile == level * i + level - 1 && indexClickedTile == indexBlankTile + 1)
				{
					return;
				}
			}
			
			// check for blank tile in the right upper corner
			if (indexBlankTile == level - 1 && indexClickedTile == indexBlankTile + 1)
			{
				return;
			}
			
			// check for blank tile in the left lower corner
			if (indexBlankTile == level * (level - 1) && indexClickedTile == indexBlankTile - 1)
			{
				return;
			}

			// declare bitmap tile for clicked bitmap
			Bitmap clickedBitmap;
			
			// declare clicked ImageView
			ImageView clicked = (ImageView) v;
			
			// replace clicked bitmap tile to blank tile and vice versa
			ImageView blank = viewList.get(indexBlankTile);
			clickedBitmap = ((BitmapDrawable) clicked.getDrawable()).getBitmap();
			blank.setImageBitmap(clickedBitmap);
			clicked.setImageBitmap(null);
			
			// update moves
			moves++;
			
			// update index of blank tile (clicked tile becomes blank tile)
			indexBlankTile = (Integer) v.getTag(R.id.key_view_position);
		}
		
		// test toasts
		// Toast.makeText(this,"index: " + indexClickedTile, Toast.LENGTH_SHORT).show();
		// Toast.makeText(this,"moves: " + moves, Toast.LENGTH_SHORT).show();
		// Toast.makeText(this,"blank: " + indexBlankTile, Toast.LENGTH_SHORT).show();
	}

	/* WINNING CONDITIONS WERKEN NOG NIET */
	public boolean winCheck()
	{
		for (int i = 0; i < viewList.size() - 1; i++)
		{
			ImageView view = viewList.get(i);
			int bitmapPosition = (Integer) view.getTag(R.id.key_bitmap);
			//int viewPosition = (Integer) view.getTag(R.id.key_view_position);
			for (int j = 0; j <= orderedList.size(); j++)
			{
				if (orderedList.get(j) != bitmapPosition)
				{
					// Toast.makeText(this, "Bitmap: "+bitmapPosition, 500).show();
					// Toast.makeText(this, "Volgorde: "+orderedList.size(), 500).show();
					return false;
				}
			}
		}
		
		// create the intent to open our YouWin activity
	    Intent youWin = new Intent(this, YouWin.class);
	        	
	    // pass a key:value pair into the 'extra' bundle
	    youWin.putExtra("AmountOfMoves", moves);
	        	
	    // start YouWin activity
	    startActivity(youWin);
	    
	    // finish current activity
	    finish();
	    
	    return true;
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // check which menu item has been clicked
        switch (item.getItemId())
        {
        	case R.id.level:
        		/* HOE HIER LEVELS IMPLEMENTEREN? */
        		return true;
        		
        	case R.id.reset:
        		// get current GamePlay Intent
        		Intent gamePlay = getIntent();
        		
        		// finish GamePlay intent
        		finish();
        		
        		// restart this intent
        		startActivity(gamePlay);
        		
        		return true;
        		
        	case R.id.quit:
        		// create the intent to open our ImageSelection activity
        	    Intent imageSelection = new Intent(this, ImageSelection.class);
        	    
        	    // start ImageSelection activity
        	    startActivity(imageSelection);
        	    
        		return true;
        		
        	default:
        		return super.onOptionsItemSelected(item);
        }
    }
}

