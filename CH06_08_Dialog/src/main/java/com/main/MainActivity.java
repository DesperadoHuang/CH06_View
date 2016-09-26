package com.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt3_text);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage(R.string.input_code);
        final EditText editText = new EditText(context);
        builder.setView(editText);
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = getResources().getString(R.string.code);
                message += editText.getText();
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void showDialog_4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt4_text);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setSingleChoiceItems(R.array.drink, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<String> list = Arrays.asList(getResources().getStringArray(R.array.drink));
                Toast.makeText(context, list.get(which), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void showDialog_5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt5_text);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        final String[] drinkList = getResources().getStringArray(R.array.drink);
        final boolean[] checkList = new boolean[drinkList.length];
        builder.setMultiChoiceItems(drinkList, checkList, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkList[which] = isChecked;
            }
        });
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < checkList.length; i++) {
                    if (checkList[i]) {
                        stringBuilder.append(drinkList[i] + ", ");
                    }
                }
                Toast.makeText(context, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void showDialog_6() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt6_text);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setItems(R.array.food, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<String> foodList = Arrays.asList(getResources().getStringArray(R.array.food));
                Toast.makeText(context, foodList.get(which), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void showDialog_7() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.root));
        Button btRandom = (Button) layout.findViewById(R.id.bt_random);
        final TextView textView = (TextView) layout.findViewById(R.id.textView);
        btRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 1;
                int max = 100;
                Random random = new Random();
                int number = random.nextInt(max - min + 1) + min;
                textView.setText(String.valueOf(number));
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.bt7_text)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(layout)
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = getResources().getString(R.string.locky_number);
                        message += "：" + textView.getText();
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    private void showDialog_8() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(true);
        progressDialog.setMessage(getResources().getString(R.string.bt8_text));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        new LoadImage(progressDialog).start();
    }


    private class LoadImage extends Thread {
        ProgressDialog progressDialog;

        public LoadImage(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;

        }

        @Override
        public void run() {
            try {
                String imageUrl = getResources().getString(R.string.image_url);
                Bitmap bitmap = new ImageUtils().getImage(imageUrl);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("image", byteArray);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                progressDialog.dismiss();
            }
        }
    }
}
