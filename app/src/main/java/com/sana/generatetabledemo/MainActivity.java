package com.sana.generatetabledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TableLayout tl_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl_result = findViewById(R.id.tl_result);
        displayResultView(this, tl_result);
    }

    public static void displayResultView(Context context, TableLayout tableLayout) {

        try {

            if (tableLayout != null) {

                TableRow tableRow = new TableRow(context);
                tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                TableLayout tl_part1 = new TableLayout(context);

                tl_part1.addView(drawTableRow(context,
                        "Sr. No",
                        "Student Name",
                        "Grade", true));

                String overallResult = "Pass";
                for (int i = 0; i < 3; i++) {
                    String name = "Sana Shaikh", grade = "A";
                    tl_part1.addView(drawTableRow(context, String.valueOf(i + 1), name, grade, false));
                }

                tableRow.addView(tl_part1);

                TableLayout tl_overallResult = new TableLayout(context);

                TableRow tr_overallResult = new TableRow(context);
                TextView tv_overallResult = createTextView(context, "Overall Result(Pass/Fail)", true, 16f, Gravity.CENTER);
                tv_overallResult.setTypeface(null, Typeface.BOLD);
                tr_overallResult.addView(tv_overallResult);

                tl_overallResult.addView(tr_overallResult);

                TextView tv_overallResult1 = createTextView(context, overallResult, false, 16f, Gravity.CENTER);

                tl_overallResult.addView(tv_overallResult1);

                tableRow.addView(tl_overallResult);

                tableLayout.addView(tableRow);

            }

        } catch (Exception e) {
            Log.e("MainActivity: ", e.getMessage());
        }
    }

    private static TextView createTextView(Context context, String label, boolean drawable, Float textSize, int gravity) {

        TextView textView = new TextView(context);
        textView.setText(label);
        if (drawable) {
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.border_layout));
        }

        textView.setTextSize(textSize);
        textView.setGravity(gravity);
        textView.setPadding(32, 32, 32, 32);
        return textView;
    }


    public static TableRow drawTableRow(Context context, String srNo, String name, String grade, boolean isFirstRow) {

        TableRow tableRow = new TableRow(context);
        tableRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView tv_srNo = createTextView(context, srNo, true, 16f, Gravity.CENTER);
        TextView tv_name = createTextView(context, name, true, 16f, Gravity.CENTER);
        TextView tv_grade = createTextView(context, grade, true, 16f, Gravity.CENTER);

        if (isFirstRow) {

            tv_srNo.setTypeface(null, Typeface.BOLD);
            tv_name.setTypeface(null, Typeface.BOLD);
            tv_grade.setTypeface(null, Typeface.BOLD);
        }

        tableRow.addView(tv_srNo);
        tableRow.addView(tv_name);
        tableRow.addView(tv_grade);

        return tableRow;
    }
}