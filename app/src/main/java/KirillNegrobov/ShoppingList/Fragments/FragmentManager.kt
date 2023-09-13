package KirillNegrobov.ShoppingList.Fragments

import KirillNegrobov.ShoppingList.R
import androidx.appcompat.app.AppCompatActivity

object FragmentManager {
    var currentFrag: BaseFragment? = null

    fun setFragment(newFragment: BaseFragment,activity: AppCompatActivity){
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder,newFragment)
        transaction.commit()
        currentFrag = newFragment
    }
}