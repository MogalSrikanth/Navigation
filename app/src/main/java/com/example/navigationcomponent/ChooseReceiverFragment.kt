package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*


class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //in choose fragment we have two buttons 1.next 2. cancel
        //so, when we click on next it should navigate to send_money_to_user
        btnnext.setOnClickListener {

            val reciverName = enterReceiverName.text.toString()
            // so what ever the name we give will get here
//            val args = Bundle()// to pass the data we use bundle
//            args.putString("name", reciverName)
//            findNavController().navigate(R.id.sendCashFragment, args,navOption)
            // u can also pass animations under click listener by navOption, and mention that navOption beside args.
            val action = ChooseReceiverFragmentDirections.
            actionChooseReceiverFragmentToSendCashFragment(reciverName)
            findNavController().navigate(action)

            btncancel.setOnClickListener {
                findNavController().popBackStack()
            }


        }
    }
}