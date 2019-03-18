package com.example.nhom8.nhom8calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.util.Queue;
import java.lang.String;

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

    private Button btnMoNgoac;
    private Button btnDongNgoac;
    private Button btnPhanSo;
    private Button btnMu2;
    private Button btnMu3;
    private Button btnMuY;
    private Button btnGiaiThua;
    private Button btnCanBac;
    private Button btnCanBacY;
    private Button btnE;
    private Button btnLN;
    private Button btnLog;
    private Button btnSin;
    private Button btnCos;
    private Button btnTan;

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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // Set id for variables
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

        btnMoNgoac = (Button) findViewById(R.id.btnMoNgoac);
        btnDongNgoac = (Button) findViewById(R.id.btnDongNgoac);
        btnPhanSo = (Button) findViewById(R.id.btnPhanSo);
        btnMu2 = (Button) findViewById(R.id.btnMu2);
        btnMu3 = (Button) findViewById(R.id.btnMu3);
        btnMuY = (Button) findViewById(R.id.btnMuY);
        btnGiaiThua = (Button) findViewById(R.id.btnGiaiThua);
        btnCanBac = (Button) findViewById(R.id.btnCanBac);
        btnCanBacY = (Button) findViewById(R.id.btnCanBacY);
        btnE = (Button) findViewById(R.id.btnE);
        btnLN = (Button) findViewById(R.id.btnLN);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnTan = (Button) findViewById(R.id.btnTan);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnResult = (Button) findViewById(R.id.btnResult);
    }

    // Listen event
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

        btnMoNgoac.setOnClickListener(this);
        btnDongNgoac.setOnClickListener(this);
        btnPhanSo.setOnClickListener(this);
        btnMu2.setOnClickListener(this);
        btnMu3.setOnClickListener(this);
        btnMuY.setOnClickListener(this);
        btnGiaiThua.setOnClickListener(this);
        btnCanBac.setOnClickListener(this);
        btnCanBacY.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnLN.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnBackspace.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    // Add symbols when click button
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
                    txtExpression.append(("0*"));
                } else {
                    txtExpression.append("*");
                }
                break;
            case R.id.btnDivide:
                if (txtExpression.length() == 0) {
                    txtExpression.append(("0/"));
                } else {
                    txtExpression.append("/");
                }
                break;
            case R.id.btnClear:
                txtExpression.setText("");
                break;
            case R.id.btnBackspace:
                BaseInputConnection  textFieldInputConnection = new BaseInputConnection(txtExpression, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnMoNgoac:
                txtExpression.append("(");
                break;
            case R.id.btnDongNgoac:
                txtExpression.append(")");
                break;
            case R.id.btnPhanSo:
                txtExpression.append("1/");
                break;
            case R.id.btnMu2:
                txtExpression.append("^2");
                break;
            case R.id.btnMu3:
                txtExpression.append("^3");
                break;
            case R.id.btnMuY:
                txtExpression.append("^");
                break;
            case R.id.btnGiaiThua:
                txtExpression.append("!");
                break;
            case R.id.btnCanBac:
                txtExpression.append("√");
                break;
            case R.id.btnCanBacY:
                txtExpression.append("Ö");
                break;
            case R.id.btnE:
                txtExpression.append("e");
                break;
            case R.id.btnLN:
                txtExpression.append("ln(");
                break;
            case R.id.btnLog:
                txtExpression.append("log(");
                break;
            case R.id.btnSin:
                txtExpression.append("sin(");
                break;
            case R.id.btnCos:
                txtExpression.append("cos(");
                break;
            case R.id.btnTan:
                txtExpression.append("tan(");
                break;
            case R.id.btnResult:
                String bieuthuc= txtExpression.getText().toString();
                String[] E=InfixToPostfix.tachChuoi(bieuthuc);

                Queue<String> postFix = InfixToPostfix.postfix(E);

                String result = Calculator.valueMath(postFix);
                System.out.println(result);
                txtResult.setText(result);
                break;
        }
    }

    public String deleteANumber(String number) {
        int lenght = number.length();
        String temporaryNumber = number.substring(0, lenght-1);
        return temporaryNumber;
    }
}
