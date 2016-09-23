package com.main;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                showDialog_1();
                break;
            case R.id.button2:
                showDialog_2();
                break;
            case R.id.button3:
                showDialog_3();
                break;
            case R.id.button4:
                showDialog_4();
                break;
            case R.id.button5:
                showDialog_5();
                break;
            case R.id.button6:
                showDialog_6();
                break;
            case R.id.button7:
                showDialog_7();
                break;
            case R.id.button8:
                showDialog_8();
                break;
        }
    }

    private void showDialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt1_text);
        builder.setMessage("測試");
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, R.string.OK, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, R.string.cancel, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void showDialog_2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt2_text);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage("測試");
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, R.string.OK, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, R.string.cancel, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.on_idea, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, R.string.on_idea, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showDialog_3() {

    }

    private void showDialog_4() {

    }

    private void showDialog_5() {

    }

    private void showDialog_6() {

    }

    private void showDialog_7() {

    }

    private void showDialog_8() {

    }
}
