package su.hungover.saatiedot;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;



public class SaaActivity extends FragmentActivity {


    /*
    http://xml.weather.yahoo.com/forecastrss?p=FIXX0002&u=c Helsinki
    http://xml.weather.yahoo.com/forecastrss?p=FIXX0001&u=c Espoo
    http://xml.weather.yahoo.com/forecastrss?p=FIXX0018&u=c Turku
    http://xml.weather.yahoo.com/forecastrss?p=FIXX0037&u=c Lahti
    */

    static final String URL = "http://xml.weather.yahoo.com/forecastrss?p=FIXX0002&u=c";

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.saa_activity);

        XMLParser parseri = new XMLParser(URL);

        if (parseri.getCode() != ""){
            new DownloadImageTask((ImageView) findViewById(R.id.imageView))
                    .execute("http://l.yimg.com/a/i/us/we/52/"+ parseri.getCode()  +".gif");
        }

        TextView yleinenText = (TextView) findViewById(R.id.textView2);
        TextView lämpöText = (TextView) findViewById(R.id.textView3);
        TextView pvmText = (TextView) findViewById(R.id.textView4);

        yleinenText.setText( parseri.getText() );
        lämpöText.setText( parseri.getTemp()+"\u00b0 C" );
        pvmText.setText( parseri.getDate() );


    }

}
