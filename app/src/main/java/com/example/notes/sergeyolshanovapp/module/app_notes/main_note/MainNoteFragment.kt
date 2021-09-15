package com.example.notes.sergeyolshanovapp.module.app_notes.main_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.sergeyolshanovapp.R
import com.example.notes.sergeyolshanovapp.databinding.FragmentMainNoteBinding
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.example.notes.utilits.APP_ACTIVITY

class MainNoteFragment : Fragment() {

    private var binding: FragmentMainNoteBinding? = null
    private val mBinding get() = binding
    private var mViewModel: MainNoteViewModel? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: MainNoteAdapter? = null
    private var mObserverList: Observer<List<AppNote>>? = null

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
        mAdapter = MainNoteAdapter()
        mRecyclerView = mBinding?.recyclerView
        mRecyclerView?.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter?.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainNoteViewModel::class.java)
        mViewModel?.allNotes?.observe(this, mObserverList!!)
        mBinding?.buttonCreateNote?.setOnClickListener {
            APP_ACTIVITY?.navController?.navigate(R.id.action_mainNoteFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        mViewModel?.allNotes?.removeObserver(mObserverList!!)
        mRecyclerView?.adapter = null
    }

}