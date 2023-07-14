package codes.divya.calculator;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String last_character;
    String all_characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.numbers_view);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        textView.setGravity(Gravity.BOTTOM);
    }

    public void button_clear(View view) {
        textView.setText("");
    }

    public void button_percent(View view) {
        textView.append("%");
    }

    public void button_divide(View view) {
        textView.append("/");
    }

    public void button_seven(View view) {
        textView.append("7");
    }

    public void button_eight(View view) {
        textView.append("8");
    }

    public void button_nine(View view) {
        textView.append("9");
    }

    public void button_multiply(View view) {
        textView.append("*");
    }

    public void button_four(View view) {
        textView.append("4");
    }

    public void button_five(View view) {
        textView.append("5");
    }

    public void button_six(View view) {
        textView.append("6");
    }

    public void button_minus(View view) {
        textView.append("-");
    }

    public void button_one(View view) {
        textView.append("1");
    }

    public void button_two(View view) {
        textView.append("2");
    }

    public void button_three(View view) {
        textView.append("3");
    }

    public void button_plus(View view) {
        textView.append("+");
    }

    public void button_zero(View view) {
        textView.append("0");
    }

    public void button_decimal(View view) {
        textView.append(".");
    }

    public void button_delete(View view) {
        last_character = textView.getText().toString();
        if (last_character.length() > 0) {
            last_character = last_character.substring(0, last_character.length() - 1);
        }
        textView.setText(last_character);
    }

    public void button_equals(View view) {
        all_characters = textView.getText().toString();

        all_characters = all_characters.replaceAll("X", "*");

        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();

        all_characters = context.evaluateString(scriptable, all_characters, "Javascript", 1, null).toString();
        textView.setText(all_characters);
    }
}