Design doc
===========

**SCREEN 1: ImageSelection**
* **public void** onCreate(**Bundle** savedInstanceState)
  - **super**.onCreate(savedInstanceState);
  - setContentView(R.layout._main_);
  - (GridView)findViewById(R.id.gridview); (use Gridview in xml-file for image thumbnails).
  - gridview.setAdapter(**new** ImageAdapter(**this**);        

* GridView code: **public class** ImageView **extends** BaseAdapter
  - **public** ImageAdapter(Context c)
  - **public int** getCount()
    * **return** mThumbIds.length;
  - **public Object** getItem(**int** position)
    * **return null**;
  - **public long** getItemId(**int** position)
    * **return** 0;
  - **public View** getView(**int** position, **View** convertView, **Viewgroup** parent)
    * imageView = **new** ImageView(mContext);
    * imageView.setLayoutParams(**int**, **int**)
    * imageView.setScaleType(**ImageView**.**ScaleType**.CENTER_CROP)
    * imageView.setPadding(**int**, **int**, **int**, **int**)
    * imageView.setImageResource(mThumbIds[position])
    * **return** imageView;

* gridView.setOnItemClickListener(**new** OnItemClickListener()       
    {      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**public void** onItemClick(AdapterView<?>  parent, View v, **int** position, **long** id)     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Intent puzzle = **new** Intent(mActivity, Puzzle.class);     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mActivity.startActivity(puzzle);      
    }      
    );

**SCREEN 2: Puzzle**
* ImageView img = (ImageView)findViewById(R.id._image_);
* **public class** CountDown **extends** CountDownTimer
  - **public** CountDown(**long** start, **long** interval)
    * super(3000, 1000); (= 3 seconds countdown)
  - **public void** onFinish() 
    * BitmapFactory.decodeResource(Resources r, **int** id)
    * **int** SCREEN_HEIGHT = **this**.getResources().getDisplayMetrics().pixelHeight;
    * **int** SCREEN_WIDTH = **this**.getResources().getDisplayMetrics().pixelWidth;
    * Bitmap.createScaledBitmap(Bitmap bitmap, **int** width, **int** height, **boolean** filter)
    * Divide image in n^2 - 1 tiles: SCREEN_HEIGHT/3 and SCREEN_WIDTH/3 (EASY)
    * Blank tile is black image.
    * bitmap.recycle();
* Check position of tiles:
  - ** public int** getCurrentRow(): **return** current row;
  - ** public void** setCurrentRow(**int** row): **return** current row;
  - ** public int** getCurrentCol(): **return** current col;
  - ** public void** setCurrentCol(**int** col): **return** current row;
  - Compare row and col int with solution-ints with if-statement: if correct, display winning message.
  - Blank tile is separate black image which has to replace an original part of the selected image.
* Start dialog when puzzle is solved:
  - Activity is paused (onPause()).
  - Display integer for needed moves.
  - Display congrats-text.
  - Display button for "New Game" and restart ImageSelection-activity.

**SAVING STATE:**
* Load data: **public void** onResume()
  - **super**.onResume();
  - SharedPreferences preferences = getPreferences(MODE_PRIVATE);
  - Use level-preferences.
* Save data: **public void** onPause()
  - **super**.onPause();
  - SharedPreferences preferences = getPreferences(MODE_PRIVATE);
  - preferences.edit();
  - putString("PuzzleLevel", String.valueof(GameLevel));
  - putString("ImageId", Integer.toString(ImageId);
  - commit();

**MENU:**
* **public boolean** onCreateOptionsMenu(Menu menu)
  - getMenuInflater().inflater(R.menu._puzzlemenu_, menu);
* **public boolean** onOptionsItemSelected(MenuItem item)
  - **int** id = item.getItemId();
  - **return super**.onOptionsItemSeleted(item);
* Start dialog when "Change level" in menu is tapped.
  - 3 buttons: EASY, MEDIUM & HARD
  - Checkbox: "Remember this level: "
  - When button pushed (onClickListener(**this**)) stop current puzzle-activity (use onStop()) and restart puzzle-activity (onClick() --> **new** Intent --> startActivity(intent)in selected level.
* Stop current puzzle-activity (use onStop()) and restart puzzle-activity when "Reset" in menu is tapped.
* Stop current puzzle-activity (use onStop()) and start ImageSelection-activiy when "Quit" in menu is tapped.

**Android APIs + classes:**
* android
  - R.drawable
  - R.layout
  - R.id
  - R.menu
* android.app
  - Activity
  - Dialog
* android.graphics
  - Bitmap
  - BitmapFactory
* android.view
  - AbsSavedState
  - Gravity
  - MenuInflater
  - View
  - ViewGroup
* android.widget
  - AdapterView<>
  - BaseAdapter
  - Button
  - CheckBox
  - GridView
  - LinearLayout
  - RelativeLayout
