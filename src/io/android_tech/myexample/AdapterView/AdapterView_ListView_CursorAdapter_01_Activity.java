package io.android_tech.myexample.AdapterView;

import android.Manifest;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class AdapterView_ListView_CursorAdapter_01_Activity extends ListActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private static final String[] CONTACT_PROJECTION = new String[]{Contacts._ID, Contacts.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
    private static final int viewList[] = {android.R.id.text1, android.R.id.text2};

    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            startQuery();
        }
    }

    private void startQuery() {
        mAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, null,
                new String[]{Contacts.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
                viewList, 0);
        setListAdapter(mAdapter);

        LoaderManager.LoaderCallbacks<Cursor> loaderCallbacks = this;
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, loaderCallbacks);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startQuery();
            } else {
                Toast.makeText(this, "연락처에 대한 권한이 없어 실행할수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                CONTACT_PROJECTION, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);

    }
}
