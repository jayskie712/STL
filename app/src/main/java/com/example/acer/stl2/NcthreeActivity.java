package com.example.acer.stl2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class NcthreeActivity extends AppCompatActivity implements View.OnClickListener {

  private Button   _backbutton;
  private TextView _textView;
  private Button   _oneButton;
  private Button   _twoButton;
  private Button   _threeButton;
  private Button   _fourButton;
  private Button   _fiveButton;
  private Button   _sixButton;
  private Button   _sevenButton;
  private Button   _eightButton;
  private Button   _nineButton;
  private Button   _clear;
  private Button   _zerobutton;
  private Button   _flush;
  private TextView     _combination;
  private TextView _amount;
  private Button   _send;
  private Button   _next;
  private CheckBox _ramble;
  private int      _MAX_INPUT_COMBI_LENGTH;
  private String   _DEFAULT_PHONE_NUMBER;
  private Button   _clearLine;
  ArrayList<String> _bets = new ArrayList<String>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);




    setContentView(R.layout.activity_ncthree);

    initViews();
    _MAX_INPUT_COMBI_LENGTH = getIntent().getIntExtra("MAX_INPUT_COMBI_LENGTH", 2);
    _DEFAULT_PHONE_NUMBER = getIntent().getStringExtra("DEFAULT_PHONE_NUMBER");
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
    _textView = (TextView)(findViewById(R.id.textView));
    _textView.setBackgroundColor(Color.BLACK);
    _textView.setTextColor(Color.WHITE);
    _oneButton = (Button) (findViewById(R.id.button_one));
    _oneButton.setOnClickListener(this);
    _twoButton = (Button)(findViewById(R.id.button_two));
    _twoButton.setOnClickListener(this);
    _threeButton = (Button) (findViewById(R.id.button_three));
    _threeButton.setOnClickListener(this);
    _fourButton = (Button) (findViewById(R.id.button_four));
    _fourButton.setOnClickListener(this);
    _fiveButton = (Button) (findViewById(R.id.button_five));
    _fiveButton.setOnClickListener(this);
    _sixButton = (Button) (findViewById(R.id.button_six));
    _sixButton.setOnClickListener(this);
    _sevenButton = (Button) (findViewById(R.id.button_seven));
    _sevenButton.setOnClickListener(this);
    _eightButton = (Button) (findViewById(R.id.button_eight));
    _eightButton.setOnClickListener(this);
    _nineButton = (Button) (findViewById(R.id.button_nine));
    _nineButton.setOnClickListener(this);
    _clear = (Button)(findViewById(R.id.button_clear));
    _clear.setOnClickListener(this);
    _zerobutton = (Button)(findViewById(R.id.button_zero));
    _zerobutton.setOnClickListener(this);
    _combination = (TextView) (findViewById(R.id.combination));
    _combination.setBackgroundColor(Color.BLACK);
    _combination.setTextColor(Color.WHITE);
    _amount = (TextView) (findViewById(R.id.amount));
    _amount.setBackgroundColor(Color.BLACK);
    _amount.setTextColor(Color.WHITE);
    _send = (Button) (findViewById(R.id.send));
    _send.setOnClickListener(this);
    _next = (Button)(findViewById(R.id.next));
    _next.setOnClickListener(this);
    _ramble = (CheckBox)(findViewById(R.id.checkBox));
    _ramble.setOnClickListener(this);
    _flush = (Button)(findViewById(R.id.button_flush));
    _flush.setOnClickListener(this);
    _clearLine = (Button)(findViewById(R.id.clear_line));
    _clearLine.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    String _btnValue = "";


    switch (v.getId()) {

    case R.id.button_one:
      _btnValue = "1";
      break;

    case R.id.button_two:
      _btnValue = "2";
      break;
    case R.id.button_three:
      _btnValue = "3";
      break;
    case R.id.button_four:
      _btnValue = "4";
      break;
    case R.id.button_five:
      _btnValue = "5";
      break;

    case R.id.button_six:
      _btnValue = "6";
      break;

    case R.id.button_seven:
      _btnValue = "7";
      break;
    case R.id.button_eight:
      _btnValue = "8";
      break;

    case R.id.button_nine:
      _btnValue = "9";
      break;

    case R.id.button_clear:
      _combination.setText("");
      _amount.setText("");
      break;

    case R.id.button_zero:
      _btnValue = "0";
      break;
    case R.id.button_flush:
      _textView.setText("");
      _bets.clear();
      break;
    case R.id.send:
      if(_bets.isEmpty()){
        Toast.makeText(getApplicationContext(), "Cannot send! Field is empty", Toast.LENGTH_LONG).show();
      }else {
        String _joint = TextUtils.join("#", _bets);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(_DEFAULT_PHONE_NUMBER, null, _joint + "#", null, null);
        _textView.setText("");
        _bets.clear();

      }
      break;
    case R.id.next:
      next();
      break;

    case R.id.clear_line:

      if(_textView.length() == 0){
        Toast.makeText(getApplicationContext(), "Cannot delete last line! Field is empty!", Toast.LENGTH_LONG).show();
      }else {
        String[] lines = _textView.getText().toString().split("\n");
        _textView.setText("");      //Clear your TextView
        int Arraylength = lines.length - 1;    // Changing "-1" will change which lines will be deleted
        for (int i = 0; i < Arraylength; i++) {
          _textView.append(lines[i] + "\n");
        }
        _bets.remove(_bets.size() - 1);
      }
      break;

    default:
      break;

    }


    if(_combination.length() >= _MAX_INPUT_COMBI_LENGTH){
      _amount.requestFocus();
      _amount.setText(_amount.getText() + _btnValue);
    }
    else if(_combination.length()<_MAX_INPUT_COMBI_LENGTH){
      _combination.requestFocus();
      _combination.setText(_combination.getText() + _btnValue);
    }else{
      _combination.setText(_combination.getText() + _btnValue);
    }




  }

public void next(){

  if(_combination.length() == _MAX_INPUT_COMBI_LENGTH && _amount.length() >= 1) {
    _textView.setText(
        _textView.getText() + "Combi: " + _combination.getText() + "      " + "Bet: "+ _amount.getText() + "\n");
    if (_ramble.isChecked()) {
      _bets.add(_combination.getText() + "-" + "R" + _amount.getText());
    } else {
      _bets.add(_combination.getText() + "-" + _amount.getText());
    }
    _combination.setText("");
    _amount.setText("");
  }else{
    Toast.makeText(getApplicationContext(), "Please Fill empty fields", Toast.LENGTH_LONG).show();
  }



}

}
