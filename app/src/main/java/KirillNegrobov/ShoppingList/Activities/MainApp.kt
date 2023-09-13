package KirillNegrobov.ShoppingList.Activities

import KirillNegrobov.ShoppingList.DB.MainDataBase
import android.app.Application

class MainApp:Application() {
    val database by lazy {
        MainDataBase.getDataBase(this)
    }

}