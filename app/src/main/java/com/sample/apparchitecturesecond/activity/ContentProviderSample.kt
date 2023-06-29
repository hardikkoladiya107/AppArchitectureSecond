package com.sample.apparchitecturesecond.activity

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.sample.apparchitecturesecond.R
import com.sample.apparchitecturesecond.databinding.ActivityContentProviderSampleBinding


class ContentProviderSample : AppCompatActivity() {
    lateinit var binding: ActivityContentProviderSampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_content_provider_sample)
        initViews();
        askPermission();
        initListner()
    }
    var list = arrayOf(Manifest.permission.READ_CONTACTS,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS)
    private fun askPermission() {
//        list.forEach {
//            if (ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
//            ) {
//
//            }else{
//
//            }
//        }

        ActivityCompat.requestPermissions(this, list, 1);
    }

    private fun initViews() {
        /**
         * Access content provider
         * */
        var CONTENT_URI: Uri? = Uri.parse("content://com.demo.user.provider/users")
    }

    private fun initListner() {
        binding.button.setOnClickListener {

            var cusror = this.contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC "
            )
            Log.e("TAG", "contactprovider: ");
            while (cusror!!.moveToNext()){
            //    val hasPhone: Int = cusror.getInt(cusror.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

            }

            cusror.close()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}