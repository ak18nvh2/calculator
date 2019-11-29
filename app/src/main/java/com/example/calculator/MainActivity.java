package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_xoa, btn_xoaHet, btn_cong, btn_tru, btn_nhan, btn_chia, btn_bang;
    private TextView tvRes;
    private EditText edtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();

    }

    public void init() {
        tvRes = findViewById(R.id.tvRes);
        edtInput = findViewById(R.id.edtInput);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_xoa = findViewById(R.id.btn_xoa);
        btn_xoaHet = findViewById(R.id.btn_xoaHet);
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_chia = findViewById(R.id.btn_chia);
        btn_bang = findViewById(R.id.btn_bang);
    }

    public void setEvent() {
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_cong.setOnClickListener(this);
        btn_tru.setOnClickListener(this);
        btn_nhan.setOnClickListener(this);
        btn_chia.setOnClickListener(this);
        btn_xoa.setOnClickListener(this);
        btn_xoaHet.setOnClickListener(this);
        btn_bang.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_0) {
            edtInput.append("0");
        }
        if (v.getId() == R.id.btn_1) {
            edtInput.append("1");
        }
        if (v.getId() == R.id.btn_2) {
            edtInput.append("2");
        }
        if (v.getId() == R.id.btn_3) {
            edtInput.append("3");
        }
        if (v.getId() == R.id.btn_4) {
            edtInput.append("4");
        }
        if (v.getId() == R.id.btn_5) {
            edtInput.append("5");
        }
        if (v.getId() == R.id.btn_6) {
            edtInput.append("6");
        }
        if (v.getId() == R.id.btn_7) {
            edtInput.append("7");

        }
        if (v.getId() == R.id.btn_8) {
            edtInput.append("8");
        }
        if (v.getId() == R.id.btn_9) {
            edtInput.append("9");

        }
        if (v.getId() == R.id.btn_chia) {
            edtInput.append("/");

        }
        if (v.getId() == R.id.btn_nhan) {
            edtInput.append("*");

        }
        if (v.getId() == R.id.btn_cong) {
            edtInput.append("+");

        }
        if (v.getId() == R.id.btn_tru) {

            edtInput.append("-");
        }
        if (v.getId() == R.id.btn_xoaHet) {
            edtInput.setText("");
        }
        if (v.getId() == R.id.btn_xoa) {
            BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtInput, true);
            textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
        }
        if (v.getId() == R.id.btn_bang) {
            String s = edtInput.getText().toString();
            tvRes.setText(ress(s));


        }


    }

    public String ress(String s) {

        int demnc = 0;
        DecimalFormat df= new DecimalFormat("###.#####");

        //-----------------------------------------------------------------------------
        //----------------------------------------------------------------------------
        //luu cac so vao mang
        int demdau = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') {
                demdau++;
            }
            if (s.charAt(i) == '/' || s.charAt(i) == '*') {
                demnc++;
            }
        }
        int n = demdau + 1;
        int dich = 0;
        int q = 0;
        double[] a = new double[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') {
                String s2 = s.substring(dich, i);
                dich = i + 1;
                a[q++] = Integer.parseInt(s2);
            }
        }
        a[q] = Integer.parseInt(s.substring(dich, s.length()));
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        //-----------------------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------------------
        // tao mang b
        demdau = 0;
        dich = 0;
        double[] b = new double[n];
        int indexArrb = 0;
        if (demnc == 0) {
            for (int i = 0; i < n; i++) {
                b[indexArrb++] = a[i];
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                    demdau++;
                }
                if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                    for (int j = dich; j < demdau - 1; j++) {
                        b[indexArrb++] = a[j];
                    }
                    dich = demdau + 1;
                }
                if (s.charAt(i) == '/') {
                    double x = a[demdau - 1] / a[demdau];

                    b[indexArrb++] = x;
                }
                if (s.charAt(i) == '*') {
                    double x = a[demdau - 1] * a[demdau];
                    b[indexArrb++] = x;

                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                    if (s.charAt(i) == '+' || s.charAt(i) == '-')
                        b[indexArrb++] = a[n - 1];
                    break;
                }
            }

        }
        for (int i = 0; i < indexArrb; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("");
        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////
        //tinh ket qua
        int cc = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                cc++;
            } else if (s.charAt(i) == '-') {
                cc++;
                b[cc] *= -1;

            }
        }
        float res = 0;
        for (int i = 0; i < indexArrb; i++) {
            res += b[i];
        }
        return  (df.format(res))+"";


    }
}
