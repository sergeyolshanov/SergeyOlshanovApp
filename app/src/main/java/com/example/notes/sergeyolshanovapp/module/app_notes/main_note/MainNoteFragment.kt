package com.example.notes.sergeyolshanovapp.module.app_notes.main_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.sergeyolshanovapp.R
import com.example.notes.sergeyolshanovapp.databinding.FragmentMainNoteBinding
import com.example.notes.utilits.APP_ACTIVITY

class MainNoteFragment : Fragment() {

    private var binding: FragmentMainNoteBinding? = null
    private val mBinding get() = binding
    private var mViewModel: MainNoteViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentMainNoteBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mViewModel = ViewModelProvider(this).get(MainNoteViewModel::class.java)
        mBinding?.buttonAddNote?.setOnClickListener {
            APP_ACTIVITY?.navController?.navigate(R.id.action_mainNoteFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}