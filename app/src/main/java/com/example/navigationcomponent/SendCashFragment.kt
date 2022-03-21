package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash){

    private  val args : SendCashFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.receiverName
        // argument bundle is null for null safety we used '?'
        Receivername.text ="send cash to $receiverName"

        btnsend.setOnClickListener {

            if(enterCash.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "please enter amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val amount = enterCash.text.toString().toLong()
           val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(receiverName, amount)
            findNavController().navigate(action)
        }
        btndone.setOnClickListener {
            val action= SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        btncancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,true)
        }


    }

}
