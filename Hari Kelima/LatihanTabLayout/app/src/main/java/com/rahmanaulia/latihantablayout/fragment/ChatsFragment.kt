package com.rahmanaulia.latihantablayout.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmanaulia.latihantablayout.R
import com.rahmanaulia.latihantablayout.adapter.ContactAdapter
import com.rahmanaulia.latihantablayout.repository.Repository
import kotlinx.android.synthetic.main.fragment_chats.*

/**
 * A simple [Fragment] subclass.
 */
class ChatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ContactAdapter(Repository.getDataChats())
        adapter.notifyDataSetChanged()

        rvChats.layoutManager = LinearLayoutManager(context)
        rvChats.adapter = adapter
    }
}
