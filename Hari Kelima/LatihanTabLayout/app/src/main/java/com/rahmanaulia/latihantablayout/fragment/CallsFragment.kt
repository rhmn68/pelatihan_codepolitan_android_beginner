package com.rahmanaulia.latihantablayout.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.rahmanaulia.latihantablayout.R
import com.rahmanaulia.latihantablayout.adapter.ContactAdapter
import com.rahmanaulia.latihantablayout.repository.Repository
import kotlinx.android.synthetic.main.fragment_calls.*

/**
 * A simple [Fragment] subclass.
 */
class CallsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ContactAdapter(Repository.getDataCalls())
        adapter.notifyDataSetChanged()

        rvCalls.layoutManager = LinearLayoutManager(context)
        rvCalls.adapter = adapter
    }

}
