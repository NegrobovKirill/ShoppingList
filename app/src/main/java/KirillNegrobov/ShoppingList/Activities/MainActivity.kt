package KirillNegrobov.ShoppingList.Activities

import KirillNegrobov.ShoppingList.R
import KirillNegrobov.ShoppingList.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    private fun setBottomNavListener(){
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.settings->{

                }
                R.id.notes->{

                }
                R.id.shop_list->{

                }
                R.id.new_item->{

                }
            }
            true
        }
    }
}