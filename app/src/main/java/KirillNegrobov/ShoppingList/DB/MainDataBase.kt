package KirillNegrobov.ShoppingList.DB

import KirillNegrobov.ShoppingList.Entities.LibraryItem
import KirillNegrobov.ShoppingList.Entities.NoteItem
import KirillNegrobov.ShoppingList.Entities.ShoppingListItem
import KirillNegrobov.ShoppingList.Entities.ShoppingListNames
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LibraryItem::class, NoteItem::class, ShoppingListItem::class, ShoppingListNames::class],
    version = 1
)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.bd"
                ).allowMainThreadQueries().build()
                instance
            }
        }
    }
}
