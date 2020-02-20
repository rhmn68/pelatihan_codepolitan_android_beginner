package com.rahmanaulia.latihanfragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add.*

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    companion object{
        const val EXTRA_TITLE = "extra_title"
    }

    private var title: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        processAdd()
    }

    private fun processAdd() {
        btnSubmitAdd.setOnClickListener {
            val number1 = etNumber1Add.text.toString().toDouble()
            val number2 = etNumber2Add.text.toString().toDouble()

            val result = number1 + number2
            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra(ResultActivity.EXTRA_TITLE, title)
            intent.putExtra(ResultActivity.EXTRA_RESULT, result)
            startActivity(intent)
        }
    }

    private fun getData() {
        if (arguments != null){
            title = arguments?.getString(EXTRA_TITLE)

            btnSubmitAdd.text = title
            tvTitleAdd.text = title
        }
    }
}
