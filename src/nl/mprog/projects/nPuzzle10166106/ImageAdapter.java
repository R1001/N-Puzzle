/* * * * * * * * * * * * * * * * * * * * * * * * * * *
 * File:      ImageAdapter.java
 * 
 * Name:      Rick Bijsterveld
 * Studentnr: 10166106
 * E-mail:    rickbijsterveld@hotmail.com
 * 
 * Based on Android-developersite.
 * * * * * * * * * * * * * * * * * * * * * * * * * * */

package nl.mprog.projects.nPuzzle10166106;

import java.lang.reflect.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.content.*;

public class ImageAdapter extends BaseAdapter 
{
	// declarations
	private Context mContext;
	private Integer[] mThumbIds;
	private Bitmap[] memory;
	
	public ImageAdapter(Context c)
	{
		mContext = c;
		
		Field[] drawimgs = R.drawable.class.getFields();
		
		int counter = 0;
		
		
		for (int i = 0; i < drawimgs.length; i++)
		{
			if(drawimgs[i].getName().startsWith("puzzle_")) counter++;
		}
		
		mThumbIds = new Integer[counter];
		memory = new Bitmap[counter];
				
	}
	
	public int getCount()
	{
			return mThumbIds.length;
	}
	
	public Object getItem(int position)
	{
		return memory[position];
	}
	
	public long getItemId(int position)
	{
		return mThumbIds[position];
	}
	
	// create new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView imageView;
		
		if (convertView == null)
		{
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		}
		else
		{
			imageView = (ImageView) convertView;
		}
		
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
		
	}
}