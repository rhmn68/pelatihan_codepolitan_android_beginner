package com.rahmanaulia.latihanfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddHome.setOnClickListener {
            val addFragment = AddFragment()
            //Untuk mengirim data antar fragment
            val bundle = Bundle()
            bundle.putString(AddFragment.EXTRA_TITLE, "Add")
            addFragment.arguments = bundle

            //Untuk menggunakan function MainActivity di Fragment
            (activity as MainActivity).replaceFragment(addFragment)
        }
    }

}
