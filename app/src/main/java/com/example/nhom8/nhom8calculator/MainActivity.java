/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.nhom8.nhom8calculator;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.inputmethod.InputMethodManager;


import java.util.ArrayList;
import java.util.Queue;
import java.lang.String;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private TextView txtNotify;
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

    private Button btnMplus;
    private Button btnMminus;
    private Button btnMC;
    private String stringMC;
    private Button btnMR;

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
    private String tempExpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initWidget();
        txtExpression.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.onTouchEvent(motionEvent);
                InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                return true;
            }
        });

        setEventClickViews();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // Set id for variables
    public void initWidget() {
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtNotify = (TextView) findViewById(R.id.txtNotify);
        txtExpression = (EditText) findViewById(R.id.txtExpression);
        tempExpress = "";

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

        btnMplus = (Button) findViewById(R.id.btnMplus);
        btnMminus = (Button) findViewById(R.id.btnMminus);
        btnMC = (Button) findViewById(R.id.btnMC);
        btnMR = (Button) findViewById(R.id.btnMR);

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

        btnMplus.setOnClickListener(this);
        btnMminus.setOnClickListener(this);
        btnMC.setOnClickListener(this);
        btnMR.setOnClickListener(this);

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
        String bieuthuc = null;
        String result = null;

        switch (view.getId()) {
            case R.id.btn0:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "0");
                break;
            case R.id.btn1:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "1");
                break;
            case R.id.btn2:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "2");
                break;
            case R.id.btn3:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "3");
                break;
            case R.id.btn4:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "4");
                break;
            case R.id.btn5:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "5");
                break;
            case R.id.btn6:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "6");
                break;
            case R.id.btn7:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "7");
                break;
            case R.id.btn8:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "8");
                break;
            case R.id.btn9:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "9");
                break;
            case R.id.btnComma:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), ".");
                break;
            case R.id.btnMplus:
                //TODO Chức năng M+
                bieuthuc = txtExpression.getText().toString();
                bieuthuc = bieuthuc.replace("x", "*");
                try {
                    result = Calculator.executeCalculate(bieuthuc);
                    if (tempExpress.isEmpty())
                        tempExpress = result;
                    else
                        tempExpress = tempExpress + "+" + result;
                    txtNotify.setText("M");
                } catch (ArithmeticException e) {
                    result = e.getMessage();
                    txtResult.setText(result);
                } catch (Exception e) {
                    result = "Error";
                    txtResult.setText(result);
                }
                break;
            case R.id.btnMminus:
                //TODO Chức năng M-
                bieuthuc = txtExpression.getText().toString();
                bieuthuc = bieuthuc.replace("x", "*");
                try {
                    result = Calculator.executeCalculate(bieuthuc);
                    if (tempExpress.isEmpty())
                        tempExpress = result;
                    else
                        tempExpress = tempExpress + "-" + result;
                    txtNotify.setText("M");
                } catch (ArithmeticException e) {
                    result = e.getMessage();
                    txtResult.setText(result);
                } catch (Exception e) {
                    result = "Error";
                    txtResult.setText(result);
                }
                break;
            case R.id.btnMC:
                // TODO Chức năng MC ( Xóa chuỗi biểu thức tạm thời)
                tempExpress = "";
                txtNotify.setText("");
                break;
            case R.id.btnMR:
                //TODO Chức năng MR ( Tính kết quả chuỗi biểu thức tạm thời)
                try {
                    result = Calculator.executeCalculate(tempExpress);
                } catch (ArithmeticException e) {
                    result = e.getMessage();
                } catch (Exception e) {
                    result = "Error";
                }
                txtResult.setText(result);

                break;
            case R.id.btnPlus:

                if (txtExpression.length() == 0)
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0+");
                else if (txtExpression.getText().charAt(txtExpression.length() - 1) == '(')
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0+");
                else
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "+");

                break;
            case R.id.btnMinus:

                if (txtExpression.length() == 0)
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0-");
                else if (txtExpression.getText().charAt(txtExpression.length() - 1) == '(')
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0-");
                else
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "-");

                break;
            case R.id.btnMulti:

                if (txtExpression.length() == 0)
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0x");
                else if (txtExpression.getText().charAt(txtExpression.length() - 1) == '(')
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0x");
                else
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "x");

                break;
            case R.id.btnDivide:

                if (txtExpression.length() == 0)
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0÷");
                else if (txtExpression.getText().charAt(txtExpression.length() - 1) == '(')
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "0÷");
                else
                    txtExpression.getText().insert(txtExpression.getSelectionStart(), "÷");

                break;
            case R.id.btnClear:
                txtExpression.setText("");
                txtResult.setText("");
                break;
            case R.id.btnBackspace:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(txtExpression, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnMoNgoac:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "(");
                break;
            case R.id.btnDongNgoac:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), ")");
                break;
            case R.id.btnPhanSo:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "1÷");
                break;
            case R.id.btnMu2:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "^(2)");
                break;
            case R.id.btnMu3:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "^(3)");
                break;
            case R.id.btnMuY:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "^(");
                break;
            case R.id.btnGiaiThua:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "!");
                break;
            case R.id.btnCanBac:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "√(");
                break;
            case R.id.btnCanBacY:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "π");
                break;
            case R.id.btnE:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "ε");
                break;
            case R.id.btnLN:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "ln(");
                break;
            case R.id.btnLog:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "log(");
                break;
            case R.id.btnSin:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "sin(");
                break;
            case R.id.btnCos:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "cos(");
                break;
            case R.id.btnTan:
                txtExpression.getText().insert(txtExpression.getSelectionStart(), "tan(");
                break;
            case R.id.btnResult:
                bieuthuc = txtExpression.getText().toString();
                bieuthuc = bieuthuc.replace("x", "*");
                try {
                    result = Calculator.executeCalculate(bieuthuc);
                } catch (ArithmeticException e) {
                    result = e.getMessage();
                } catch (Exception e) {
                    result = "Error";
                }
                txtResult.setText(result);

                break;
        }
    }

    public String deleteANumber(String number) {
        int length = number.length();
        return number.substring(0, length - 1);
    }
}
