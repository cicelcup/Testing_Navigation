package com.example.testing_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import java.sql.RowId


class FragmentThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = getString(R.string.it_comes_from)
        view.findViewById<Button>(R.id.button3to1)
            .setOnClickListener {
                findNavController()
                    .navigate(FragmentThreeDirections
                        .actionFragmentThreeToFragmentOne("$name 3 to 1"))
            }
        view.findViewById<Button>(R.id.button3to2)
            .setOnClickListener {
                findNavController().navigate(FragmentThreeDirections
                    .actionFragmentThreeToFragmentTwo("$name 3 to 2"))
            }
        view.findViewById<TextView>(R.id.whereItComesFragment3)
            .text = arguments?.let { FragmentThreeArgs.fromBundle(it).name }
    }
}
