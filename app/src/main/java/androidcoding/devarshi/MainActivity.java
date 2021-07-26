package androidcoding.devarshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button button;
    private TextView textViewCounting;
    private int clickCounts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.editTextTextPersonName);
        button = (Button) findViewById(R.id.button);
        textViewCounting = (TextView) findViewById(R.id.textViewCount);

        textViewCounting.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener countOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Editable e = nameEditText.getText();
                 String userName = e.toString();
                 e.clear();*/
                String userName = nameEditText.getText().toString();
                clickCounts += 1;
                String outputDisplay = "\n" + userName + " tapped button " + clickCounts + " time";
                if (clickCounts != 1) {
                    outputDisplay += "s";
                }
                textViewCounting.append(outputDisplay);
                //nameEditText.getText().clear();
            }
        };
        button.setOnClickListener(countOnClickListener);
    }
}
