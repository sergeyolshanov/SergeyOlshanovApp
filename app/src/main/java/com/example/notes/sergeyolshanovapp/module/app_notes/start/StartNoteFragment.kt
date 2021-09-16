package com.example.notes.sergeyolshanovapp.module.app_notes.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.sergeyolshanovapp.R
import com.example.notes.sergeyolshanovapp.databinding.FragmentStartNoteBinding
import com.example.notes.utilits.*

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
            mViewModel?.initDatabase(TYPE_ROOM) {
                APP_ACTIVITY?.navController?.navigate(R.id.action_startNoteFragment_to_mainNoteFragment)

            }
        }

        mBinding?.buttonFirebase?.setOnClickListener {
            mBinding?.groupFirebase?.visibility = View.VISIBLE
            mBinding?.buttonLogin?.setOnClickListener {
                val inputEmail = mBinding?.inputEmail?.text.toString()
                val inputPassword = mBinding?.inputPassword?.text.toString()
                if(inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                    EMAIL = inputEmail
                    PASSWORD = inputPassword
                    mViewModel?.initDatabase(TYPE_FIREBASE) {
                        showToast("INIT OK")
                        //APP_ACTIVITY?.navController?.navigate(R.id.action_startNoteFragment_to_mainNoteFragment)
                    }
                } else {
                    showToast(getString(R.string.toast_wrong_enter))
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}