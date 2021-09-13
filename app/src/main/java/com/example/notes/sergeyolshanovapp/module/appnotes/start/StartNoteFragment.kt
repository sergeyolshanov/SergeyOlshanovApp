package com.example.notes.sergeyolshanovapp.module.appnotes.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.sergeyolshanovapp.databinding.FragmentStartNoteBinding
import com.example.notes.utilits.TYPE_ROOM

class StartNoteFragment : Fragment() {

    private var binding: FragmentStartNoteBinding? = null
    private val mBinding get() = binding
    private var mViewModel: StartNoteViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartNoteBinding.inflate(layoutInflater, container, false)

        return mBinding?.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mViewModel = ViewModelProvider(this).get(StartNoteViewModel::class.java)
        mBinding?.buttonRoom?.setOnClickListener {
            mViewModel?.initDatabase(TYPE_ROOM)
        }
    }


}