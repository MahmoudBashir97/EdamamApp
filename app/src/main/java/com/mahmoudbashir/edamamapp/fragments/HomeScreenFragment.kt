package com.mahmoudbashir.edamamapp.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.edamamapp.R
import com.mahmoudbashir.edamamapp.databinding.FragmentHomeScreenBinding
import com.mahmoudbashir.edamamapp.viewModel.AnalysisViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class HomeScreenFragment : Fragment() {

     private val TAG = "HomeScreenFragment"
     lateinit var homeScreenBinding: FragmentHomeScreenBinding
     val viewModel by inject<AnalysisViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeScreenBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_screen, container, false)


        return homeScreenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeScreenBinding.analysisBtn.setOnClickListener {
            homeScreenBinding.isLoading = true
            if (checkValidate()){
                viewModel.getAnalysis(homeScreenBinding.edtQuery.text.toString())
                GlobalScope.launch { delay(500) }
                observingOnResponseData()
            }
        }

    }

    private fun checkValidate():Boolean{
        if (TextUtils.isEmpty(homeScreenBinding.edtQuery.text.toString())){
            homeScreenBinding.isLoading = false
            homeScreenBinding.edtQuery.error = "please enter a validate inputs"
            homeScreenBinding.edtQuery.requestFocus()
            return false
        }
        return true
    }

    private fun observingOnResponseData(){
        viewModel.analysisResult.observe(viewLifecycleOwner,{
            result ->
            if (result != null){
                Log.d(TAG,"ResultResponse : success")
                homeScreenBinding.newRecipeBtn.setBackgroundResource(R.drawable.btns_back)
                homeScreenBinding.isLoading = false
            }
        })
    }

}