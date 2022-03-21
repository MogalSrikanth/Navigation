package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*
import kotlinx.android.synthetic.main.fragment_home.*


class ConfirmDialogFragment : BottomSheetDialogFragment(){

    private val args:ConfirmDialogFragmentArgs by navArgs()

    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)
        //Remove super.onCreateView(inflater, container, savedInstanceState) and return inflater
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.recieiverName
        val amount = args.amount
        tv_confirmMsg.text = "Do you want to send Rs.$amount to $receiverName ?"
        
        btn_yes.setOnClickListener {
            Toast.makeText(requireContext(), "$amount has been send to $receiverName ", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        btn_no.setOnClickListener {
            dismiss()
        }


    }
}


