package com.main.test4.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.main.test4.R;
import com.main.test4.fragment.TableDetailFragment;

public class TableDetailActivity extends AppCompatActivity implements TableDetailFragment.OnTicketClosedListener {

    private int mTableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTableNumber = getIntent().getIntExtra(MainActivity.TABLE_NUMBER_EXTRA, -1);
        setTitle(String.format(getString(R.string.table_number_string), mTableNumber));

        // Displays table information inside a TableDetailFragment
        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment_table_detail) == null) {
            fm.beginTransaction()
                    .add(R.id.fragment_table_detail, TableDetailFragment.newInstance(mTableNumber))
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean superResult = super.onOptionsItemSelected(item);

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return superResult;
    }

    @Override
    public void onTicketClosed(int tableNumber) {
        finish();
    }
}
