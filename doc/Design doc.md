Design doc
===========

**SCREEN 1: ImageSelection**
* **public void** onCreate(**Bundle** savedInstanceState)
  - **super**.onCreate(savedInstanceState);
  - setContentView(R.layout._main_);
  - (GridView)findViewById(R.id.gridview); (use Gridview in xml-file for image thumbnails).
  - gridview.setAdapter(**new** ImageAdapter(**this**);
* **public** MyAdapter(Context context)
* gridView.setOnItemClickListener(**new** OnItemClickListener()       
    {      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**public void** onItemClick(AdapterView<?>  parent, View v, **int** position, **long** id)     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Intent puzzle = **new** Intent(mActivity, ActivityToCall.class);     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mActivity.startActivity(puzzle);      
    }      
    );        

* **public class** ImageView **extends** BaseAdapter
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

**SCREEN 2: Puzzle**
* ImageView img = (ImageView)findViewById(R.id._image_);
* **public class** CountDown **extends** CountDownTimer
  - **public** CountDown(**long** start, **long** interval)
    * super(3000, 1000);
  - **public void** onFinish() 
    * BitmapFactory.decodeResource(Resources r, **int** id)
    * **int** SCREEN_HEIGHT = getResources().getDisplayMetrics().pixelHeight;
    * **int** SCREEN_WIDTH = getResources().getDisplayMetrics().pixelWidth;
    * Bitmap.createScaledBitmap(Bitmap bitmap, **int** width, **int** height, **boolean** filter)
    * bitmap.recycle();
* SharedPreferences

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
  - PopupWindow
  - RelativeLayout
