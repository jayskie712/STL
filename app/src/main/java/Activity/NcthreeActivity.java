package Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.acer.stl.R;


public class NcthreeActivity extends ActionBarActivity {

  private Button _backbutton;
  private TextView _textView;
  private Button _oneButton;
  private Button _twoButton;
  private Button _threeButton;
  private Button _fourButton;
  private Button _fiveButton;
  private Button _sixButton;
  private Button _sevenButton;
  private Button _eightButton;
  private Button _nineButton;
  private Button _clear;
  private Button _zerobutton;
  private Button _backspace;
  private EditText _combination;
  private EditText _amount;
  private Button _send;
  private Button _next;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.nc3fragment);

    initViews();

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_ncthree, menu);
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
    _backbutton = (Button)(findViewById(R.id.prevbutton));
    _textView = (TextView)(findViewById(R.id.textView));
    _oneButton = (Button) (findViewById(R.id.button_one));
    _twoButton = (Button)(findViewById(R.id.button_two));
    _threeButton = (Button) (findViewById(R.id.button_three));
    _fourButton = (Button) (findViewById(R.id.button_four));
    _fiveButton = (Button) (findViewById(R.id.button_five));
    _sixButton = (Button) (findViewById(R.id.button_six));
    _sevenButton = (Button) (findViewById(R.id.button_seven));
    _eightButton = (Button) (findViewById(R.id.button_eight));
    _nineButton = (Button) (findViewById(R.id.button_nine));
    _clear = (Button)(findViewById(R.id.button_clear));
    _zerobutton = (Button)(findViewById(R.id.button_zero));

  }
}
