package com.example.dialogfragmentdemo

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogFragment : androidx.fragment.app.DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var clickListener: ClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        clickListener = context as ClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("DialogFragment", "$param1::$param2")
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)
        param1.also { view.findViewById<TextView>(R.id.titleText).text = it }
        param2.also { view.findViewById<TextView>(R.id.subtitleText).text = it }

        view.findViewById<Button>(R.id.doneBtn).setOnClickListener {

            val alertDialogBuilder:AlertDialog.Builder=AlertDialog.Builder(requireActivity())
            alertDialogBuilder.setMessage("Are you sure, Yow wanted to make decision")
            alertDialogBuilder.setPositiveButton("Yes",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    clickListener.onDoneClicked(param1!!,param2!!)
                    this@DialogFragment.dismiss()
                    dialog?.dismiss()
                }

            })
            alertDialogBuilder.setNegativeButton("No"
            ) { dialog, which ->
                Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show();









        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    interface ClickListener {
        fun onDoneClicked(param1: String, param2: String)
    }
}