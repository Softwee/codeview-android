package io.github.kbiakov.codeviewexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.OnCodeLineClickListener;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class ListingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        //int myColor = ContextCompat.getColor(this, R.color.code_content_background);

        final CodeView codeView = (CodeView) findViewById(R.id.code_view);

        // use chaining to build view
        codeView.highlightCode("js")
                .setColorTheme(ColorTheme.SOLARIZED_LIGHT)
                .setCodeContent(getString(R.string.listing_js));

        // do not use chaining for built view
        // (you can, but follow it should be performed sequentially)
        codeView.setCodeContent(getString(R.string.listing_java));
        codeView.setColorTheme(ColorTheme.DEFAULT);
        codeView.highlightCode("java");

        codeView.setCodeListener(new OnCodeLineClickListener() {
            @Override
            public void onCodeLineClicked(int n) {
                Log.i("example", "Line: " + n);
            }
        });
    }
}
