/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      ImageAdapter.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;

import java.lang.reflect.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.content.*;

public class ImageAdapter extends BaseAdapter 
{
	// a list of resource IDs for the images we want to display
	private Integer[] images;
	
	// a context so we can later create a view within it
	private Context myContext;
	
	// store a cache of resized bitmaps
	private Bitmap[] cache;
	
	public ImageAdapter(Context c)
	{
		myContext = c;
		
		// obtain a list of all the objects in the R.drawable class
		Field[] list = R.drawable.class.getFields();
		
		int count = 0, index = 0, j = list.length;
		
		// loop over all of the fields in the R.drawable
		for (int i = 0; i < j; i++)
		{
			if(list[i].getName().startsWith("puzzle_")) count++;
		}
		
		// reserve memory for an array of integers with length 'count' and initialize our cache
		images = new Integer[count];
		cache = new Bitmap[count];
		
		// try to get the values of each of those fields into the images array
		try {
			for (int i = 0; i < j; i++)
			{
				// pull for every field in the drawable R.java that starts with 'puzzle_' that ID and remember it in the other array called ‘images’
				if (list[i].getName().startsWith("puzzle_"))
					images[index++] = list[i].getInt(null);
			}
		}
		catch (IllegalAccessException e) 
		{
		}
	}
	
	// the number of items in the adapter
	public int getCount()
	{
			return images.length;
	}
	
	// not implemented, but normally would return the object at the specified position
	public Object getItem(int position)
	{
		return null;
	}
	
	// return the resource ID of the item at the current position
	public long getItemId(int position)
	{
		return images[position];
	}
	
	// create a new ImageView when requested
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// we've been asked for an ImageView at a specific position. If one doesn't already exist,
		// then we must create one. Otherwise we can pass it convertView or a recycled view that's
		// been passed to us.
		ImageView imgView;
		
		if (convertView == null)
		{
			// create a new view
			imgView = new ImageView(myContext);
			imgView.setLayoutParams(new GridView.LayoutParams(160, 160));
		}
		else
		{
			// recycle an old view
			imgView = (ImageView) convertView;
		}
		
		if (cache[position] == null)
		{
			// create a new Bitmap that stores a resized version of the image
			// we want to display
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 4;
			Bitmap thumb = BitmapFactory.decodeResource(myContext.getResources(), images[position], options);
		
			// store the resized thumb in a cache so we don't have to re-generate it
			cache[position] = thumb;
		}
		// use the resized image we have in cache
		imgView.setImageBitmap(cache[position]);
		
		return imgView;	
	}
}