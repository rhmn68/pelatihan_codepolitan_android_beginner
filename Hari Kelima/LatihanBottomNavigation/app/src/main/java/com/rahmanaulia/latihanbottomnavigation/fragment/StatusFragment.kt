package com.rahmanaulia.latihanbottomnavigation.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmanaulia.latihanbottomnavigation.R
import com.rahmanaulia.latihanbottomnavigation.adapter.ContactAdapter
import com.rahmanaulia.latihanbottomnavigation.repository.Repository
import kotlinx.android.synthetic.main.fragment_status.*

/**
 * A simple [Fragment] subclass.
 */
class StatusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ContactAdapter(Repository.getDataStatuses())
        adapter.notifyDataSetChanged()

        rvStatus.layoutManager = LinearLayoutManager(context)
        rvStatus.adapter = adapter
    }

}
