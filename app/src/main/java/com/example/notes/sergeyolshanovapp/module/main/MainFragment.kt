package com.example.notes.sergeyolshanovapp.module.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.sergeyolshanovapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val menuBinding get() = binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)


        return menuBinding?.root
    }

    private fun subscribeFirstButton() {
        menuBinding?.button1?.setOnClickListener {

        }
    }

}