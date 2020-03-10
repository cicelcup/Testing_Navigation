package com.example.testing_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = getString(R.string.it_comes_from)
        view.findViewById<Button>(R.id.button1to2)
            .setOnClickListener {
                findNavController().navigate(FragmentOneDirections
                    .actionFragmentOneToFragmentTwo())
            }
        view.findViewById<Button>(R.id.button1to3)
            .setOnClickListener {
                findNavController()
                    .navigate(FragmentOneDirections
                        .actionFragmentOneToFragmentThree("$name 1 to 3"))
            }
        view.findViewById<TextView>(R.id.whereItComesFragment1)
            .text = arguments?.let { FragmentOneArgs.fromBundle(it).name }
    }
}
