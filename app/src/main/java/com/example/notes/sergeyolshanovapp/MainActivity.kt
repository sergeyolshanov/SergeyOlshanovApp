package com.example.notes.sergeyolshanovapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.notes.sergeyolshanovapp.databinding.ActivityMainBinding
import com.example.notes.utilits.APP_ACTIVITY


class MainActivity : AppCompatActivity() {

    var navController: NavController? = null
    var mToolbar: Toolbar? = null
    private var binding: ActivityMainBinding? = null
    val mBinding get() = binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)
        APP_ACTIVITY = this
        mToolbar = mBinding?.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        title = getString(R.string.main_title)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}