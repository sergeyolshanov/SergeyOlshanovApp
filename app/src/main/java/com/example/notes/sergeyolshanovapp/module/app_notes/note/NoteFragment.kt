package com.example.notes.sergeyolshanovapp.module.app_notes.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.sergeyolshanovapp.R
import com.example.notes.sergeyolshanovapp.databinding.FragmentMainNoteBinding
import com.example.notes.sergeyolshanovapp.databinding.FragmentNoteBinding
import com.example.notes.sergeyolshanovapp.module.app_notes.main_note.MainNoteAdapter
import com.example.notes.sergeyolshanovapp.module.app_notes.main_note.MainNoteViewModel
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.example.notes.utilits.APP_ACTIVITY


class NoteFragment : Fragment() {

    private var binding: FragmentNoteBinding? = null
    private val mBinding get() = binding
    private var mViewModel: NoteViewModel? = null
    private var mCurrentNote: AppNote? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mBinding?.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mBinding?.noteName?.text = mCurrentNote?.name
        mBinding?.noteText?.text = mCurrentNote?.text
        /** Подключение добавления элементов меню в тулбар */
        setHasOptionsMenu(true)
    }

    /**Отображение элемента корзины в меню*/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    /**Слушаем клики по элементу корзины в меню*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.button_delete -> {
                mViewModel?.delete(mCurrentNote!!){
                    APP_ACTIVITY?.navController?.navigate(R.id.action_noteFragment_to_mainNoteFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}