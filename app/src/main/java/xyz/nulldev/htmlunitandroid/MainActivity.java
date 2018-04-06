package xyz.nulldev.htmlunitandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindowEvent;
import com.gargoylesoftware.htmlunit.WebWindowListener;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import xyz.nulldev.htmlunitandroidtest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Page refreshed!", Snackbar.LENGTH_LONG)
//                        .show();
//            }
//        });

        TextView mainText = findViewById(R.id.main_text);

        new Thread(new Runnable() {
            @Override
            public void run() {
                WebClient client = new WebClient();
                client.addWebWindowListener(new WebWindowListener() {
                    @Override
                    public void webWindowOpened(WebWindowEvent event) {

                    }

                    @Override
                    public void webWindowContentChanged(WebWindowEvent event) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String nUrl = event.getNewPage().getUrl().toString();
                                mainText.append(
                                        Html.fromHtml("<br><font color='red'><b>&nbsp;&nbsp;&nbsp;&nbsp;"
                                                + nUrl
                                                + "</b></font><br>"));
                                mainText.append(String.valueOf(event.getNewPage().getWebResponse().getContentAsString()).trim());
                            }
                        });
                    }

                    @Override
                    public void webWindowClosed(WebWindowEvent event) {

                    }
                });
                try {
                    HtmlPage page = client.getPage("http://readcomiconline.to");
                } catch (Throwable t) {
                    Log.e("HU", "Failed to load page", t);
                    runOnUiThread(() -> Toast.makeText(MainActivity.this,
                            "Error: " + t.getMessage(),
                            Toast.LENGTH_LONG).show());
                }
            }
        }).start();
    }

}
