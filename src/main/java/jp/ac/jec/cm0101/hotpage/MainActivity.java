package jp.ac.jec.cm0101.hotpage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import jp.ac.jec.cm0101.hotpage.adapter.HPFragmentStatePagerAdapter;
import jp.ac.jec.cm0101.hotpage.listener.HPOnPageChangeListener;


public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
//    private final String[] DUMMY_DATA = {
//            "mhidaka",
//            "rongon_xp",
//            "kacchi0516",
//            "kobashinG",
//            "seit",
//            "kei_i_t",
//            "furusin_oriver"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new HPFragmentStatePagerAdapter(getSupportFragmentManager()));

        mViewPager.setOnPageChangeListener(new HPOnPageChangeListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
