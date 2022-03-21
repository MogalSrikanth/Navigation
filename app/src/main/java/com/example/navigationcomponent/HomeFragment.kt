package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //NavController().navigate(R.id.viewBalanceFragment)
        //we have to take this for every fragment instead of that we can use object
        // val navController = findNavController()

        val navController = findNavController()
        btn_view_balance.setOnClickListener(){
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            // given home fragment directions to vew balance action
            //replace R.id.action_homeFragment_to_ViewBalanceFragment with action
            navController.navigate (action)
           //navController.navigate (R.id.viewBalanceFragment) changed to action
        }
        btn_view_transactions.setOnClickListener(){
            //we can also navigate through passing through Id but animation won't work out
            // in these case we remove action and give animation here itself and build it
            val navOption = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
            //Nav options have been build now we have to call build method
                .build()
            // have to pass navOption object here along with Id in navController
            //but we get error because there is no method which takes both id and navOption
            //to overcome this we pass bundle null
            navController.navigate (R.id.viewTransactionFragment,null, navOption)
            //val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment2()
            //navController.navigate (action)
        }
        btn_send_money .setOnClickListener(){
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate (action)
        }



    }
}