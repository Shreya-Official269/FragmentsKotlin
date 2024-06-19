package com.example.fragmentskotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val textView: TextView = view.findViewById(R.id.textViewOutput)
        val bundle = arguments
        if (bundle != null) {
            val input = bundle.getString("inputKey")
            textView.text = input
        }
        return view
    }
}