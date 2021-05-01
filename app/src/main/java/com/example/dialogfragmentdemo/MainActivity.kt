package com.example.dialogfragmentdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.showDialogButton).setOnClickListener {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = supportFragmentManager.findFragmentByTag("dialog")
            if (fragment != null) {
                ft.remove(fragment)
            }
            ft.addToBackStack(null)
            //Create and show the dialog
            val newFragment = DialogFragment.newInstance("FIRST TITLE", "FIRST SUBTITLE")
            newFragment.show(ft, "dialog")
        }
    }
}