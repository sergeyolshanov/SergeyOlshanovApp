package com.example.notes.sergeyolshanovapp.module.app_notes.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.sergeyolshanovapp.R
import com.example.notes.sergeyolshanovapp.databinding.FragmentAddNewNoteBinding
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.example.notes.utilits.APP_ACTIVITY
import com.example.notes.utilits.showToast


class AddNewNoteFragment : Fragment() {

    private var binding: FragmentAddNewNoteBinding? = null
    private val mBinding get() = binding
    private var mViewModel: AddNewNoteViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)

        return mBinding?.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding?.buttonAddNote?.setOnClickListener {
            val name = mBinding?.inputNameNote?.text.toString()
            val text = mBinding?.inputTextNote?.text.toString()
            if(name.isEmpty()) {
                showToast(getString(R.string.toast_enter_name))
            } else {
                mViewModel?.insert(AppNote(name = name, text = text)) {
                    APP_ACTIVITY?.navController?.navigate(R.id.action_addNewNoteFragment_to_mainNoteFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}