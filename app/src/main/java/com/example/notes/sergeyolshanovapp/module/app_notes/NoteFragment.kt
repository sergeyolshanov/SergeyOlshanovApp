package com.example.notes.sergeyolshanovapp.module.app_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.sergeyolshanovapp.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {

    private var binding: FragmentNoteBinding? = null
    private val mBinding get() = binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)

        return mBinding?.root
    }
}