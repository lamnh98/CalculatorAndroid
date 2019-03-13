package com.example.nhom8.nhom8calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private TextView txtMode;
    private EditText txtExpression;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnComma;

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMulti;
    private Button btnDivide;

    private Button btnClear;
    private Button btnBackspace;
    private Button btnResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();

    }

    public void initWidget() {

        txtResult = (TextView) findViewById(R.id.txtResult);
        txtMode = (TextView) findViewById(R.id.txtMode);
        txtExpression = (EditText) findViewById(R.id.txtExpression);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnComma = (Button) findViewById(R.id.btnComma);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDivide = (Button) findViewById(R.id.btnDivide);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnResult = (Button) findViewById(R.id.btnResult);
    }

    public void setEventClickViews() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnComma.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnBackspace.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                txtExpression.append("0");
                break;
            case R.id.btn1:
                txtExpression.append("1");
                break;
            case R.id.btn2:
                txtExpression.append("2");
                break;
            case R.id.btn3:
                txtExpression.append("3");
                break;
            case R.id.btn4:
                txtExpression.append("4");
                break;
            case R.id.btn5:
                txtExpression.append("5");
                break;
            case R.id.btn6:
                txtExpression.append("6");
                break;
            case R.id.btn7:
                txtExpression.append("7");
                break;
            case R.id.btn8:
                txtExpression.append("8");
                break;
            case R.id.btn9:
                txtExpression.append("9");
                break;
            case R.id.btnComma:
                txtExpression.append(",");
                break;
            case R.id.btnPlus:
                if (txtExpression.length() == 0) {
                    txtExpression.append(("0+"));
                } else {
                    txtExpression.append("+");
                }
                break;
            case R.id.btnMinus:
                if (txtExpression.length() == 0) {
                    txtExpression.append(("0-"));
                } else {
                    txtExpression.append("-");
                }
                break;
            case R.id.btnMulti:
                if (txtExpression.length() == 0) {
                    txtExpression.append(("0x"));
                } else {
                    txtExpression.append("x");
                }
                break;
            case R.id.btnDivide:
                if (txtExpression.length() == 0) {
                    txtExpression.append(("0÷"));
                } else {
                    txtExpression.append("÷");
                }
                break;
            case R.id.btnClear:
                txtExpression.setText("");
                break;
            case R.id.btnBackspace:
                BaseInputConnection  textFieldInputConnection = new BaseInputConnection(txtExpression, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnResult:
                // TO do
                break;
        }
    }

    public String deleteANumber(String number) {
        int lenght = number.length();
        String temporaryNumber = number.substring(0, lenght-1);
        return temporaryNumber;
    }
}
