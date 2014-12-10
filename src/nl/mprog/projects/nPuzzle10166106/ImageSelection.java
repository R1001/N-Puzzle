/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      ImageSelection.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * Based on Android-developersite.
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.content.*;

public class ImageSelection extends ActionBarActivity implements OnItemClickListener
{
	ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // find our grid and assign our new ImageAdapter class as the adapter for it,
        // along with an onItemClickListener
        GridView gridview = (GridView) findViewById(R.id.gridview);
        adapter = new ImageAdapter(this);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(this);
    }
        
    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
    {
    	// create the intent to open our GamePlay activity
        Intent puzzle = new Intent(this, GamePlay.class);
        	
        // pass a key:value pair into the 'extra' bundle for the intent so
        // the activity is made aware which photo was selected
        puzzle.putExtra("imageToDisplay", id);
        	
        // start GamePlay activity
        startActivity(puzzle);
    }	
    
    @Override
    protected void onStop() 
    {
    	adapter.recycleBitmaps();
    	super.onStop();
    }
    
    
 
}