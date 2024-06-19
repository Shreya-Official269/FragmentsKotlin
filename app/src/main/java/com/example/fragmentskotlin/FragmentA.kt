package com.example.fragmentskotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    private var listener: FragmentAListener? = null
    private lateinit var editText: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement FragmentAListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.editTextInput)
        val button: Button = view.findViewById(R.id.buttonToFragmentB)
        button.setOnClickListener {
            val input = editText.text.toString()
            listener?.onInputASent(input)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}