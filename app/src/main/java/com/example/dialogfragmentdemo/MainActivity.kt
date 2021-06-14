package com.example.dialogfragmentdemo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(),DialogFragment.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.showDialogButton).setOnClickListener {
            //Create and show the dialog
            val newFragment = DialogFragment.newInstance("FIRST TITLE", "FIRST SUBTITLE")
            newFragment.show(supportFragmentManager, DialogFragment.TAG)
        }
    }

    override fun onDoneClicked(param1: String, param2: String) {
      Toast.makeText(this,"Result $param1:::$param2",Toast.LENGTH_SHORT).show()
    }
}