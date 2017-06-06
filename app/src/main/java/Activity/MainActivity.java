package Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.acer.stl.R;

import Listeners.SmsListener;
import Fragments.nc3Fragment;


public class MainActivity extends ActionBarActivity {
  private ImageButton _nc3;
  private ImageButton _nc2;
  private ImageButton _lc3;
  private ImageButton _lc2;
  private String _msg;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
    initListeners();
    new SmsListener();
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
    _nc3.setEnabled(false);
    _nc3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NcthreeActivity.class);
        startActivity(intent);
      }
    });


    _nc2.setEnabled(false);
    _nc2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

    _lc3.setEnabled(false);
    _lc3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {


      }
    });


    _lc2.setEnabled(false);
    _lc2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

  }

}
