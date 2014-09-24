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
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.app.*;

public class ImageSelection extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        
        gridview.setOnClickListener(new onItemClickListener()
        {
        		public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        		{
        			Intent puzzle = new Intent(getActivity(), GamePlay.class);
        			this.startActivity(puzzle);
        		}
        }
        );     
    }		
}