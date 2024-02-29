package com.example.apiwiederholung

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apiwiederholung.api.api
import com.example.apiwiederholung.databinding.FragmentApiBinding


class ApiFragment : Fragment() {

    private val viewmodel: MainViewmodel by activityViewModels()
    private lateinit var binding: FragmentApiBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApiBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.getRandomQuote()

        viewmodel.randomQuote.observe(viewLifecycleOwner){

            binding.quoteTV.text = it.content
            binding.authorTV.text = it.author


        }


    }

}