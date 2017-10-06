package com.popland.pop.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // android 4.4+ don't need this to show 3 dots(Menu Button)
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            // presumably, not relevant
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
 //       menu.add(1,111,1,"Them");           // cách 2
//        menu.add(1,222,2,"Xoa");
//        menu.add(1,333,3,"Sua");
//
//        SubMenu subMenu = menu.addSubMenu(1,444,4,"Lien he");
//        subMenu.add(5,555,1,"email");
//        subMenu.add(5,666,2,"phone");

//        MenuItem menuItem = menu.add(1,777,5,"Share");
//        menuItem.setIcon(R.mipmap.ic_launcher);
//        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this,"menuSetting",Toast.LENGTH_LONG).show(); break;
            case R.id.about:
                Toast.makeText(MainActivity.this,"about",Toast.LENGTH_LONG).show(); break;
            case R.id.menuShare:
                Toast.makeText(MainActivity.this,"menuShare",Toast.LENGTH_LONG).show();  break;
        }
        return super.onOptionsItemSelected(item);
    }
}
