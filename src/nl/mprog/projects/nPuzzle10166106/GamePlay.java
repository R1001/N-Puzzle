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

        // load bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resource);
        
        // put bitmap in ImageView
        img.setImageBitmap(bitmap);
        
        // get width and height of bitmap
        int WIDTH = bitmap.getWidth();
        int HEIGHT = bitmap.getHeight();
        
        // define bitmap coordinates
        int x = 0;
        int y = 0;
        
        // define table
        TableLayout table = (TableLayout) findViewById(R.id.table);
       
        int row, col;
        
        // iterate over ImageViews in table
        for (row = 0; row < 3; row++)
        {
        	// define new TableRow
        	TableRow tr = new TableRow(this);
        	
        	for (col = 0; col < 3; col++)
        	{	
        		
        		// divide bitmap in tiles and put them in ImageViews
        		Bitmap tile = Bitmap.createBitmap(bitmap, x,y, WIDTH/3, HEIGHT/3);
        		
        		ImageView imgtile = (ImageView) findViewById(R.id.tile_0);
        		imgtile.setImageBitmap(tile);
            	
        		// add views
        	    tr.addView(imgtile);
        	    table.addView(tr);
        	        
        	    // declare width and height of tiles
        	    int tile_width = tile.getWidth();
        	    int tile_height = tile.getHeight();
        	        
        	    // update coordinates for next tiles
        	    x = x + tile_width;
        	    y = y + tile_height;
        	    
        	    // remove ImageView to make a blank tile
        	    if (row == 2 && col == 2)
        	    {
        	    	tr.removeView(imgtile);
        	    }
        	    
        	    
        	    
        	}	
        }
        
        //
    }
}
