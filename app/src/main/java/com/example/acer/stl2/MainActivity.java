package com.example.acer.stl2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.acer.stl2.Database.DatabaseHelper;


public class MainActivity extends ActionBarActivity {

  DatabaseHelper db = new DatabaseHelper(this);
  private ImageButton _nc3;
  private ImageButton _nc2;
  private ImageButton _lc3;
  private ImageButton _lc2;
  private String      _msg;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  /*  this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
    setContentView(R.layout.activity_main);
    initViews();

    if(db.checkActive()){
      initListeners();
    }


  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {


      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void initViews(){
    _nc3 = (ImageButton)findViewById(R.id.nc3);
    _nc2 = (ImageButton)findViewById(R.id.nc2);
    _lc3 = (ImageButton)findViewById(R.id.lc3);
    _lc2 = (ImageButton)findViewById(R.id.lc2);
  }


  public void initListeners(){


    _nc3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NcthreeActivity.class);
        intent.putExtra("MAX_INPUT_COMBI_LENGTH", 3);
        intent.putExtra("DEFAULT_PHONE_NUMBER", "+639309556910");
        startActivity(intent);

      }
    });

    _nc2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NcthreeActivity.class);
        intent.putExtra("MAX_INPUT_COMBI_LENGTH", 2);
        intent.putExtra("DEFAULT_PHONE_NUMBER", "+639309556910");
        startActivity(intent);
      }
    });


    _lc3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         Intent intent = new Intent(MainActivity.this, NcthreeActivity.class);
        intent.putExtra("MAX_INPUT_COMBI_LENGTH", 3);
        intent.putExtra("DEFAULT_PHONE_NUMBER", "+639309556910");
        startActivity(intent);
      }
    });


    _lc2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NcthreeActivity.class);
        intent.putExtra("MAX_INPUT_COMBI_LENGTH", 3);
        intent.putExtra("DEFAULT_PHONE_NUMBER", "+639309556910");
        startActivity(intent);
      }
    });

  }

}
