package com.example.notes.sergeyolshanovapp.module.appnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.sergeyolshanovapp.databinding.FragmentStartNoteBinding

class StartNoteFragment : Fragment() {

    private var binding: FragmentStartNoteBinding? = null
    private val mBinding get() = binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentStartNoteBinding.inflate(layoutInflater, container, false)

        return mBinding?.root
    }

}