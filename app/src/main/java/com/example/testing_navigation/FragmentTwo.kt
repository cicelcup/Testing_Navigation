package com.example.testing_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = getString(R.string.it_comes_from)
        view.findViewById<Button>(R.id.button2to1)
            .setOnClickListener {
                findNavController()
                    .navigate(FragmentTwoDirections
                        .actionFragmentTwoToFragmentOne("$name 2 to 1")) }
        view.findViewById<Button>(R.id.button2to3)
            .setOnClickListener {
                findNavController()
                    .navigate(FragmentTwoDirections
                        .actionFragmentTwoToFragmentThree("$name 2 to 3"))
            }
        view.findViewById<TextView>(R.id.whereItComesFragment2)
            .text = arguments?.let { FragmentTwoArgs.fromBundle(it).name }
    }
}
