package com.main.test4.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.main.test4.R;
import com.main.test4.fragment.TableDetailFragment;
import com.main.test4.fragment.TablesFragment;
import com.main.test4.model.Table;

public class MainActivity extends AppCompatActivity implements TablesFragment.OnTableSelectedListener, TableDetailFragment.OnTicketClosedListener {

    public final static String TABLE_NUMBER_EXTRA = "extraTableNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.tables_activity_title);
    }

    @Override
    public void onTableSelected(Table table) {
        if (table != null) {
            FrameLayout fragmentLayout = (FrameLayout) findViewById(R.id.fragment_table_detail);
            if (fragmentLayout != null) {
                // If current view contains a layout to display table information then
                // a TableDetailFragment is loaded inside it
                TableDetailFragment fragment = TableDetailFragment.newInstance(table.getNumber());
                getFragmentManager().beginTransaction().replace(R.id.fragment_table_detail, fragment).commit();
            } else {

                // Else table courses are displayed inside a new activity providing table
                // selected number
                Intent intent = new Intent(this, TableDetailActivity.class);
                intent.putExtra(TABLE_NUMBER_EXTRA, table.getNumber());

                startActivity(intent);
            }
        } else {

            // If no table is selected then fragment is removed from the view
            Fragment fragment = getFragmentManager().findFragmentById(R.id.fragment_table_detail);
            if (fragment != null) {
                getFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }
    }

    @Override
    public void onTicketClosed(int tableNumber) {
        onTableSelected(null);
    }
}
