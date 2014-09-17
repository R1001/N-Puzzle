Design doc
===========

**SCREEN 1: ImageSelection**
* **public void** onCreate(**Bundle** savedInstanceState)
  - **super**.onCreate(savedInstanceState);
  - setContentView(R.layout._main_);
  - findViewById(R.id.gridview); (use Gridview in xml-file for image thumbnails).
  - setAdapter(**new** ImageAdapter(**this**);
  - setOnItemClickListener(**new** OnItemClickListener(       
    {      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**public void** onItemClick(AdapterView<?>  )        
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

**Android APIs + classes:**
* android
  - R.drawable
  - R.layout
  - R.id
* android.app
  - Activity
  - Dialog
* android.view
  - AbsSavedState
  - Gravity
  - MenuInflater
  - View
  - ViewGroup
  -
* android.widget
  - AdapterView<>
  - BaseAdapter
  - Button
  - CheckBox
  - GridView
  - LinearLayout
  - PopupWindow
  - RelativeLayout
