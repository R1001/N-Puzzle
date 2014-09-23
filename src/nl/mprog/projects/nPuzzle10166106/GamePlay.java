package nl.mprog.projects.nPuzzle10166106;

import android.support.v7.app.ActionBarActivity;
import android.os.*;
import android.widget.*;
import android.graphics.*;


public class GamePlay extends ActionBarActivity
{
	private Bitmap img = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
       
        // manage image array
        setAdapter(new ArrayAdapter<string>(this, R.layout.gameplay, IMAGES));
        
        // set image in ImageView
        for (int i = 0; i < 10; i++)
        {
        	ImageView puzzle_i = (ImageView)findViewById(R.id.image);
        	IMAGES[i] = puzzle_i.setImageResource(R.drawable.IMAGES[i]);
        }
        
        BitmapFactory.decodeResource(getResources(), R.drawable.puzzle_0);
       
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
